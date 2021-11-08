package spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.model.User;
import spring.security.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all-users")
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Long id){
        User user = userRepository.findById(id).get();
        return user;
    }
}
