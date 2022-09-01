/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import com.example.ProyectoOntecP02.model.Usuario;
import com.example.ProyectoOntecP02.service.DAOUsuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.*;
@Controller
public class controladorP{
  
     
    DAOUsuario dao= new DAOUsuario();
    Usuario u=new Usuario(); 
    boolean r;
    
   @GetMapping("/controladorP")
    public String editar (HttpServletRequest request, HttpServletResponse response, @RequestParam(value="nomusu") String nomusu,
            @RequestParam(value="claveusu") String claveusu,Model model){
        
        return "redirect:/EcommerceProduct";
           /*r=dao.validar(nomusu,claveusu);
         if(r== true)
           {
               request.getSession().setAttribute("userid", nomusu);
               return "redirect:/EcommerceProduct";
           }
         else {
             return "redirect:/";
         }*/
    }
    
    @GetMapping("/prueba")
    public String prueba ( @RequestParam(value="nomusu") String nomusu,
            @RequestParam(value="claveusu") String claveusu,Model model){
          
        return "hola"+claveusu;
        
    }
    
        
}
    
  
  

