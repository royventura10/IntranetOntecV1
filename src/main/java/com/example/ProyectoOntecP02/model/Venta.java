/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.model;

import java.util.List;
import java.util.Set;
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
@Table(name="venta")
public class Venta {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int cod_ven;
    public String Fecha_Venta;
    @ManyToOne()
    @JoinColumn(name="Cliente_cod_cli")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Detalle> detalle;
    
}
