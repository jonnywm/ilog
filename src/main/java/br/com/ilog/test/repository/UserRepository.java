package br.com.ilog.test.repository;

import br.com.ilog.test.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonny
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
