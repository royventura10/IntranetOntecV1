/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isVenta;
import com.example.ProyectoOntecP02.interfaces.iVenta;
import com.example.ProyectoOntecP02.model.Venta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sVenta implements isVenta{

      @Autowired
    private iVenta dataVenta;
    
    @Override
    public List<Venta> ListarVenta() {
             return(List<Venta>) dataVenta.findAll(); 
    }

    @Override
    public Optional<Venta> ListarVentaId(int cod_ven) {
             return dataVenta.findById(cod_ven);
    }

    @Override
    public void Guardar(Venta v) {
              dataVenta.save(v);
    }

    @Override
    public void Eliminar(int cod_ven) {
               dataVenta.deleteById(cod_ven);
    }

    @Override
    public List<Venta> findAll(String fechaventa) {
     if(fechaventa != null){
         return (List<Venta>) dataVenta.findByFecha_Venta(fechaventa);
        }
        
        return ListarVenta();   
    }
    
}
