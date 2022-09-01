/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoOntecP02.model;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection con;
    public Connection getConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://34.127.7.112:3306/db_ontec_22_1?serverTimezone-UTC","root","Piura2022#$%");
            
        }catch(Exception e)
        {
        
        }
        return con;
    }
}
