/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.interfaces;


import com.example.ProyectoOntecP02.model.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iVenta extends CrudRepository<Venta, Integer>{
  @Query(value="SELECT * FROM venta WHERE fecha_venta LIKE %:fechaventa%",nativeQuery=true)
  public List<Venta> findByFecha_Venta(@Param("fechaventa") String fechaventa);
}