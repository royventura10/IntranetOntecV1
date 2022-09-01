/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;



import com.example.ProyectoOntecP02.intefacesService.isEstado;
import com.example.ProyectoOntecP02.intefacesService.isUsuario;
import com.example.ProyectoOntecP02.model.Estado;
import com.example.ProyectoOntecP02.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class cUsuario {
    @Autowired
    private isUsuario isUsuario;

    @Autowired
    private isEstado isEstado;
     @GetMapping("/login")
    public String inicio(Model model) {
        return "login";
    }
    @RequestMapping("/MUsuario")
    public String ListarUsuarios(Model model,@Param("nomusu") String nomusu) {
 
        List<Usuario> ListarUsuarios = isUsuario.findByUsuario(nomusu);
        model.addAttribute("ListarUsuarios", ListarUsuarios);
        List <Estado> estado = isEstado.ListaEstado();
        model.addAttribute("estado",estado);
        return "MUsuario";
    }
    
    @RequestMapping(value="/GuardarUsuario", method=RequestMethod.POST)
    public String guardar (
            @RequestParam("nom_usu") String nom_usu,
            @RequestParam("claveusu") String clave_usu,
            @RequestParam("estado")  Estado estado,
            Model model){
        //Guardar
        Usuario u = new Usuario();
        u.setNomusu(nom_usu);
        u.setClaveusu(clave_usu);
        u.setEstado(estado);
        isUsuario.GuardarUsuario(u);
        //Listar
        
        List <Usuario> usuarios = isUsuario.ListaUsuario();
        model.addAttribute("usuarios",usuarios);
        return "redirect:/MUsuario";
    }
    
    
     @GetMapping("/EUsuario")
    public String editar (@RequestParam(value="cod_usu") int cod_usu,Model model){
        
        Optional<Usuario> ListarUsuarios = isUsuario.ListarxCodUsuario(cod_usu);
        model.addAttribute("ListarUsuarios", ListarUsuarios);
        List <Estado> estado = isEstado.ListaEstado();
        model.addAttribute("estado",estado);
        return "EUsuario"; //editar.html
    }
    
   @RequestMapping(value="/actualizaru",method=RequestMethod.POST)
     public String actualizar( @RequestParam("cod_usu")int cod_usu,
                               @RequestParam("nomusu")String nom_usu,
                               @RequestParam("claveusu")String clave_usu,
                               @RequestParam("estado")Estado estado,Model model)
     {
         //Actualizar
           Usuario u = new Usuario();
        u.setCod_usu(cod_usu);
        u.setNomusu(nom_usu);
        u.setClaveusu(clave_usu);
        u.setEstado(estado);
        isUsuario.GuardarUsuario(u);
         
         //Listar
          List<Usuario> ListarUsuarios = isUsuario.ListaUsuario();
        model.addAttribute("ListarUsuarios",ListarUsuarios);
        
         return "redirect:/MUsuario";
     }
   
}
