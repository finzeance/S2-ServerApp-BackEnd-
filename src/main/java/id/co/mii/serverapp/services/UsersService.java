/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.Employees;
import id.co.mii.serverapp.models.Roles;
import id.co.mii.serverapp.models.Users;
import id.co.mii.serverapp.models.dto.requests.UsersRequest;
import id.co.mii.serverapp.repositories.UsersRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Zidane
 */
@Service
@AllArgsConstructor
public class UsersService {

    private UsersRepository usersRepository;
    private ModelMapper modelMapper;
    private RolesService rolesService;
    private PasswordEncoder passwordEncoder;

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public Users getById(Integer id) {
        return usersRepository.findById((id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data users not found!!!"));
    }

    public Users create(UsersRequest usersRequest) {
        Employees employees = modelMapper.map(usersRequest, Employees.class);
        Users users = modelMapper.map(usersRequest, Users.class);

        employees.setUsers(users);
        users.setEmployees(employees);
        return usersRepository.save(users);
    }

    public Users update(Integer id, Users users) {
        getById(id);
        users.setId(id);
        return usersRepository.save(users);
    }

    public Users delete(Integer id) {
        Users users = getById(id);
        usersRepository.delete(users);
        return users;
    }

    public Users addRoles(Integer id, Roles roles) {
        Users users = getById(id);
        List<Roles> roles1 = users.getRoles();
        roles1.add(rolesService.getById(roles.getId()));
        users.setRoles(roles1);
        return usersRepository.save(users);
    }

}
