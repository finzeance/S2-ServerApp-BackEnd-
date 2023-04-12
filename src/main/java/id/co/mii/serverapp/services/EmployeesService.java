/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.Employees;
import id.co.mii.serverapp.repositories.EmployeesRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Zidane
 */
@Service
@AllArgsConstructor
public class EmployeesService {
    private EmployeesRepository employeesRepository;
    
    public List<Employees> getAll(){
        return employeesRepository.findAll();
    }
    
    public Employees getById(Integer id){
        return employeesRepository
                .findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found!!"));
    }
    
    public Employees create (Employees employees){
        return employeesRepository.save(employees);
    }
    
    public Employees update(Integer id, Employees employees){
        getById(id);
        employees.setId(id);
        return employeesRepository.save(employees);
    }
    
    public Employees delete(Integer id){
        Employees employees = getById(id);
        employeesRepository.delete(employees);
        return employees;
    }
}
