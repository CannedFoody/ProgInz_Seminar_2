package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class Course {
    @Id
    @Column(name="courseId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)private long courseId;

    @NotEmpty
    @NotNull
    @Column(name="Title", unique = true)
    @Pattern(regexp = "[A-Ž]{1}[A-Ža-ž0-9 ]{3,40}")
    private String title;

    @Min(1)
    @Max(40)
    @Column(name="CreditPoints")
    private int credit_points;

    @OneToOne
    @JoinColumn(name = "professorId") //professor primary key / id
    private Professor professor;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Collection<Grade> grades = new ArrayList<Grade>();

    public Course(String title, int credit_points, Professor professor){
        setTitle(title);
        setCredit_points(credit_points);
        setProfessor(professor);
    }
}
