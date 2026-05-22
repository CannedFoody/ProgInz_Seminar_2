package lv.venta.repo;

import lv.venta.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepo extends CrudRepository<Course, Long> {
}
