package pl.sda.arppl4.student_grade_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSubjectDTO {
    private Long studentSubjectId;
    private String subject;
}
