package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUserName(String name);
    Optional<User> findById(Long id);
    void saveUser(User user);
    void editUser(User user);
    void changePassword(User user);
    List<User> findAll();
//    List<User> findAdmins();

}
