/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isCliente {
     public List<Cliente> ListarCliente();
    public Optional<Cliente> ListarClienteId(int cod_cli);
    public void Guardar(Cliente c);
    public void Eliminar (int cod_cli);
}
