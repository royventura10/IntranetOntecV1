/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isEquipos;
import com.example.ProyectoOntecP02.intefacesService.isInventario;
import com.example.ProyectoOntecP02.intefacesService.isVenta;
import com.example.ProyectoOntecP02.model.Inventario;
import com.example.ProyectoOntecP02.model.VentasPorCli;
import com.example.ProyectoOntecP02.model.VentasPorDia;
import com.example.ProyectoOntecP02.service.DAOReportes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vakimu
 */
@Controller
@RequestMapping
public class reportes {
    DAOReportes daoReporte = new DAOReportes();
    
    @Autowired
    private isInventario isInventario;
    
    @GetMapping("/ReporteEquipos")
    public String reporteEquipos(Model model) {
        List<Inventario> equipos = isInventario.ListarInventario();
        model.addAttribute("equipos",equipos);
        return "reportes/Equipos";
    }
    
    @GetMapping("/ReporteVentasporCli")
    public String reporteVentasporCli(Model model) {
        List <VentasPorCli> ListarVenta = daoReporte.ventasPorCli();
        model.addAttribute("ListarVenta",ListarVenta);
        return "reportes/ventas";
    }
    
    
    @GetMapping("/ReporteVentasporDia")
    public String reporteVentasporDia(Model model) {
        List <VentasPorDia> ListarVenta = daoReporte.ventasPorDia();
        model.addAttribute("ListarVenta",ListarVenta);
        return "reportes/ventasPorFecha";
    }
    
    
}
