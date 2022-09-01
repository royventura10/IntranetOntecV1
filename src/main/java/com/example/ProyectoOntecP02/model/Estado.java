/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int cod_est;
    public String nom_est;
    
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Usuario> usuario;
}
