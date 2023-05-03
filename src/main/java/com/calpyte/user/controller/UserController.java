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

    @GetMapping("/by-id")
    public ResponseEntity<User> findById(@RequestParam("id") String id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/paging")
    public ResponseEntity<TableResponseDTO> getAll(@RequestBody PaginationDTO pagination){
        return ResponseEntity.ok(userService.getUsers(pagination));
    }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public ResponseEntity<User> delete(@RequestParam("id") String id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getUsers(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(userService.getUsers(pagination), HttpStatus.ACCEPTED);
    }

}
