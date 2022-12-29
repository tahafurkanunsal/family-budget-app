package tahafurkan.sandbox.familybudgetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.familybudgetapp.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.familybudgetapp.exception.UsernameIsInUseException;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.repository.SpendingRepository;
import tahafurkan.sandbox.familybudgetapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SpendingRepository spendingRepository;

    @Override
    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserExistsException("NO USER PRESENT WITH ID =" + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Spending> getSpendingsByUserId(Integer id) {
        return spendingRepository.findByUserId(id);
    }

    @Override
    public User create(User user) {
        checkUsername(user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUsername(user.getUsername());
        checkUsername(existingUser.getUsername());
        User updateUser = userRepository.save(existingUser);
        return updateUser;
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            String msg = String.format(" ID = %d , this ID does not exist  ", id);
            throw new NoSuchUserExistsException(msg);
        }
    }

    @Override
    public void checkUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            String msg = String.format("Username ='%s' is being used by another user!", username);
            throw new UsernameIsInUseException(msg);
        }

    }
}
