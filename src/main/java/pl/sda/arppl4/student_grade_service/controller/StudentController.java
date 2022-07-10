package pl.sda.arppl4.student_grade_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.student_grade_service.model.Student;
import pl.sda.arppl4.student_grade_service.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_service.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        log.info("Wywołano dodanie studenta: " + student);
        studentService.addStudent(student);
    }

    @GetMapping("/list")
    public List<StudentDTO> getAllStudents() {
        log.info("Wywołano listę studentow.");
        List<StudentDTO> list = studentService.findAll();
        return list;
    }

    @DeleteMapping("/delete/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable(name = "identifier") Long identyfikator) {
        log.info("Wywołano usunięcie studenta: " + identyfikator);
        studentService.deleteById(identyfikator);
    }

    @PatchMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        log.info("Wywołano aktualizację studenta: " + student);
        studentService.updateStudent(student);
    }
}
