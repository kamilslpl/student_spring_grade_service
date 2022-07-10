package pl.sda.arppl4.student_grade_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_service.model.Student;
import pl.sda.arppl4.student_grade_service.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_service.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public void deleteById(Long identyfikator) {
        studentRepository.deleteById(identyfikator);
    }

    public void updateStudent(Student daneAktualizujące) {

         Long identifier = daneAktualizujące.getId();

            Optional<Student> studentOptional = studentRepository.findById(identifier);
            if (studentOptional.isPresent()) {
                Student editedStudent = studentOptional.get();

                if (daneAktualizujące.getName() != null) {
                    editedStudent.setName(daneAktualizujące.getName());
                }
                if (daneAktualizujące.getSurname() != null) {
                    editedStudent.setSurname(daneAktualizujące.getSurname());
                }
                if (daneAktualizujące.getDateOfBirth() != null) {
                    editedStudent.setDateOfBirth(daneAktualizujące.getDateOfBirth());
                }

                studentRepository.save(editedStudent);
                log.info("Student został zapisany.");
                return;
            }

        }
    }

