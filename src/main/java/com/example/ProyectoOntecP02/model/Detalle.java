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
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int cod_det;
    public int cantidad;
    public double subtotal;
    public double total;
    
    @ManyToOne()
    @JoinColumn(name="Equipo_cod_equ")
    private Equipos equipos;
    
    @ManyToOne()
    @JoinColumn(name="Venta_cod_ven")
    private Venta venta;

    
}
