/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.Roles;
import id.co.mii.serverapp.models.Users;
import id.co.mii.serverapp.models.dto.requests.UsersRequest;
import id.co.mii.serverapp.services.UsersService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zidane
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UsersController {
    
    private UsersService usersService;
    
    @GetMapping
    public List<Users> getAll(){
        return usersService.getAll();
    }
    
    @GetMapping("/{id}")
    public Users getById(@PathVariable Integer id){
        return usersService.getById(id);
    }
    
    @PostMapping
    public Users create(@RequestBody UsersRequest usersRequest){
        return usersService.create(usersRequest);
    }
    
    @PutMapping("/{id}")
    public Users update(@PathVariable Integer id, @RequestBody Users users){
        return usersService.update(id, users);
    }
    
    @DeleteMapping("/{id}")
    public Users delete(@PathVariable Integer id){
        return usersService.delete(id);
    }
    
    @PostMapping("/{id}")
    public Users addRoles(@PathVariable Integer id, @RequestBody Roles roles){
        return usersService.addRoles(id, roles);
    }
    
}
