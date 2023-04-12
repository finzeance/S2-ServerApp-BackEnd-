/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.Roles;
import id.co.mii.serverapp.repositories.RolesRepository;
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
public class RolesService {

    private RolesRepository rolesRepository;

    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    public Roles getById(Integer id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roles not found with id " + id));
    }

    public Roles create(Roles roles) {
        return rolesRepository.save(roles);
    }

    public Roles update(Integer id, Roles roles) {
        getById(id);
        roles.setId(id);
        return rolesRepository.save(roles);
    }

    public Roles delete(Integer id) {
        Roles roles = getById(id);
        rolesRepository.delete(roles);
        return roles;
    }
}
