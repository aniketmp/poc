package org.learning.controllers;

import org.learning.assemblers.DomainAssembler;
import org.learning.assemblers.DtoAssembler;
import org.learning.dtos.CreateUserDto;
import org.learning.dtos.UserDto;
import org.learning.entities.User;
import org.learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DomainAssembler domainAssembler;

    @Autowired
    private DtoAssembler dtoAssembler;

    @Autowired
    private UserService userService;



    @GetMapping
    public ResponseEntity<?> getAllUsers() throws Exception {
        List<User> userList=userService.getAllUsers();
        List<UserDto> userDtos=dtoAssembler.getUserDtoListFromUserDomainList(userList);
        return ResponseEntity.ok(userDtos);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        User user=domainAssembler.getUserFromCreateUserDto(createUserDto);
        userService.createUser(user);
        return ResponseEntity.accepted().build();
    }
}
