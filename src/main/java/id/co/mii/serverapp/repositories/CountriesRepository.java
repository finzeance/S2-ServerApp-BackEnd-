/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.serverapp.repositories;

import id.co.mii.serverapp.models.Countries;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Indonesia
 */
@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {

//    @Query(value = "SELECT * FROM zd_countries WHERE name = :name", nativeQuery = true)
    List<Countries> findByName(String name);
    
    //JPQL

}
