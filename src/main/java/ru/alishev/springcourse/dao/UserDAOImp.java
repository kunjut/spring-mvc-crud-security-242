package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImp implements UserDAO {
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(1, "Tyler", "Durden", 25, "durden@mail.com"));
        userList.add(new User(2, "Jeffrey", "Lebowski", 42, "lebowski@mail.com"));
        userList.add(new User(3, "Vito", "Corleone", 52, "corleone@mail.com"));
        userList.add(new User(4, "John", "McClane", 38, "mcclane@mail.com"));
        userList.add(new User(5, "Hans", "Gruber", 40, "gruber@mail.com"));
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
}
