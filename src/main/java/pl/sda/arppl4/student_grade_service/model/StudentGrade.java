package pl.sda.arppl4.student_grade_service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrade {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int value;
    @CreationTimestamp
    private LocalDateTime dateAdded;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StudentSubject studentSubject;

    }

