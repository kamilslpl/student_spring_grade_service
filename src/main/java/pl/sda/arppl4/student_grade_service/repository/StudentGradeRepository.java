package pl.sda.arppl4.student_grade_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.student_grade_service.model.StudentGrade;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
}
