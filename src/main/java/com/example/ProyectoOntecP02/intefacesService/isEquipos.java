/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Equipos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isEquipos {
    public List<Equipos> ListarEquipo();
    public List<Equipos> findAll(String nom_equi);
    public Optional<Equipos> ListarEquipoId(int cod_equ);
    public void Guardar(Equipos e);
    public void Eliminar (int cod_equ);
}
