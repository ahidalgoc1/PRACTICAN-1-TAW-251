package com.universidad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.universidad.dto.EstudianteDTO;
import com.universidad.service.IEstudianteService;

@RestController
@RequestMapping("/api/estudiantes") // Ahora la ruta base es "/api/estudiantes"
public class EstudianteController {
    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping // GET /api/estudiantes
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id) {
        Optional<EstudianteDTO> estudiante = estudianteService.obtenerEstudiantePorId(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping 
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO nuevoEstudiante = estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.status(201).body(nuevoEstudiante); // 201 Created
    }

    @PutMapping("/{id}") // PUT /api/estudiantes/{id}
    public ResponseEntity<EstudianteDTO> actualizarEstudiante
    (@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        Optional<EstudianteDTO> actualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
        return actualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // DELETE /api/estudiantes/{id}
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        boolean eliminado = estudianteService.eliminarEstudiante(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

