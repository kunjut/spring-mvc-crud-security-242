package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.dao.UserDAO;
import ru.alishev.springcourse.models.User;

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

    // GET метод newUser по адресу /users/new
    @GetMapping("/new")
    public String newUser(User user) {

        return "users/new";
    }

    // POST метод create по адресу /users
    @PostMapping()
    public String create(User user) {
        userDAO.save(user);

        return "redirect:/users";
    }

    // GET метод edit users/:id/edit
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("user", userDAO.show(id));

        return "users/edit";
    }

    // PATCH метод update users/:id
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, User user) {
        userDAO.update(id, user);

        return "redirect:/users";
    }
}
