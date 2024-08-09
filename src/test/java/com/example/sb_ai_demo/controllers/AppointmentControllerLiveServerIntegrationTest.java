package com.example.sb_ai_demo.controllers;

import com.example.sb_ai_demo.entities.Appointment;
import com.example.sb_ai_demo.entities.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerLiveServerIntegrationTest {

    @LocalServerPort
    private int port;

    private RestClient restClient;

    @BeforeEach
    void setUp() {
        restClient = RestClient.create("http://localhost:" + port);
    }

    @Test
    public void testGetAllAppointments() {
        List<Appointment> appointments = restClient.get()
                .uri("/api/appointments")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Appointment>>() {});

        assertNotNull(appointments);
        assertFalse(appointments.isEmpty());
    }

    @Test
    public void testGetAppointmentById() {
        Appointment appointment = restClient.get()
                .uri("/api/appointments/{id}", 1)
                .retrieve()
                .body(Appointment.class);

        assertNotNull(appointment);
        assertEquals(1, appointment.getAppointmentId());
    }

    @Test
    public void testCreateAppointment() {
        Appointment newAppointment = new Appointment();
        Pet pet = new Pet();
        pet.setPetId(1);
        newAppointment.setPet(pet); // You might need to set up a Pet object
        newAppointment.setDate(new Date());
        newAppointment.setTime(new Time(System.currentTimeMillis()));
        newAppointment.setReason("Check-up");

        Appointment createdAppointment = restClient.post()
                .uri("/api/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newAppointment)
                .retrieve()
                .body(Appointment.class);

        assertNotNull(createdAppointment);
        assertNotNull(createdAppointment.getAppointmentId());
        assertEquals("Check-up", createdAppointment.getReason());

        int appId = createdAppointment.getAppointmentId();

        restClient.delete()
                .uri("/api/appointments/{id}", appId)
                .retrieve()
                .toBodilessEntity();
    }

    @Test
    public void testUpdateAppointment() {
        Appointment appointmentToUpdate = restClient.get()
                .uri("/api/appointments/{id}", 10)
                .retrieve()
                .body(Appointment.class);

        assertNotNull(appointmentToUpdate);

        appointmentToUpdate.setReason("Follow-up");

        Appointment updatedAppointment = restClient.put()
                .uri("/api/appointments/{id}", 10)
                .contentType(MediaType.APPLICATION_JSON)
                .body(appointmentToUpdate)
                .retrieve()
                .body(Appointment.class);

        assertNotNull(updatedAppointment);
        assertEquals("Follow-up", updatedAppointment.getReason());
    }

    @Test
    public void testDeleteAppointment() {
        restClient.delete()
                .uri("/api/appointments/{id}", 24565498)
                .retrieve()
                .toBodilessEntity();

        // assertThrows(Exception.class, () -> {
        //     restClient.get()
        //             .uri("/api/appointments/{id}", 2)
        //             .retrieve()
        //             .body(Appointment.class);
        // });
    }

    // @Test
    public void testGetAppointmentByLastName() {
        List<Appointment> appointments = restClient.get()
                .uri("/api/appointments/search?lastname={lastName}", "Doe")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Appointment>>() {});

        assertNotNull(appointments);
        assertFalse(appointments.isEmpty());
        appointments.forEach(appointment -> 
            assertTrue(appointment.getPet().getOwner().getLastName().equalsIgnoreCase("Doe")));
    }
}