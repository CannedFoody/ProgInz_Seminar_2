package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter (value = AccessLevel.NONE) private long student_id;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]{1,20}")
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    @NotEmpty
    @NotNull
    @Pattern(regexp = "[A-Za-z]{1,20}")
    private String surname;

    public Student(String name, String surname){
        setName(name);
        setSurname(surname);
    }
}
