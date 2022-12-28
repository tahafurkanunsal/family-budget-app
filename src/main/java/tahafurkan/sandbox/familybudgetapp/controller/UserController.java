package tahafurkan.sandbox.familybudgetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users", params = {"id"})
    public User get(@RequestParam int id) {
        return userService.get(id);
    }

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/users", params = {"username"})
    public User getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(value = "/users/")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

}