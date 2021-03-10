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
        // из DAO получаем всех user, пакуем в модель
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    // GET метод show по адресу /users/:id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // из DAO получаем одного user по id, пакуем в модель
        model.addAttribute("user", userDAO.show(id));
        return "users/show";
    }
}
