package tahafurkan.sandbox.familybudgetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.model.dto.UserSpendingDto;
import tahafurkan.sandbox.familybudgetapp.service.UserService;

import java.util.Date;
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

    @GetMapping(value = "/users/{id}/spendings")
    public List<Spending> getUserSpendings(@PathVariable Integer id) {
        return userService.getSpendingsByUserId(id);
    }

    @GetMapping(value = "/users/most-spending")
    public User findUserWithHighestTotalSpend() {
        return userService.findUserWithHighestTotalSpend();
    }

    @GetMapping(value = "/users/most-spending", params = {"startDate", "endDate"})
    public User findHighestTotalSpendOnGivenDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date startDate,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date endDate) {
        return userService.findHighestTotalSpendOnGivenDate(startDate, endDate);
    }

    @GetMapping(value = "/users/most-spending-details", params = {"startDate", "endDate"})
    public List<UserSpendingDto> findHighestTotalSpendDetailsByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date startDate,
                                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date endDate) {
        return userService.findHighestTotalSpendDetailsByDate(startDate, endDate);
    }

    @GetMapping(value = "/users/most-spending", params = {"startDate", "endDate", "type"})
    public User findHighestGrocerySpendingWithGivenDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date startDate,
                                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MMM-dd") Date endDate,
                                                        @RequestParam SpendingTypes type) {
        return userService.findHighestGrocerySpendingWithGivenDate(startDate, endDate, type);
    }

    @GetMapping(value = "/users/sort-by-spendings")
    public List<User> sortUsersBySpendingSize() {
        return userService.sortUsersBySpendingSize();
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