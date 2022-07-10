package pl.sda.arppl4.student_grade_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_service.model.Student;
import pl.sda.arppl4.student_grade_service.model.StudentGrade;
import pl.sda.arppl4.student_grade_service.model.StudentSubject;
import pl.sda.arppl4.student_grade_service.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_service.model.dto.StudentGradeDTO;
import pl.sda.arppl4.student_grade_service.model.dto.StudentSubjectDTO;
import pl.sda.arppl4.student_grade_service.repository.StudentGradeRepository;
import pl.sda.arppl4.student_grade_service.repository.StudentRepository;
import pl.sda.arppl4.student_grade_service.repository.StudentSubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentSubjectService {
    private final StudentSubjectRepository studentSubjectRepository;
    private final StudentGradeRepository studentGradeRepository;
    private final StudentRepository studentRepository;

    public void addSubject(StudentSubject studentSubject) {
        boolean studentSubjectCheck = studentSubjectRepository.existsBySubject(studentSubject.getSubject());
        if (!studentSubjectCheck) {
            log.info("Subject dodany: ");
            studentSubjectRepository.save(studentSubject);

        } else {
            log.info("Subject juz istnieje: ");
        }
    }

    public List<StudentSubjectDTO> findAll() {
        List<StudentSubject> studentSubjectList = studentSubjectRepository.findAll();
        List<StudentSubjectDTO> studentsSubject = new ArrayList<>();
        for (StudentSubject studentSubject : studentSubjectList){
            studentsSubject.add(studentSubject.maptToStundentSubjectDTO());
        }
        return studentsSubject;
    }


    public void deleteSubjectById(Long identyfikator) {
        studentSubjectRepository.deleteById(identyfikator);

    }
}
