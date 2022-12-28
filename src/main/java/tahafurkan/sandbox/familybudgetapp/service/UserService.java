package tahafurkan.sandbox.familybudgetapp.service;

import tahafurkan.sandbox.familybudgetapp.model.User;

import java.util.List;

public interface UserService {

    public User get(int id);

    public List<User> getAll();

    public User getByUsername(String username);

    public User create(User user);

    public User update(int id, User user);

    public void delete(int id);

    public void checkUsername(String username);
}
