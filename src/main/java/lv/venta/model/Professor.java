package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lv.venta.model.Enums.Degree;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity

public class Professor {
    @Column(name="professorId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value=AccessLevel.NONE) private long professorId;

    @Column(name="Name")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([A-Ž]{1}[a-ž]{2,20}))?")
    private String name;

    @Column(name="Surname")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([A-Ž]{1}[a-ž]{2,20}))?")
    private String surname;

    @Column(name="Degree")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToOne(mappedBy = "professor") // course class professor object variable name
    @ToString.Exclude // Exclude this when ToString from the other side of the database link so it doesnt go into a forever loop
    private Course course;

    public Professor(String name, String surname, Degree degree){
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }
}
