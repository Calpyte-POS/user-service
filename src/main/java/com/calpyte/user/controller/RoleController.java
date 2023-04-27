package com.calpyte.user.controller;



import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Role;
import com.calpyte.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.saveRole(role));
    }

    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getRoles(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(roleService.getRoles(pagination), HttpStatus.ACCEPTED);
    }

}
