package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="gradeId")
    @Setter(value = AccessLevel.NONE) private long gradeId;

    @Column(name="GradeValue")
    @Min(1)
    @Max(10)
    private int gradeValue;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name="courseId")
    private Course course;

    public Grade(int gradeValue, Student student, Course course){
        setGradeValue(gradeValue);
        setStudent(student);
        setCourse(course);
    }
}
