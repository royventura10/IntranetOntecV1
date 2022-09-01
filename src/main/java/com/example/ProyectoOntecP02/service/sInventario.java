/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isInventario;
import com.example.ProyectoOntecP02.interfaces.iInventario;
import com.example.ProyectoOntecP02.model.Inventario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class sInventario implements isInventario{

    @Autowired
    private iInventario dataInventario;
    
    @Override
    public List<Inventario> ListarInventario() {
            return(List<Inventario>) dataInventario.findAll();  
    }

    @Override
    public Optional<Inventario> ListarInventarioId(int cod_inv) {
            return dataInventario.findById(cod_inv);
    }

    @Override
    public void Guardar(Inventario i) {
             dataInventario.save(i);
    }

    @Override
    public void Eliminar(int cod_inv) {
            dataInventario.deleteById(cod_inv);
    }
    
}
