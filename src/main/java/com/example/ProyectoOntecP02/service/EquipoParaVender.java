/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.model.Equipos;

/**
 *
 * @author Janssen Espinoza
 */
public class EquipoParaVender extends Equipos{
    private int cantidad;
     
    public void aumentarCantidad() {
        this.cantidad++;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getTotal() {
        return this.getPrecio() * this.cantidad;
    }
}
