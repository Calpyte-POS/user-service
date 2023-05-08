package com.calpyte.user.controller;



import com.calpyte.user.dto.WarehouseDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.entity.Role;
import com.calpyte.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.saveRole(role));
    }

    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getRoles(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(roleService.getRoles(pagination), HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Role> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<Role> delete(@RequestParam("id") String id){
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
