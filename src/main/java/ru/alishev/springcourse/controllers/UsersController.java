package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.dao.UserDAO;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserDAO userDAO;

    // GET метод index по адресу /users
    @GetMapping
    public String index(Model model) {
        // из DAO будем получать всех user
        System.out.println(userDAO.index());
        return null;
    }

    // GET метод show по адресу /users/:id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // из DAO будем получать одного user по id
        System.out.println(userDAO.show(id));
        return null;
    }
}
