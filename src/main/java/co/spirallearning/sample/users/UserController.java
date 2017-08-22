package co.spirallearning.sample.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserJpaRepository userJpaRepository;

  @Autowired
  public UserController(UserJpaRepository userJpaRepository) {
    this.userJpaRepository = userJpaRepository;
  }

  @GetMapping("/all")
  public java.util.List<User> findAll() {
    return userJpaRepository.findAll();
  }

  @GetMapping("/{name}")
  public User findByName(@PathVariable final String name) {
    return userJpaRepository.findByName(name);
  }

  @PostMapping("/load")
  public User load(@RequestBody final User user) {
    userJpaRepository.save(user);
    return userJpaRepository.findByName(user.getName());
  }
}