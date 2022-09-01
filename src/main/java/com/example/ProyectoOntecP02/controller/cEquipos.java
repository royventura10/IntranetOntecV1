/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.intefacesService.isEquipos;
import com.example.ProyectoOntecP02.intefacesService.isInventario;
import com.example.ProyectoOntecP02.intefacesService.isModelo;
import com.example.ProyectoOntecP02.intefacesService.isUsuario;
import com.example.ProyectoOntecP02.model.Equipos;
import com.example.ProyectoOntecP02.model.Inventario;
import com.example.ProyectoOntecP02.model.Modelo;
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
public class cEquipos {
    @Autowired
    private isEquipos isEquipos;
    
     @Autowired
    private isUsuario isUser;
      @Autowired
    private isModelo isModelo;
       @Autowired
    private isInventario isInventario;
       
    @RequestMapping("/MEquipos")
    public String listar(Model model,@Param("nom_equi") String nom_equi)
    {
        List<Equipos> Equipos1 = isEquipos.findAll(nom_equi);
        model.addAttribute("Equipos1",Equipos1);
        List<Modelo> ListarModelos = isModelo.ListarModelo();
        model.addAttribute("ListarModelos",ListarModelos);
        List<Usuario> ListarUsuarios = isUser.ListaUsuario();
        model.addAttribute("ListarUsuarios",ListarUsuarios);
        return"MEquipos";
    }

     @RequestMapping(value="/GuardarEquipos", method=RequestMethod.POST)
    public String guardar (
            @RequestParam("nom_equi") String nom_equi,
            @RequestParam("num_serie") String num_serie,
            @RequestParam("precio") float precio,
            @RequestParam("Cantidad") int cantidad,
            @RequestParam("ListarModelos")  Modelo modelo,
            @RequestParam("ListarUsuarios")  Usuario usuario,
            @RequestParam("img_pro") String img_pro,
            Model model){
        //Guardar tabla equipos
        Equipos e = new Equipos();
        e.setNom_equi(nom_equi);
        e.setNum_serie(num_serie);
        e.setPrecio(precio);
        e.setCantidad(cantidad);
        e.setModelo(modelo);
        e.setUsuario(usuario);
        e.setImg_pro(img_pro);
        isEquipos.Guardar(e);
        
        //guardar tabla inventario ingreso de equipos
        Inventario i = new Inventario();
        i.setEquipos(e);
        i.setCant_ing(cantidad);
        i.setCant_sal(0);
        i.setStock(cantidad);
        isInventario.Guardar(i);
        
        List<Equipos> Equipos = isEquipos.ListarEquipo();
        model.addAttribute("Equipos",Equipos);
        return "redirect:/MEquipos";
    }
       @GetMapping("/EcommerceProduct")
    public String EcommerceProduct(Model model) {
       //String Sesionid= request.getSession().getAttribute("userid").toString();
        List<Equipos> Equipos = isEquipos.ListarEquipo();
        model.addAttribute("Equipos",Equipos);
        List<Modelo> ListarModelos = isModelo.ListarModelo();
        model.addAttribute("ListarModelos",ListarModelos);
        
        return "/EcommerceProduct";
    }
       @GetMapping("/EEquipos")
    public String editar (@RequestParam(value="cod_equi") int cod_equi,Model model){
        
        Optional<Equipos> Equipos = isEquipos.ListarEquipoId(cod_equi);
       model.addAttribute("Equipos",Equipos);
        List<Modelo> ListarModelos = isModelo.ListarModelo();
        model.addAttribute("ListarModelos",ListarModelos);
        List<Usuario> ListarUsuarios = isUser.ListaUsuario();
        model.addAttribute("ListarUsuarios",ListarUsuarios);
        return "EEquipos"; //editar.html
    }
    
    @RequestMapping(value="/actualizare",method=RequestMethod.POST)
     public String actualizar( @RequestParam("cod_equi")int cod_equi,
                               @RequestParam("num_serie")String num_serie,
                               @RequestParam("nom_equi")String nom_equi,
                               @RequestParam("precio")float precio,
                               @RequestParam("cantidad")int cantidad,
                               @RequestParam("ListarModelos")Modelo modelo,
                               @RequestParam("ListarUsuarios")  Usuario usuario,
                               @RequestParam("img_pro") String img_pro,
                               Model model){
         //Actualizar
        Equipos e = new Equipos();
       e.setCod_equi(cod_equi);
       e.setNum_serie(num_serie);
       e.setNom_equi(nom_equi);
       e.setPrecio(precio);
       e.setCantidad(cantidad);
       e.setModelo(modelo);
       e.setUsuario(usuario);
       e.setImg_pro(img_pro);
        isEquipos.Guardar(e);
        //Listar
       Optional<Equipos> Equipos = isEquipos.ListarEquipoId(cod_equi);
       model.addAttribute("Equipos",Equipos);
        return "redirect:/MEquipos";
     }
    
}
