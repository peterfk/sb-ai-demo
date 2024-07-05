::: mermaid
erDiagram
    Owners ||--o{ Pets : has
    Pets ||--o{ Appointments : schedules
    Pets ||--o{ Vaccinations : receives
    Pets ||--o{ Medications : takes
    Appointments ||--|| Visits : results_in
    Visits ||--o{ LabResults : includes
    Visits ||--o{ Imaging : includes
    Users }|--|| UserRoles : has

    Owners {
        int owner_id PK
        string first_name
        string last_name
        string email
        string phone
        string address
    }

    Pets {
        int pet_id PK
        int owner_id FK
        string name
        string species
        string breed
        int age
        decimal weight
        string sex
    }

    Appointments {
        int appointment_id PK
        int pet_id FK
        date date
        time time
        string reason
    }

    Vaccinations {
        int vaccination_id PK
        int pet_id FK
        string vaccine_type
        date administration_date
        date expiration_date
    }

    Medications {
        int medication_id PK
        int pet_id FK
        string medication_name
        string dosage
        string administration_method
        date start_date
        date end_date
    }

    Visits {
        int visit_id PK
        int appointment_id FK
        date visit_date
        string chief_complaint
        string examination_findings
        string diagnosis
        string treatment
    }

    LabResults {
        int lab_result_id PK
        int visit_id FK
        string test_name
        decimal result
        string units
        string reference_range
    }

    Imaging {
        int imaging_id PK
        int visit_id FK
        string study_type
        string image_url
    }

    Users {
        int user_id PK
        string username
        string password
        string role
    }

    UserRoles {
        int user_id PK,FK
        string role PK
    }
:::
