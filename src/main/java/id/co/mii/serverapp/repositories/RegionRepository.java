/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.serverapp.repositories;

import id.co.mii.serverapp.models.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    //Native
//    @Query(value = "SELECT * FROM zd_region WHERE name = :name", nativeQuery = true) //in case sensitive
//    List<Region> searchByName(String name);

    //JPQL
//    @Query("SELECT r FROM region r WHERE r.name = ?1") //case sensitive
//    public List<Region> searchByNameNative(String name);
    
    //Query Method
    public Boolean existsByName(String name);
    List<Region> findByName(String name);
}
