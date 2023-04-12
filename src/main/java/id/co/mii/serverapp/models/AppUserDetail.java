/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Zidane
 */
@AllArgsConstructor
public class AppUserDetail implements UserDetails {

    private Users users;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        users.getRoles()
                .forEach(role -> {
                    String rolesName = "ROLE_" + role.getName().toUpperCase();
                    authorities.add(new SimpleGrantedAuthority(rolesName));
                    role.getPrivilege()
                            .forEach(privilege -> {
                                String privilegeName = privilege.getName().toUpperCase();
                                authorities.add(new SimpleGrantedAuthority(privilegeName));
                            });
                });
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return users.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return users.getIsEnabled();
    }

}
