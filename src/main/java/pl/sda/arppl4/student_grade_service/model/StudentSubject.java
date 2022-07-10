package pl.sda.arppl4.student_grade_service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.arppl4.student_grade_service.repository.StudentSubjectRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentSubject {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String subject;

    @OneToMany(mappedBy = "studentSubject", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<StudentGrade> studentGrades;





    }

