package miu.edu.cs489.lesson6;

import miu.edu.cs489.lesson6.model.*;
import miu.edu.cs489.lesson6.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private AddressService addressService;
    private DentistService dentistService;
    private PatientService patientService;
    private SurgeryService surgeryService;
    private AppointmentService appointmentService;

    public Application(AddressService addressService, DentistService dentistService, PatientService patientService, SurgeryService surgeryService, AppointmentService appointmentService) {
        this.addressService = addressService;
        this.dentistService = dentistService;
        this.patientService = patientService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var address1 = new Address(null,"Fairfield", "Iowa", "52557");
        var address2 = new Address(null,"Des Moines", "Iowa", "55557");
        var address3 = new Address(null,"123 Main St", "City3", "12345");
        var address4 = new Address(null,"456 Elm St", "City4", "67890");
        var address5 = new Address(null,"789 Oak St", "City5", "13579");
        var address6 = new Address(null,"500 5th St", "City6", "13520");

        List<Appointment> appointments = getAppointments();

        // Populate the attributes of Dentist
        var dentist1 = new Dentist(null, "John", "Doe", "1234567890", "john.doe@example.com", "General Dentistry", null);
        var dentist2 = new Dentist(null, "Maria", "Silva", "1234567810", "maria.doe@example.com", "General Dentistry", null);
        var dentist3 = new Dentist(null, "Ana", "Pereira", "1234567820", "ana.doe@example.com", "General Dentistry", null);

        // Populate the attributes of patient
        var patient1 = new Patient(null, "Paul", "Gomes", "P10", "1234567890", "john.doe@example.com", LocalDate.of(1990, 5, 15), null, null);
        var patient2 = new Patient(null,"Jane", "Smith", "P15", "0987654321", "jane.smith@example.com", LocalDate.of(1985, 9, 20), null, null);
        var patient3 = new Patient(null,"Alice", "Johnson", "P20", "9876543210", "alice.johnson@example.com", LocalDate.of(1975, 3, 10), null, null);
        // Populate the attributes of surgery
        var surgery1 = new Surgery(null,"Surgery 1","S10", "1234567890", address4, null);
        var surgery2 = new Surgery(null,"Surgery 2", "S15", "0987654321", address5, null);
        var surgery3 = new Surgery(null,"Surgery 3", "S20", "9876543210", address6, null);

        // Populate the attributes of appointment
        var appointments1 = new Appointment(null, LocalDateTime.of(2024, 4, 10, 10, 0), dentist1, surgery1, patient1);
        var appointments2 = new Appointment(null, LocalDateTime.of(2023, 4, 11, 11, 30), dentist1, surgery2, patient2);
        var appointments3 = new Appointment(null, LocalDateTime.of(2022, 4, 12, 14, 15), dentist2, surgery3, patient3);
        var appointments4 = new Appointment(null, LocalDateTime.of(2021, 4, 13, 9, 45), dentist3, surgery1, patient1);
        var appointments5 = new Appointment(null, LocalDateTime.of(2020, 4, 14, 12, 0), dentist2, surgery2, patient3);

        address1 = addressService.register(address1);
        address2 = addressService.register(address2);
        address3 = addressService.register(address3);
        address4 = addressService.register(address4);
        address5 = addressService.register(address5);
        address6 = addressService.register(address6);

        dentist1.setAppointments(Arrays.asList(appointments1, appointments2));
        dentist1 = dentistService.registerOne(dentist1);
        appointments1.setDentist(dentist1);
        appointments2.setDentist(dentist1);
        dentist2.setAppointments(Arrays.asList(appointments3, appointments5));
        dentist2 = dentistService.registerOne(dentist2);
        appointments3.setDentist(dentist2);
        appointments5.setDentist(dentist2);
        dentist3 = dentistService.registerOne(dentist3);
        dentist3.setAppointments(Arrays.asList(appointments4));
        appointments4.setDentist(dentist3);

        patient1.setAddress(address1);
        patient1.setAppointments(Arrays.asList(appointments1, appointments4));
        patient1 = patientService.registerOne(patient1);
        appointments1.setPatient(patient1);
        appointments4.setPatient(patient1);
        patient2.setAddress(address2);
        patient2.setAppointments(Arrays.asList(appointments2));
        patient2 = patientService.registerOne(patient2);
        appointments2.setPatient(patient2);
        patient3.setAddress(address3);
        patient3.setAppointments(Arrays.asList(appointments3, appointments5));
        patient3 = patientService.registerOne(patient3);
        appointments3.setPatient(patient3);

        surgery1.setAddress(address4);
        surgery1.setAppointments(Arrays.asList(appointments1, appointments4));

        surgery1 = surgeryService.registerOne(surgery1);
        appointments1.setSurgery(surgery1);
        appointments4.setSurgery(surgery1);

        surgery2.setAddress(address5);
        surgery2.setAppointments(Arrays.asList(appointments2, appointments5));

        surgery2 = surgeryService.registerOne(surgery2);
        appointments2.setSurgery(surgery2);
        appointments5.setSurgery(surgery2);

        surgery3.setAddress(address6);
        surgery3.setAppointments(Arrays.asList(appointments3));
        surgery3 = surgeryService.registerOne(surgery3);
        appointments3.setSurgery(surgery3);

        appointmentService.registerAll(Arrays.asList(appointments1, appointments2, appointments3, appointments4, appointments5));
        formatOutput(appointmentService.getAll());

       // addressService.findAll().stream().forEach(System.out::println);

    }

    private void formatOutput(List<Appointment> appointments) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Dentist Name", "Patient Number", "Patient Name", "Appointment DateTime", "Surgery number");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        for (Appointment appointment : appointments) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    appointment.getDentist().getFullName(),
                    appointment.getPatient().getPatientNumber(),
                    appointment.getPatient().getFullName(),
                    appointment.getAppointmentDate(),
                    appointment.getSurgery().getSurgeryNumber());

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    static List<Appointment> getAppointments() {
        // Your implementation to create appointments
        return null;
    }
}
