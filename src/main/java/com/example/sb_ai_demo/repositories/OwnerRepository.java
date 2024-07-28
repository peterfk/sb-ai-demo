package com.example.sb_ai_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sb_ai_demo.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    @Query("select u from Owner u where u.email = ?1")
    Owner findByEmailAddress(String emailAddress);

    @Query("select u from Owner u where u.firstName like ?1%")
    List<Owner> findByFirstnameStartsWith(String firstname);

    @Query("select u from Owner u where u.firstName = :firstname or u.lastName = :lastname")
    List<Owner> findByLastnameOrFirstname(@Param("lastname") String lastname,
            @Param("firstname") String firstname);

}
