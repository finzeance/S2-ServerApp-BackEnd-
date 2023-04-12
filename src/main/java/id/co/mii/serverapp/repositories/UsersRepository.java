/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.co.mii.serverapp.repositories;

import id.co.mii.serverapp.models.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zidane
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsernameOrEmployees_Email(String username, String email);
    
}
