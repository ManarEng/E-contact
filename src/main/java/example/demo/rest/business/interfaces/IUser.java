package example.demo.rest.business.interfaces;

import example.demo.rest.model.User;

public interface IUser {

    User createUser(User user);
    User authenticateUser(User user);
    User getUserById(Long userId);
    void deleteUser(Long userId);
    void updateUser(User user);
    //List<User> getAllUsers();

}
