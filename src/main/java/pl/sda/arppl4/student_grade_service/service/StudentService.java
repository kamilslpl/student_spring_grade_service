package pl.sda.arppl4.student_grade_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_service.model.Student;
import pl.sda.arppl4.student_grade_service.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_service.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    public List<StudentDTO> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> students = new ArrayList<>();
        for (Student student : studentList){
            students.add(student.maptToStundentDTO());
        }
        return students;
    }
}
