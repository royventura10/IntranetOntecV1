/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.service;

import com.example.ProyectoOntecP02.model.Conexion;
import com.example.ProyectoOntecP02.model.VentasPorCli;
import com.example.ProyectoOntecP02.model.VentasPorDia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vakimu
 */
public class DAOReportes {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List ventasPorCli(){
        List<VentasPorCli> ventas =new ArrayList();
        String sql="select rs_cli, count(*) as total_ventas\n" +
                    "from db_ontec_22_1.cliente\n" +
                    "	inner join db_ontec_22_1.venta\n" +
                    "    on db_ontec_22_1.cliente.cod_cli = db_ontec_22_1.venta.cliente_cod_cli\n" +
                    "group by cod_cli\n" +
                    ";";
         try
         {
             con=cn.getConnection();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
             VentasPorCli e=new VentasPorCli();
             e.setRs_cli(rs.getString(1));
             e.setTotal_ventas(rs.getInt(2));
             ventas.add(e);
             
             }
         }catch(Exception e)
         {
         
         }
        return ventas;
    }
    
    public List ventasPorDia(){
        List<VentasPorDia> ventas =new ArrayList();
        String sql="select fecha_venta, count(*) as total_ventas_por_dia\n" +
                    "from db_ontec_22_1.venta\n" +
                    "group by fecha_venta;";
         try
         {
             con=cn.getConnection();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
             VentasPorDia e=new VentasPorDia();
             e.setFecha_venta(rs.getString(1));
             e.setTotal_ventas_por_dia(rs.getInt(2));
             ventas.add(e);
             
             }
         }catch(Exception e)
         {
         
         }
        return ventas;
    }
    
}
