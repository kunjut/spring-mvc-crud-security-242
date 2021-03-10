package ru.alishev.springcourse.dao;

import ru.alishev.springcourse.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {
    private List<User> userList;

    {
     userList = new ArrayList<>();
     userList.add(new User(1, "Tyler", "Durden", 25, "b.smith@mail.com"));
     userList.add(new User(2, "Jeffrey", "Lebowski", 42, "b.johnson@mail.com"));
     userList.add(new User(3, "Vito", "Corleone", 52, "a.lesly@mail.com"));
     userList.add(new User(4, "John", "McClane", 38, "i.prince@mail.com"));
     userList.add(new User(5, "Hans", "Gruber", 40, "b.smith@mail.com"));
    }
    @Override
    public List<User> index() {
        return null;
    }

    @Override
    public User show(int id) {
        return null;
    }
}
