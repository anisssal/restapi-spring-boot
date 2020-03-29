package id.co.anis.crudrestapi.repositories;

import id.co.anis.crudrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Anis
 * created on 3/29/2020 - 4:55 PM on crudrestapi
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
