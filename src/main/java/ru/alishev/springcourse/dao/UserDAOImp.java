package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    private List<User> userList;
    private static int USER_ID;

    {
        userList = new ArrayList<>();
        userList.add(new User(++USER_ID, "Tyler", "Durden", 25, "durden@mail.com"));
        userList.add(new User(++USER_ID, "Jeffrey", "Lebowski", 42, "lebowski@mail.com"));
        userList.add(new User(++USER_ID, "Vito", "Corleone", 52, "corleone@mail.com"));
        userList.add(new User(++USER_ID, "John", "McClane", 38, "mcclane@mail.com"));
        userList.add(new User(++USER_ID, "Hans", "Gruber", 40, "gruber@mail.com"));
    }

    @Override
    public List<User> index() {
        return userList;
    }

    @Override
    public User show(int id) {
        return userList.stream()
                // лямбда фильтрующая user по id
                .filter(user -> user.getId() == id)
                // вернем что нашлось
                .findAny()
                // если id не найден вернется null
                .orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USER_ID);
        userList.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
