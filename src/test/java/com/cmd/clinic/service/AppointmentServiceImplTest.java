package com.cmd.clinic.service;

import com.cmd.clinic.dto.AppointmentDTO;
import com.cmd.clinic.entity.Appointment;
import com.cmd.clinic.mapper.AppointmentMapper;
import com.cmd.clinic.repository.AppointmentRepository;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




public class AppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAppointment_Success() {
        // 1. Arrange (Create fake input and expected output)
        AppointmentDTO inputDto = AppointmentDTO.builder()
                .clinicId(1L)
                .doctorId(1L)
                .appointmentDate(LocalDate.now().plusDays(1))
                .appointmentTime(LocalTime.of(10, 30))
                .patientName("Riya Sen")
                .patientEmail("riya@example.com")
                .patientPhone("9876543210")
                .reason("Follow-up")
                .status("Scheduled")
                .build();

        Appointment fakeEntity = Appointment.builder()
                .appointmentId(1L)
                .clinicId(1L)
                .doctorId(1L)
                .appointmentDate(inputDto.getAppointmentDate())
                .appointmentTime(inputDto.getAppointmentTime())
                .patientName(inputDto.getPatientName())
                .patientEmail(inputDto.getPatientEmail())
                .patientPhone(inputDto.getPatientPhone())
                .reason(inputDto.getReason())
                .status(inputDto.getStatus())
                .build();

        Appointment savedEntity = Appointment.builder()
                .appointmentId(100L)
                .clinicId(1L)
                .doctorId(1L)
                .appointmentDate(inputDto.getAppointmentDate())
                .appointmentTime(inputDto.getAppointmentTime())
                .patientName(inputDto.getPatientName())
                .patientEmail(inputDto.getPatientEmail())
                .patientPhone(inputDto.getPatientPhone())
                .reason(inputDto.getReason())
                .status(inputDto.getStatus())
                .build();

        AppointmentDTO outputDto = AppointmentDTO.builder()
                .appointmentId(100L)
                .clinicId(1L)
                .doctorId(1L)
                .appointmentDate(inputDto.getAppointmentDate())
                .appointmentTime(inputDto.getAppointmentTime())
                .patientName("Riya Sen")
                .patientEmail("riya@example.com")
                .patientPhone("9876543210")
                .reason("Follow-up")
                .status("Scheduled")
                .build();

        // 2. Act (Tell Mockito how to behave)
        when(appointmentMapper.toEntity(inputDto)).thenReturn(fakeEntity);
        when(appointmentRepository.save(fakeEntity)).thenReturn(savedEntity);
        when(appointmentMapper.toDTO(savedEntity)).thenReturn(outputDto);

        // 3. Act (Call the method we're testing)
        AppointmentDTO result = appointmentService.addAppointment(inputDto);

        // 4. Assert (Check if result is as expected)
        assertNotNull(result);
        assertEquals(outputDto.getAppointmentId(), result.getAppointmentId());
        assertEquals("Riya Sen", result.getPatientName());
        assertEquals("Follow-up", result.getReason());

        // verify method calls
        verify(appointmentMapper).toEntity(inputDto);
        verify(appointmentRepository).save(fakeEntity);
        verify(appointmentMapper).toDTO(savedEntity);



    }
    @Test
    void testAddAppointment_PastDate_shouldFailValidation(){

        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();

        AppointmentDTO dto= AppointmentDTO.builder()
                .clinicId(1L)
                .appointmentId(1L)
                .appointmentDate(LocalDate.of(2022,1,1))
                .appointmentTime(LocalTime.of(10,0))
                .patientName("Test user")
                .patientPhone("test@example.com")
                .patientEmail("7894561230")
                .status("Test")
                .reason("Scheduled")
                .build();

        Set<ConstraintViolation<AppointmentDTO>> violations=validator.validate(dto);

        assertFalse(violations.isEmpty(), "Past date detected, validation is failed");


    }

    @Test
    void testAddAppointment_MissingPatientName_shouldFailValidation(){
        ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();

        AppointmentDTO dto= AppointmentDTO.builder()
                .clinicId(1L)
                .doctorId(2L)
                .appointmentDate(LocalDate.now().plusDays(1))  // valid date
                .appointmentTime(LocalTime.of(10, 0))         // valid time
                .patientName("")                              //missing
                .patientEmail("test@example.com")
                .patientPhone("9876543210")
                .reason("Checkup")
                .status("Scheduled")
                .build();

        Set<ConstraintViolation<AppointmentDTO>> violations=validator.validate(dto);

        assertFalse(violations.isEmpty(),"Validation should fail for blank patient name");
        violations.forEach(v -> System.out.println(v.getPropertyPath() + " : " + v.getMessage()));

    }










}
