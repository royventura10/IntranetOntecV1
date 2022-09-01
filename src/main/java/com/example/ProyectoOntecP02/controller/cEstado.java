/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isEstado;
import com.example.ProyectoOntecP02.model.Estado;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class cEstado {
    @Autowired
    private isEstado isEstado;

    
    
    @GetMapping("/MEstado")
    public String ListarEstado(Model model) {
        List<Estado> ListarEstado = isEstado.ListaEstado();
        model.addAttribute("ListarEstado", ListarEstado);
        return "MEstado";
    }
    
    
     @RequestMapping(value="/GuardarEstado", method=RequestMethod.POST)
    public String GuardarEstado (
            @RequestParam("nom_est") String nom_est,
            Model model){
        //Guardar
        Estado e = new Estado();
        e.setNom_est(nom_est);
        isEstado.GuardarEstado(e);
        //Listar
       List<Estado> ListarEstado = isEstado.ListaEstado();
        model.addAttribute("ListarEstado", ListarEstado);
        return "redirect:/MEstado";
    }
    
    @GetMapping("/EEstados")
    public String editar (@RequestParam(value="cod_est") int id,Model model){
        
        Optional<Estado> ListarEstado = isEstado.ListarxCodEstado(id);
        model.addAttribute("ListarEstado", ListarEstado);
        return "EEstados"; //editar.html
    }
    
    @RequestMapping(value="/actualizar",method=RequestMethod.POST)
     public String actualizar( @RequestParam("cod_est")int cod_est,@RequestParam("nom_est")String nom_est,Model model){
         //Actualizar
         Estado e  = new Estado();
        e.setCod_est(cod_est);
        e.setNom_est(nom_est);
         isEstado.GuardarEstado(e);
         
         //Listar
          List<Estado> ListarEstado = isEstado.ListaEstado();
        model.addAttribute("ListarEstado", ListarEstado);
        return "MEstado";
     }
}
