/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.Countries;
import id.co.mii.serverapp.models.dto.requests.CountriesRequest;
import id.co.mii.serverapp.services.CountriesService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * @author Indonesia
 */
@AllArgsConstructor
@RestController
@RequestMapping("/countries")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class CountriesController {

    private CountriesService countriesService;

    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping
    public List<Countries> getAll() {
        return countriesService.getAll();
    }

    @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
    @GetMapping("/{id}")
    public Countries getById(@PathVariable Integer id) {
        return countriesService.getById(id);
    }

    // without DTO
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public Countries create(@RequestBody Countries countries) {
        return countriesService.create(countries);
    }

    // with DTO
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto")
    public Countries createWithDTO(@RequestBody CountriesRequest countriesRequest) {
        return countriesService.createWithDTO(countriesRequest);
    }
    
    // with modelMapper
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto-mm")
    public Countries createWithModelMapper(@RequestBody CountriesRequest countriesRequest){
        return countriesService.createWithModelMapper(countriesRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public Countries update(@PathVariable Integer id, @RequestBody Countries countries) {
        return countriesService.update(id, countries);
    }

    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public Countries delete(@PathVariable Integer id) {
        return countriesService.delete(id);
    }
}

// http://localhost:9000/v1/region/1 => path (getById)
// http://localhost:9000/v1/region?id=1 => param (search)