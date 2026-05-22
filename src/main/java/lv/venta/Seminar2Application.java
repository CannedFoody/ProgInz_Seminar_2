package lv.venta;

import lv.venta.model.Course;
import lv.venta.model.Enums.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Seminar2Application {

    public static void main(String[] args) {
        SpringApplication.run(Seminar2Application.class, args);
    }

    @Bean
    public CommandLineRunner push_data_to_db(IStudentRepo students_repo, IProfessorRepo professor_repo, ICourseRepo course_repo, IGradeRepo grade_repo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Student s1 = new Student("Gustavs", "Vistins");
                Student s2 = new Student("Mikus Valts", "Šarovs");

                students_repo.saveAll(Arrays.asList(s1, s2));

                Professor p1 = new Professor("Karīna", "Šķirmante", Degree.Master);
                Professor p2 = new Professor("Kārlis", "Immers", Degree.Master);

                professor_repo.saveAll(Arrays.asList(p1,p2));

                Course c1 = new Course("Data Structures", 10, p1);
                Course c2 = new Course("Web Technologies", 10, p2);

                course_repo.saveAll(Arrays.asList(c1, c2));

                Grade g1 = new Grade(10, s1, c1);
                Grade g2 = new Grade(10, s2, c2);

                grade_repo.saveAll(Arrays.asList(g1, g2));
            }
        };
    }
}
