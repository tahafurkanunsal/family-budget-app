package tahafurkan.sandbox.familybudgetapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.familybudgetapp.controller.UserController;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;
import tahafurkan.sandbox.familybudgetapp.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.familybudgetapp.exception.UsernameIsInUseException;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingDetailDto;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingDto;
import tahafurkan.sandbox.familybudgetapp.model.dto.UserSpendingDto;
import tahafurkan.sandbox.familybudgetapp.repository.SpendingRepository;
import tahafurkan.sandbox.familybudgetapp.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SpendingRepository spendingRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User get(int id) {
        logger.info("Find user by id: {}", id);
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserExistsException("NO USER PRESENT WITH ID =" + id));
    }

    @Override
    public List<User> getAll() {
        logger.info("Find all users");
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        logger.info("Find user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Spending> getSpendingsByUserId(Integer id) {
        logger.info("Find spendings by user id: {}", id);
        return spendingRepository.findByUserId(id);
    }

    @Override
    public User findUserWithHighestTotalSpend() {
        List<User> results = spendingRepository.findUsersWithHighestTotalSpend();
        if (results.isEmpty()) {
            logger.info("there is no such user list ");
            return null;
        }
        logger.info("Top spender in user : {}" , results.get(0));
        return results.get(0);
    }

    @Override
    public User findHighestTotalSpendOnGivenDate(Date startDate, Date endDate) {
        List<User> results = spendingRepository.findMostSpendingByDate(startDate, endDate);
        if (results.isEmpty()) {
            logger.info("there is no such user list");
            return null;
        }
        logger.info("Top spender in date range : {} , {} , {}" ,startDate , endDate, results.get(0));
        return results.get(0);
    }

    @Override
    public List<UserSpendingDto> findHighestTotalSpendDetailsByDate(Date startDate, Date endDate) {
        List<Spending> spendingList = spendingRepository.findMostSpendingDetailsByDate(startDate, endDate);

        User mostSpendingUser = spendingList.get(0).getUser();

        List<SpendingDto> spendingDtos = new ArrayList<>();
        List<UserSpendingDto> userSpendingDtos = new ArrayList<>();

        for (Spending spending : spendingList) {

            List<SpendingDetailDto> spendingDetailDtos = new ArrayList<>();
            SpendingDetailDto spendingDetailDto = new SpendingDetailDto();
            spendingDetailDto.setSpendingDetails(spending.getDetails());
            spendingDetailDtos.add(spendingDetailDto);


            SpendingDto spendingDto = new SpendingDto();
            spendingDto.setId(spending.getId());
            spendingDto.setDate(spending.getDate());
            spendingDto.setType(spending.getType());
            spendingDto.setPrice(spending.getPrice());
            spendingDto.setSpendingDetailDto(spendingDetailDtos);
            spendingDtos.add(spendingDto);

        }

        UserSpendingDto userSpendingDto = new UserSpendingDto();
        userSpendingDto.setUserId(mostSpendingUser.getId());
        userSpendingDto.setFullName(mostSpendingUser.getFirstName() + " " + mostSpendingUser.getLastName());
        userSpendingDto.setSpendings(spendingDtos);
        userSpendingDtos.add(userSpendingDto);
        logger.info("Top spender and spending details in the date range: {} " , userSpendingDtos);
        return userSpendingDtos;
    }

    @Override
    public User findHighestGrocerySpendingWithGivenDate(Date startDate, Date endDate, SpendingTypes type) {
        List<User> results = spendingRepository.findMostGrocerySpendingByDate(startDate, endDate, type);
        if (results.isEmpty()) {
            logger.info("There is no such user list");
            return null;
        }
        logger.info("Top grocery spender: {}" , results.get(0));
        return results.get(0);
    }

    @Override
    public List<User> sortUsersBySpendingSize() {
        logger.info("Users sorted by spending size");
        return spendingRepository.sortUsersBySpendingSize();
    }

    @Override
    public User create(User user) {
        checkUsername(user.getUsername());
        logger.info("Created a user : {} " , user);
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
        logger.info("updated user by id : {}" , id);
        return updateUser;
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("deleted user by id : {} ", id);
            userRepository.deleteById(id);
        } else {
            String msg = String.format(" ID = %d , this ID does not exist  ", id);
            logger.info(msg);
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
