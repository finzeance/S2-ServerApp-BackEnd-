/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.serverapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zd_region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // UNTUK SEQUENCE ID DI PRIMARY KEY
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "region")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Countries> countries;

}
