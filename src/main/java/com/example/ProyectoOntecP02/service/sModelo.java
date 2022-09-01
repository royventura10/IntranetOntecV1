/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isModelo;
import com.example.ProyectoOntecP02.interfaces.iModelo;
import com.example.ProyectoOntecP02.model.Modelo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class sModelo implements isModelo{

    @Autowired
    private iModelo dataModelo;
    
    @Override
    public List<Modelo> ListarModelo() {
        return(List<Modelo>) dataModelo.findAll();     
    }

    @Override
    public Optional<Modelo> ListarModeloId(int cod_mod) {
        return dataModelo.findById(cod_mod);
    }

    @Override
    public void Guardar(Modelo m) {
            dataModelo.save(m);
    }

    @Override
    public void Eliminar(int cod_mod) {
             dataModelo.deleteById(cod_mod);
    }
    
}
