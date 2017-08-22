package co.spirallearning.sample.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
  User findByName(String name);
}
