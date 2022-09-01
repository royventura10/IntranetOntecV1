/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isEstado;
import com.example.ProyectoOntecP02.interfaces.iEstado;
import com.example.ProyectoOntecP02.model.Estado;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class sEstado implements isEstado{

    @Autowired //Inyectar las dependencias , para que no haya problemas en trabajar con todas las interfaces en todas las clases
    private iEstado dataEstado;

    @Override
    public List<Estado> ListaEstado() {
       return (List<Estado>) dataEstado.findAll();    
    }

    @Override
    public Optional<Estado> ListarxCodEstado(int cod_est) {
                 return dataEstado.findById(cod_est);
    }

    @Override
    public void GuardarEstado(Estado e) {
         dataEstado.save(e);
    }

    @Override
    public void EliminarEstado(int cod_est) {
         dataEstado.deleteById(cod_est);
    }
    
}
