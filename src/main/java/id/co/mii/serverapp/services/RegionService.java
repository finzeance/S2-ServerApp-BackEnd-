package id.co.mii.serverapp.services;

import java.util.List;
import id.co.mii.serverapp.models.Region;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import id.co.mii.serverapp.repositories.RegionRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegionService {

    private RegionRepository regionRepository;

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Region getById(Integer id) {
        return regionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found!!!"));
    }

    public Region create(Region region) {
        if (regionRepository.existsByName(region.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Name is already exists...");
        }
            return regionRepository.save(region);

    }

    public Region update(Integer id, Region region) {
        getById(id); //method getById
        region.setId(id);
        return regionRepository.save(region);
    }

    public Region delete(Integer id) {
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }

    //JPQL
    public List<Region> searchByName(String name) {
        return regionRepository.findByName(name);
    }

    //Native
//    public List<Region> searchByNameNative(String name) {
//        return regionRepository.searchByNameNative(name);
//    }
}
