/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.Roles;
import id.co.mii.serverapp.services.RolesService;
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
@RequestMapping("/role")
public class RolesController {
    
    private RolesService rolesService;
    
    @GetMapping
    public List<Roles> getAll(){
        return rolesService.getAll();
    }
    
    @GetMapping("/{id}")
    public Roles getById(@PathVariable Integer id){
        return rolesService.getById(id);
    }
    
    @PostMapping
    public Roles create(@RequestBody Roles roles){
        return rolesService.create(roles);
    }
    
    @PutMapping("/{id}")
    public Roles update(@PathVariable Integer id, @RequestBody Roles roles){
        return rolesService.update(id, roles);
    }
    
    @DeleteMapping("/{id}")
    public Roles delete(@PathVariable Integer id){
        return rolesService.delete(id);
    }
}
