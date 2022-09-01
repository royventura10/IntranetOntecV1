/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Estado;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isEstado {
    
        public List<Estado> ListaEstado();
    public Optional<Estado> ListarxCodEstado(int cod_est);
    public void GuardarEstado(Estado estado);
    public void EliminarEstado(int cod_est);
}
