/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isEquipos;
import com.example.ProyectoOntecP02.interfaces.iEquipos;
import com.example.ProyectoOntecP02.model.Equipos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class sEquipos implements isEquipos{

    
    @Autowired
    private iEquipos dataEquipos;
    
    
    @Override
    public List<Equipos> ListarEquipo() {
            return(List<Equipos>) dataEquipos.findAll();  
    }

    @Override
    public Optional<Equipos> ListarEquipoId(int cod_equ) {
            return dataEquipos.findById(cod_equ);
    }

    @Override
    public void Guardar(Equipos e) {
            dataEquipos.save(e);
    }

    @Override
    public void Eliminar(int cod_equ) {
            dataEquipos.deleteById(cod_equ);
    }
    
    @Override
    public List<Equipos> findAll(String nom_equi) {
       if(nom_equi != null){
         return (List<Equipos>) dataEquipos.findBynom_equi(nom_equi);
        }
        
        return ListarEquipo();
    }
}
