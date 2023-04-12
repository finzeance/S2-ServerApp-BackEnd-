/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.Employees;
import id.co.mii.serverapp.services.EmployeesService;
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
@RequestMapping("/employee")
public class EmployeesController {
    
    private EmployeesService employeesService;
    
    @GetMapping
    public List<Employees> getAll(){
        return employeesService.getAll();
    }
    
    @GetMapping("/{id}")
    public Employees getById(@PathVariable Integer id){
        return employeesService.getById(id);
    }
    
    @PostMapping
    public Employees create(@RequestBody Employees employees){
        return employeesService.create(employees);
    }
    
    @PutMapping("/{id}")
    public Employees update(@PathVariable Integer id, @RequestBody Employees employees){
        return employeesService.update(id, employees);
    }
    
    @DeleteMapping("/{id}")
    public Employees delete(@PathVariable Integer id){
        return employeesService.delete(id);
    }
    
}
