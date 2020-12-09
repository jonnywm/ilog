package br.com.ilog.test.repository;

import br.com.ilog.test.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonny
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
