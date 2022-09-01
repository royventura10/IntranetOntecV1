/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Salidas;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isSalidas {
    public List<Salidas> ListarSalidas();
    public Optional<Salidas> ListarSalidasId(int cod_sal);
         public void Guardar(Salidas s);
    public void Eliminar (int cod_sal);
}
