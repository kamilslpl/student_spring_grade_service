package pl.sda.arppl4.student_grade_service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.student_grade_service.model.dto.StudentDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int indexNumber;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<StudentGrade> studentGrades;



    public StudentDTO maptToStundentDTO(){
        return new StudentDTO(
                id,
                name,
                surname,
                dateOfBirth,
                indexNumber
        );
    }

}
