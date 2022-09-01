/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.intefacesService;

import com.example.ProyectoOntecP02.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Janssen Espinoza
 */
public interface isUsuario {
    public List<Usuario> findByUsuario(String usuario);
    public List<Usuario> ListaUsuario();
    public Optional<Usuario> ListarxCodUsuario(int cod_usu);
    public void GuardarUsuario(Usuario usuario);
    public void EliminarUsuario(int cod_usu);
}
