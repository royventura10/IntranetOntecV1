/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.model.Conexion;
import com.example.ProyectoOntecP02.model.Equipos;
import com.example.ProyectoOntecP02.model.Inventario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class DAOProducto {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    public List listar()
    {
        List<Inventario> i = new ArrayList();
        List<Equipos> equipos =new ArrayList();
         String sql="SELECT * FROM equipos";
         try
         {
             con=cn.getConnection();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
             Equipos e=new Equipos();
             e.setCod_equi(rs.getInt(1));
             e.setNom_equi(rs.getString(2));
             e.setImg_pro(rs.getString(3));
             e.setPrecio(rs.getFloat(4));
             e.setImg_pro(rs.getString(5));
             e.setInventario(i);
             equipos.add(e);
             
             }
         }catch(Exception e)
         {
         
         }
         return equipos;
    }
    
    public void listarImg(int id, HttpServletResponse response)
    {
     String sql = "select * from equipos where cod_equi = "+id;
     InputStream inputStream = null;
     OutputStream outputStream = null;
     BufferedInputStream bufferedInputStream =null;
     BufferedOutputStream bufferedOutputStream=null;
     try {
         outputStream = response.getOutputStream();
         con=cn.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
          if(rs.next())
          {
          inputStream = rs.getBinaryStream("Img_pro");
          }
          bufferedInputStream = new BufferedInputStream(inputStream);
          bufferedOutputStream = new BufferedOutputStream(outputStream);
          int i = 0;
          while((i=bufferedInputStream.read())!=-1)
          {
          bufferedOutputStream.write(i);
          }
     }catch (Exception e)
     {
     
     }
     
    }
    
}
