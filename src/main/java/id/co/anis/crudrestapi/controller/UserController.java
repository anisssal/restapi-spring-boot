package id.co.anis.crudrestapi.controller;

import id.co.anis.crudrestapi.exception.ResourcesNotFoundException;
import id.co.anis.crudrestapi.model.User;
import id.co.anis.crudrestapi.model.UserList;
import id.co.anis.crudrestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Anis
 * created on 3/29/2020 - 5:16 PM on crudrestapi
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<UserList> getAllUser() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<UserList>(new UserList(), HttpStatus.OK);
        }
        UserList userList = new UserList(users);
//        return ResponseEntity.ok(userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) throws ResourcesNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("User not found ::"+id));
        return user;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User user) throws ResourcesNotFoundException {
        User userById =  userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("User not found ::"+id));;

        userById.setFirstName(user.getFirstName());
        userById.setEmailId(user.getEmailId());
        userById.setLastName(user.getLastName());
        userById.setUpdatedAt(new Date());
        final User updatedUser = userRepository.save(userById);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String , String> deleteUser(
            @PathVariable("id") Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("User not found ::"+id));
        userRepository.delete(user);
        Map<String, String> response = new HashMap<>();
        response.put("success", Boolean.TRUE.toString());
        response.put("message", "User deleted");
        return response;
    }

}
