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
public class Student {
    @Column(name = "studentId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter (value = AccessLevel.NONE) private long studentId;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([A-Ž]{1}[a-ž]{2,20}))?")
    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    @NotEmpty
    @NotNull
    @Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([A-Ž]{1}[a-ž]{2,20}))?")
    private String surname;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Collection<Grade> grades = new ArrayList<Grade>();

    public Student(String name, String surname){
        setName(name);
        setSurname(surname);
    }
}
