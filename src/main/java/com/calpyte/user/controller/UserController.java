package com.calpyte.user.controller;


import com.calpyte.user.dto.Pagination;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.entity.User;
import com.calpyte.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUser(@RequestBody User user)  {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/paging")
    public ResponseEntity<Page<User>> getAll(@RequestBody Pagination pagination){
        return ResponseEntity.ok(userService.getAll(pagination));
    }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public ResponseEntity<User> delete(@RequestParam("id") String id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
