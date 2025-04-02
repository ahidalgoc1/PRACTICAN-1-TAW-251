package com.universidad.service;

import java.util.List;
import java.util.Optional;

import com.universidad.dto.EstudianteDTO;

public interface IEstudianteService { 
    
    List<EstudianteDTO> obtenerTodosLosEstudiantes(); 
    
    Optional<EstudianteDTO> obtenerEstudiantePorId(Long id);
    
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);
    
    Optional<EstudianteDTO> actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    
    boolean eliminarEstudiante(Long id);
}
