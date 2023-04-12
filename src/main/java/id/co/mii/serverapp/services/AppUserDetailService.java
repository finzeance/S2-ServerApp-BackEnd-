/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.AppUserDetail;
import id.co.mii.serverapp.models.Users;
import id.co.mii.serverapp.repositories.UsersRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zidane
 */
@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsernameOrEmployees_Email(username, username)
            .orElseThrow(() -> 
                    new UsernameNotFoundException("USERNAME OR EMAIL INCORRECT"));
        return new AppUserDetail(users);

    }

}
