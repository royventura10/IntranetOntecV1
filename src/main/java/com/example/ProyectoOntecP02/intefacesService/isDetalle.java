/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Detalle;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isDetalle {
     public List<Detalle> ListaDetalle();
    public Optional<Detalle> ListarxCodDet(int cod_det);
    public void GuardarDetalle(Detalle detalle);
    public void EliminarDetalle(int cod_det);
}
