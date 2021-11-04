package it.corsojava.spring.esercitazione1.controller;

import it.corsojava.spring.esercitazione1.model.Item;
import it.corsojava.spring.esercitazione1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class AccessController {
    List<User> users = new ArrayList<>();
    protected User currentUser;

    @GetMapping("/")
    public String home(Model model) {
        currentUser=new User();
        model.addAttribute("user", currentUser);
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        currentUser=users.get(users.indexOf(user));
        if(users.contains(currentUser)){
            model.addAttribute("user", currentUser);
            return "welcome";
        }else{return "error";}
    }
    @GetMapping("/registrati")
    public String registrati(Model model){
        model.addAttribute("user", new User());
        return "registrati";
    }
    @GetMapping("/profilo")
    public String profilo(Model model){
        model.addAttribute("user", currentUser);
        return "modifica_profilo";
    }
    //Post di /registrati e /profilo
    @PostMapping("/new_user")
    public String newUser(@ModelAttribute User user, Model model){
        if(currentUser.getPhoto()==null){
            user.setPhoto(getAvatar());
            users.add(user);
        }else{
            int index = users.indexOf(currentUser);
            users.get(users.indexOf(currentUser)).setUsername(user.getUsername());
            users.get(users.indexOf(currentUser)).setPassword(user.getPassword());
            users.get(users.indexOf(currentUser)).setAddress(user.getAddress());
            currentUser = users.get(index);
        }
        return "login";
    }


    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("user",currentUser);
        return "welcome";
    }
    @GetMapping("/logout")
    public String logout(Model model){
        currentUser=new User();
        model.addAttribute("user", currentUser);
        CarrelloController.ordini=new ArrayList<>();
        return "login";
    }

    private String getAvatar(){
        return "https://robohash.org/"+ new Random().nextInt() +".png?size=100x100";
    }


}

