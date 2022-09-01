/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isInventario;
import com.example.ProyectoOntecP02.model.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class cInventario {
    
    @Autowired
    private isInventario isInventario;
     
    @GetMapping("/MInventario")
    public String ListarInventario(Model model) {
        List<Inventario> ListarInventario = isInventario.ListarInventario();
        model.addAttribute("ListarInventario", ListarInventario);
        return "MInventario";
    }
}
