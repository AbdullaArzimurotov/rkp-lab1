package ru.kafpin.laboratoriya;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "redirect:/form";
    }

    @GetMapping("/form")
    public String mainForm(Model model) {
        model.addAttribute("student", new Student(null, "", "", "", "", null));
        return "main-form";
    }

    @PostMapping("/form")
    public String mainFormSubmit(@Valid @ModelAttribute Student student, BindingResult errors) {
        return errors.hasErrors() ? "main-form" : "result";
    }
}
