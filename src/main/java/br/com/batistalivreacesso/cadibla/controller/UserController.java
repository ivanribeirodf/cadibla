package br.com.batistalivreacesso.cadibla.controller;

import br.com.batistalivreacesso.cadibla.domain.User;
import br.com.batistalivreacesso.cadibla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findall(){
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id){
        Optional<User> result = userService.findByID(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        try {
            User result = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }




}
