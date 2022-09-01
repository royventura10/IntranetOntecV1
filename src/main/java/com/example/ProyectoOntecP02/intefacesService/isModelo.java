/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Modelo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isModelo {
    public List<Modelo> ListarModelo();
    public Optional<Modelo> ListarModeloId(int cod_mod);
    public void Guardar(Modelo m);
    public void Eliminar (int cod_mod);
}
