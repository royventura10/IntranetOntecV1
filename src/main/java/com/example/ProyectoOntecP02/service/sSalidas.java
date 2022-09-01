/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isSalidas;
import com.example.ProyectoOntecP02.interfaces.iSalidas;
import com.example.ProyectoOntecP02.model.Salidas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sSalidas implements isSalidas {

     @Autowired
    private iSalidas dataSalidas;
    
    @Override
    public List<Salidas> ListarSalidas() {
          return(List<Salidas>) dataSalidas.findAll();   
    }

    @Override
    public Optional<Salidas> ListarSalidasId(int cod_sal) {
            return dataSalidas.findById(cod_sal);
    }

    @Override
    public void Guardar(Salidas s) {
            dataSalidas.save(s);
    }

    @Override
    public void Eliminar(int cod_sal) {
            dataSalidas.deleteById(cod_sal);
    }
    
}
