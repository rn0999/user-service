package com.rn.userservice.controller;

import com.rn.userservice.bean.User;
import com.rn.userservice.response.UserCreatedResponse;
import com.rn.userservice.exception.UserNotFoundException;
import com.rn.userservice.repo.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    @Autowired
    private UserServiceRepository repository;

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Integer id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User id : %d not found",id));
        }
        return user.get();
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        UserCreatedResponse createdResponse = new UserCreatedResponse(
                String.format("User created with id : %d ",savedUser.getId()),location);
        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePartsOfUser(@RequestBody User user,@PathVariable("id") Integer id){
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException(String.format("User id : %d not found",id));
        }
        User newUser = userOptional.get();
        if(!user.getName().isEmpty())
            newUser.setName(user.getName());

        if(user.getAge()!=null)
            newUser.setAge(user.getAge());

        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteUserById(@PathVariable("id") Integer id){
        Map<String,String> responseMap = new HashMap<>();
        if(!repository.existsById(id))
            throw new UserNotFoundException(String.format("User id : %d not found",id));
        repository.deleteById(id);
        responseMap.put("message","User has been deleted");
        return responseMap;
    }

}
