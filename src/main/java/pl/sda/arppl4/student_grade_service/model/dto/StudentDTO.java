package pl.sda.arppl4.student_grade_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int indexNumber;
}
