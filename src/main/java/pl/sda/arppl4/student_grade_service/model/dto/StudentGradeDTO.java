package pl.sda.arppl4.student_grade_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDTO {
    private Long studentGradeId;
    private int value;
}
