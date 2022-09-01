/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 

import javax.servlet.http.*;

@Controller
public class Prueba extends HttpServlet {
    
    
    @GetMapping("/Prueba")
    public String prueba(HttpServletRequest request, HttpServletResponse response,Model model)
    {
        //para setear
      //request.getSession().setAttribute("userid", "1");
      
        //para obtener
        String Sesionid;
      try{
          Sesionid=request.getSession().getAttribute("userid").toString();
      }catch(Exception e)
      {
        Sesionid="";
      }
      //para borrar
      request.getSession().removeAttribute("userid");
      model.addAttribute("prueba", Sesionid);
      return "Prueba";
    }
}
