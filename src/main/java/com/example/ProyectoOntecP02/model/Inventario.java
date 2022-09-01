/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="inventario")
public class Inventario {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int cod_inv;
    public int cant_ing;
    public int cant_sal;
    public int stock;
    @ManyToOne()
    @JoinColumn(name="Equipo_cod_inv")
    private Equipos equipos; 
    
    
}
