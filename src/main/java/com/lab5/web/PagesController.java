package com.lab5.web;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@CrossOrigin(value = "*")
@Controller
public class PagesController {
    @GetMapping(path = {"*"})
    public String getStartPage(Model model) throws IOException {
        model.addAttribute("value", Strings.join(Files.readAllLines(Path.of("C:\\CSA5-master\\src\\main\\resources\\static\\page1.html")), ' '));
        return "template";
    }
    @GetMapping(path = "/page2")
    public String getSecondPage(Model model) throws IOException{
        model.addAttribute("value", Strings.join(Files.readAllLines(Path.of("C:\\CSA5-master\\src\\main\\resources\\static\\page2.html")), ' '));
        return "template";
    }
    @GetMapping(path = "/page3")
    public String getThirdPage(Model model) throws IOException {
        model.addAttribute("value", Strings.join(Files.readAllLines(Path.of("C:\\CSA5-master\\src\\main\\resources\\static\\page3.html")), ' '));
        return "template";
    }
}