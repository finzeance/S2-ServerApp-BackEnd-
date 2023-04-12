/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.models.dto.requests;

import lombok.Data;

/**
 *
 * @author Zidane
 */
@Data
public class UsersRequest {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    
}
