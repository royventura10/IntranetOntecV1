/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Venta;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isVenta {
    public List<Venta> ListarVenta();
    public Optional<Venta> ListarVentaId(int cod_ven);
    public List<Venta> findAll(String fechaventa);
    public void Guardar(Venta v);
    public void Eliminar (int cod_ven);
}