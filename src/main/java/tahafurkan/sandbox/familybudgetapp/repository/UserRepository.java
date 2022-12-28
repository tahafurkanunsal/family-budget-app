package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tahafurkan.sandbox.familybudgetapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}
