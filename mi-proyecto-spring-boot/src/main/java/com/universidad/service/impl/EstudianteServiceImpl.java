package com.universidad.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;

import jakarta.annotation.PostConstruct;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }
    
    @PostConstruct
    public void init() {
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstudianteDTO> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudianteGuardado = estudianteRepository.save(convertToEntity(estudianteDTO));
        return convertToDTO(estudianteGuardado);
    }

    @Override
    public Optional<EstudianteDTO> actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        return estudianteRepository.findById(id).map(est -> {
            est.setNombre(estudianteDTO.getNombre());
            est.setApellido(estudianteDTO.getApellido());
            est.setEmail(estudianteDTO.getEmail());
            est.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
            est.setNroInscripcion(estudianteDTO.getNroInscripcion()); 
            return convertToDTO(estudianteRepository.save(est));
        });
    }

    @Override
    public boolean eliminarEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .nroInscripcion(estudiante.getNroInscripcion()) 
                .build();
    }

    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .nroInscripcion(estudianteDTO.getNroInscripcion()) 
                .build();
    }
}
