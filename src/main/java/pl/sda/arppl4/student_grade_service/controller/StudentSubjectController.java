package pl.sda.arppl4.student_grade_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.student_grade_service.model.StudentSubject;
import pl.sda.arppl4.student_grade_service.model.dto.StudentSubjectDTO;
import pl.sda.arppl4.student_grade_service.service.StudentSubjectService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class StudentSubjectController {
    private final StudentSubjectService studentSubjectService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubject(@RequestBody StudentSubject studentSubject){
        log.info("Wywołano dodanie subject: " + studentSubject);
        studentSubjectService.addSubject(studentSubject);
    }

    @GetMapping("/list")
    public List<StudentSubjectDTO> getAllStudentsSubjects() {
        log.info("Wywołano listę subject.");
        List<StudentSubjectDTO> subjectList = studentSubjectService.findAll();
        return subjectList;
    }

    @DeleteMapping("/delete/{studentSubjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubject(@PathVariable(name = "studentSubjectId") Long identyfikator) {
        log.info("Wywołano usunięcie subjectu: " + identyfikator);
        studentSubjectService.deleteSubjectById(identyfikator);
    }

}
