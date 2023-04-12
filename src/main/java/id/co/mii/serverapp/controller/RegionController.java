//FOKUS MEMBUAT ENDPOINT
package id.co.mii.serverapp.controller;

import java.util.List;
import id.co.mii.serverapp.models.Region;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.co.mii.serverapp.services.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RestController
@RequestMapping("/region")
public class RegionController {

    private RegionService regionService;

    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public Region getById(@PathVariable Integer id) {
        return regionService.getById(id);
    }

    @PostMapping
    public Region create(@RequestBody Region region) {
        return regionService.create(region);
    }

    @PutMapping("/{id}")
    public Region update(@PathVariable Integer id, @RequestBody Region region) {
        return regionService.update(id, region);
    }

    @DeleteMapping("/{id}")
    public Region delete(@PathVariable Integer id) {
        return regionService.delete(id);
    }
    
//    //JPQL
    @GetMapping("/jpql/{name}")
    public List<Region> searchByName(@PathVariable String name){
        return regionService.searchByName(name);
        
    }
    
//    @GetMapping("/jpql-param")
    public List<Region> searchByNameWithParam(@RequestParam(name = "name") String name){
        return regionService.searchByName(name);
    }
    
    //Native
//    @GetMapping("/native-param")
//    public List<Region> searchByNameNative(@RequestParam(name = "name") String name){
//        return regionService.searchByNameNative(name);
//    }
}

// http://localhost:9000/v1/region/1 => path (getById)
// http://localhost:9000/v1/region?id=1 => param (search)
