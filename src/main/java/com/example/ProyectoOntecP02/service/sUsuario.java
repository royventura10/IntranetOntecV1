/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.isUsuario;
import com.example.ProyectoOntecP02.interfaces.iUsuario;
import com.example.ProyectoOntecP02.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sUsuario implements isUsuario{

    @Autowired //Inyectar las dependencias , para que no haya problemas en trabajar con todas las interfaces en todas las clases
    private iUsuario dataUsuario;

    
    @Override
    public List<Usuario> ListaUsuario() {
                return (List<Usuario>) dataUsuario.findAll();
    }

    @Override
    public Optional<Usuario> ListarxCodUsuario(int cod_usu) {
     return dataUsuario.findById(cod_usu);
    }

    @Override
    public void GuardarUsuario(Usuario usuario) {
        dataUsuario.save(usuario);
    }

    @Override
    public void EliminarUsuario(int cod_usu) {
        dataUsuario.deleteById(cod_usu);
    }
   
    

    @Override
    public List<Usuario> findByUsuario(String usuario) {
        if(usuario != null){
         return (List<Usuario>) dataUsuario.findBynomusuStartsWith(usuario);
        }
        
        return ListaUsuario();
        }
}

    

