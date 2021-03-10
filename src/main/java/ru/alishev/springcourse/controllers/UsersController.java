package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    // GET метод index по адресу /users
    @GetMapping
    public String index(Model model) {
        // строка для отладки
        System.out.println("в методе index");
        // из DAO будем получать всех user
        return null;
    }

    // GET метод show по адресу /users/:id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // строка для отладки
        System.out.println("в методе show");
        // из DAO будем получать одного user по id
        return null;
    }
}
