/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isCliente;
import com.example.ProyectoOntecP02.intefacesService.isDetalle;
import com.example.ProyectoOntecP02.intefacesService.isEquipos;
import com.example.ProyectoOntecP02.intefacesService.isVenta;
import com.example.ProyectoOntecP02.model.Cliente;
import com.example.ProyectoOntecP02.model.Detalle;
import com.example.ProyectoOntecP02.model.Equipos;
import com.example.ProyectoOntecP02.model.Venta;
import com.example.ProyectoOntecP02.service.DAOUsuario;
import java.time.LocalDate;

import java.util.List;
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
public class cVenta {
    @Autowired
    private isVenta isVenta;
    @Autowired
    private isCliente isCliente;
    @Autowired
    private isDetalle isDetalle;
    @Autowired
    private isEquipos isEquipos;
    DAOUsuario dao= new DAOUsuario();
    int r;
    @RequestMapping("/MVenta")
    public String ListarVenta(Model model ,@Param("Fecha_Venta") String Fecha_Venta) {
        List <Venta> ListarVenta = isVenta.findAll(Fecha_Venta);
        model.addAttribute("ListarVenta",ListarVenta);
        List <Cliente> ListarCliente = isCliente.ListarCliente();
        model.addAttribute("ListarCliente",ListarCliente);
        List <Detalle> ListarDetalle = isDetalle.ListaDetalle();
        model.addAttribute("ListarDetalle",ListarDetalle);
        return "MVenta";
    }
    
      @GetMapping("/GVenta")
    public String Listarequipos(Model model) {
        List <Equipos> equipos = isEquipos.ListarEquipo();
        model.addAttribute("equipos",equipos);
        List <Detalle> ListarDetalle = isDetalle.ListaDetalle();
        model.addAttribute("ListarDetalle",ListarDetalle);
        List <Cliente> cliente = isCliente.ListarCliente();
        model.addAttribute("cliente",cliente);
        return "GVenta";
    }
    
    @RequestMapping(value="/SumarEquipo", method=RequestMethod.POST)
    public String guardar (
            @RequestParam("equipos") List<Equipos> equipos,
            @RequestParam("cliente") Cliente cliente,
            @RequestParam("precio") List<String> precio,
            @RequestParam("cantidad") List<String> cantidad,
             Model model){
        
        int codigoVenta = 0;
        LocalDate localDate = LocalDate.now();
        
        // Insertar a tabla venta
        Venta v = new Venta();
        v.setCliente(cliente);
        v.setFecha_Venta(localDate.toString());
        isVenta.Guardar(v);
        // Obtener el id generado SELECT max(id) as id FROM venta
        r=dao.retornarvalor();
        Venta v2 = new Venta();
        v2.setCod_ven(r+1);
        
        Detalle d;
        for (int i = 0; i < equipos.size(); i++) {
        d = new Detalle();
        d.setVenta(v2);
        d.setEquipos(equipos.get(i));
        d.setTotal(Double.parseDouble(precio.get(i))*Double.parseDouble(cantidad.get(i)));
        d.setSubtotal(Double.parseDouble(precio.get(i))*Double.parseDouble(cantidad.get(i)));
        d.setCantidad(Integer.parseInt(cantidad.get(i)));
        isDetalle.GuardarDetalle(d);
        }
        
        return "redirect:/GVenta";
    }
     
}
