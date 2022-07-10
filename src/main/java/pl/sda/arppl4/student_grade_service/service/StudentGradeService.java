package pl.sda.arppl4.student_grade_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_service.repository.StudentGradeRepository;
import pl.sda.arppl4.student_grade_service.repository.StudentRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentGradeService {
    private final StudentGradeRepository studentGradeRepository;
    private final StudentRepository studentRepository;


}
