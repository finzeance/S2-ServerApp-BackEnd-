/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.Countries;
import id.co.mii.serverapp.models.Region;
import id.co.mii.serverapp.models.dto.requests.CountriesRequest;
import id.co.mii.serverapp.repositories.CountriesRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CountriesService {

    private CountriesRepository countriesRepository;
    private RegionService regionService;
    private ModelMapper modelMapper;

    public List<Countries> getAll() {
        return countriesRepository.findAll();
    }

    public Countries getById(Integer id) {
        return countriesRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "countries not found!!"));
    }

    // without DTO
    public Countries create(Countries countries) {
        return countriesRepository.save(countries);
    }

    // with DTO
    public Countries createWithDTO(CountriesRequest countriesRequest) {
        Countries cntrs = new Countries();
        cntrs.setCode(cntrs.getCode());
        cntrs.setName(cntrs.getName());

        Region region = regionService.getById(countriesRequest.getRegion_id());
        cntrs.setRegion(region);
        return countriesRepository.save(cntrs);
    }
    
    //with DTO by modelMapper
    public Countries createWithModelMapper(CountriesRequest countriesRequest){
        Countries cntrs = modelMapper.map(countriesRequest, Countries.class);
        cntrs.setRegion(regionService.getById(countriesRequest.getRegion_id()));
        return countriesRepository.save(cntrs);
    }

    public Countries update(Integer id, Countries countries) {
        getById(id); //method getById
        countries.setId(id);
        return countriesRepository.save(countries);        
    }

    public Countries delete(Integer id) {
        Countries countries = getById(id);
        countriesRepository.delete(countries);
        return countries;
    }

}
