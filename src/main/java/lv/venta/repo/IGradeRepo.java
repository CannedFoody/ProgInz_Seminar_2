package lv.venta.repo;

import lv.venta.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface IGradeRepo extends CrudRepository<Grade, Long> {
}
