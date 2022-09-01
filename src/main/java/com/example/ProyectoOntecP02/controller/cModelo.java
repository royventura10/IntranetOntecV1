/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isModelo;
import com.example.ProyectoOntecP02.model.Modelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class cModelo {
    
    @Autowired
    private isModelo isModelo;  
    
     @GetMapping("/MModelo")
    public String ListarModelo(Model model) {
        List <Modelo> ListarModelo = isModelo.ListarModelo();
        model.addAttribute("ListarModelo",ListarModelo);
        return "MModelo";
    }
     @RequestMapping(value="/GuardarModelo", method=RequestMethod.POST)
    public String guardar (
            @RequestParam("nom_mod") String nom_mod,
            Model model){
        //Guardar tabla equipos
        Modelo m = new Modelo();
        m.setNom_mod(nom_mod);
        isModelo.Guardar(m);
        
       
        
        List<Modelo> Modelo = isModelo.ListarModelo();
        model.addAttribute("Modelo",Modelo);
        return "redirect:/MModelo";
    }
}
