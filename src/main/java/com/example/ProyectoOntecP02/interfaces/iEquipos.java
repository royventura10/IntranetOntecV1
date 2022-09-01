/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoOntecP02.interfaces;

import com.example.ProyectoOntecP02.model.Equipos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface iEquipos extends CrudRepository<Equipos, Integer>{
  @Query(value=" SELECT * FROM equipos WHERE nom_equi LIKE %:nomequi% ", nativeQuery=true)
  public List<Equipos> findBynom_equi(@Param("nomequi") String nomequi);
}
