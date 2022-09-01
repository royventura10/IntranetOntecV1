/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.intefacesService.Validar;
import com.example.ProyectoOntecP02.model.Conexion;
import com.example.ProyectoOntecP02.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOUsuario implements Validar {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    public boolean validar(String nomusu, String claveusu) {
        boolean usuarior=false;
        String sql="SELECT nomusu, claveusu FROM usuario WHERE nomusu = ? AND claveusu = ? ";
        try
        {
         con=cn.getConnection();
         ps=con.prepareStatement(sql);
         ps.setString(1, nomusu);
         ps.setString(2, claveusu);
         rs=ps.executeQuery();
         System.out.println(rs);
         if(rs.next())
         {
             usuarior = true;
         }
         else{
             usuarior=false;
         }
         con.close();
        }catch(SQLException e)
        {
             System.err.println("Error al validar los datos."+e.getMessage());
          }finally
        {
        try{
        con.close();
        }catch(SQLException e)
        {
            System.out.println("Error" +e);
        }
        }
        System.out.println("Usuario Validado en el metodo es " + usuarior);
        return usuarior;
    }

    public int retornarvalor() {
        int v = 0;
        String sql="SELECT max(cod_ven) as id FROM venta";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            con.close();
        } catch(SQLException e)
        {
            System.err.println("Error al validar los datos."+e.getMessage());
        }
        return v;
    }
}
