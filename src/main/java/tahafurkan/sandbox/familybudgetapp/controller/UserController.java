package tahafurkan.sandbox.familybudgetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
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

    @GetMapping(value = "/users/{id}")
    public List<Spending> getByUserId(@PathVariable int id) {
        return userService.getByUserId(id);
    }

    @GetMapping(value = "/users/most-spending")
    public User getMostSpendingUser() {
        return userService.getMostSpendingUser();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(value = "/users/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }


}
