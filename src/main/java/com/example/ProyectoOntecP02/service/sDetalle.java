/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isDetalle;
import com.example.ProyectoOntecP02.interfaces.iDetalle;
import com.example.ProyectoOntecP02.model.Detalle;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sDetalle implements isDetalle{

     @Autowired //Inyectar las dependencias , para que no haya problemas en trabajar con todas las interfaces en todas las clases
    private iDetalle dataDetalle;

    @Override
    public List<Detalle> ListaDetalle() {
        return (List<Detalle>) dataDetalle.findAll();
    }

    @Override
    public Optional<Detalle> ListarxCodDet(int cod_det) {
        return dataDetalle.findById(cod_det);
    }

    @Override
    public void GuardarDetalle(Detalle detalle) {
            dataDetalle.save(detalle);
    }

    @Override
    public void EliminarDetalle(int cod_det) {
         dataDetalle.deleteById(cod_det);
    }
    
}
