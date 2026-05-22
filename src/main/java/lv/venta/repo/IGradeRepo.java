package lv.venta.repo;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGradeRepo extends CrudRepository<Grade, Long> {
    ArrayList<Grade> findByStudentStudentId(long studentId);
//    public abstract ArrayList<Grade> findByStudent(Student student);
}
