package ru.alishev.springcourse.dao;

import ru.alishev.springcourse.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
}
