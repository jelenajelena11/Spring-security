package spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/add-new")
    public User registerNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/delete-user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }
}
