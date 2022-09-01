/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isCliente;
import com.example.ProyectoOntecP02.interfaces.iCliente;
import com.example.ProyectoOntecP02.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class sCliente implements isCliente{

    @Autowired
    private iCliente dataCliente;
    
    @Override
    public List<Cliente> ListarCliente() {
            return(List<Cliente>) dataCliente.findAll();     
    }

    @Override
    public Optional<Cliente> ListarClienteId(int cod_cli) {
            return dataCliente.findById(cod_cli);
    }

    @Override
    public void Guardar(Cliente c) {
            dataCliente.save(c);
    }

    @Override
    public void Eliminar(int cod_cli) {
        dataCliente.deleteById(cod_cli);
    }
    
}
