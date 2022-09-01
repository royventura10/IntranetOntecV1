/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isCliente;
import com.example.ProyectoOntecP02.model.Cliente;
import java.util.Date;
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
public class cCliente {
    @Autowired
    private isCliente isCliente;
    
     @GetMapping("/MCliente")
    public String ListarClientes(Model model) {
   
        List<Cliente> ListarClientes = isCliente.ListarCliente();
        model.addAttribute("ListarClientes", ListarClientes);
        return "MCliente";
    }
    
     @RequestMapping(value="/GuardarCliente", method=RequestMethod.POST)
    public String guardar (
            @RequestParam("ruc_cli") String ruc_cli ,
            @RequestParam("rs_cli") String rs_cli,
            @RequestParam("direccion")  String direccion,
            @RequestParam("Fecha_Ingreso")  String Fecha_Ingreso,
            Model model){
        //Guardar
        Cliente c = new Cliente();
        c.setRuc_cli(ruc_cli);
        c.setRs_cli(rs_cli);
        c.setDireccion(direccion);
        c.setFecha_Ingreso(Fecha_Ingreso);
        isCliente.Guardar(c);
        //Listar
       List<Cliente> ListarClientes = isCliente.ListarCliente();
        model.addAttribute("ListarClientes", ListarClientes);
        return "redirect:/MCliente";
    }
    
     @GetMapping("/ECliente")
    public String editar (@RequestParam(value="cod_cli") int cod_cli,Model model){
        
        Optional<Cliente> ListarClientes = isCliente.ListarClienteId(cod_cli);
        model.addAttribute("ListarClientes", ListarClientes);
        return "ECliente"; //editar.html
    }
    
    @RequestMapping(value="/actualizarc",method=RequestMethod.POST)
     public String actualizar( @RequestParam("cod_cli")int cod_cli,
                               @RequestParam("ruc_cli")String ruc_cli,
                               @RequestParam("rs_cli")String rs_cli,
                               @RequestParam("direccion")String direccion,
                               @RequestParam("Fecha_Ingreso")String Fecha_Ingreso,
                               Model model){
         //Actualizar
        Cliente c = new Cliente();
        c.setCod_cli(cod_cli);
        c.setRuc_cli(ruc_cli);
        c.setRs_cli(rs_cli);
        c.setDireccion(direccion);
        c.setFecha_Ingreso(Fecha_Ingreso);
        isCliente.Guardar(c);
        //Listar
       List<Cliente> ListarClientes = isCliente.ListarCliente();
        model.addAttribute("ListarClientes", ListarClientes);
        return "redirect:/MCliente";
     }
}
