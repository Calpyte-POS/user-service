package com.calpyte.user.controller;


import com.calpyte.user.dto.Pagination;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.entity.User;
import com.calpyte.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUser(@RequestBody User user)  {
        user.setUserName(user.getPhoneNumber());
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }


//    @PostMapping("/paging")
//    public ResponseEntity<TableResponseDTO> getAll(@RequestBody PaginationDTO pagination){
//        return ResponseEntity.ok(userService.getUsers(pagination));
//    }


    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getUsers(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(userService.getUsers(pagination), HttpStatus.ACCEPTED);
    }

}
