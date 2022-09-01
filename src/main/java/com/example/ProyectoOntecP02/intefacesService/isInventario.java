/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Inventario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isInventario {
    public List<Inventario> ListarInventario();
    public Optional<Inventario> ListarInventarioId(int cod_inv);
    public void Guardar(Inventario i);
    public void Eliminar (int cod_inv);
}
