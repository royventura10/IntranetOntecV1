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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int cod_equi;
    public String nom_equi;
    public String num_serie;
    public float precio;
    public int cantidad;
    public String img_pro;
    @ManyToOne()
    @JoinColumn(name="Usuario_cod_usu")
    private Usuario usuario;
    
    @ManyToOne()
    @JoinColumn(name="Modelo_cod_mod")
    private Modelo modelo;
    
    @OneToMany(mappedBy = "equipos", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Inventario> inventario;
    
    @OneToMany(mappedBy = "equipos", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Detalle> detalle;
    
}
