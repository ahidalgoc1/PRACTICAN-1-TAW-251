package com.universidad.repository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.universidad.model.Estudiante;

import jakarta.annotation.PostConstruct;

@Repository
public class EstudianteRepository {
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(1);

    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    public List<Estudiante> findAll() {
        return new ArrayList<>(estudiantes.values());
    }

    public Optional<Estudiante> findById(Long id) {
        return Optional.ofNullable(estudiantes.get(id));
    }

    public boolean existsById(Long id) {
        return estudiantes.containsKey(id);
    }

    public void deleteById(Long id) {
        estudiantes.remove(id);
    }

    public Optional<Estudiante> findByNroInscripcion(String nroInscripcion) {
        return estudiantes.values().stream()
                .filter(e -> nroInscripcion.equals(e.getNroInscripcion()))
                .findFirst();
    }
    @PostConstruct 
    public void init() {
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .fechaNacimiento(LocalDate.of(2000, 5, 15))
                .nroInscripcion("S001")
                .build();

        Estudiante estudiante2 = Estudiante.builder()
                .nombre("María")
                .apellido("González")
                .email("maria.gonzalez@example.com")
                .fechaNacimiento(LocalDate.of(2001, 8, 22))
                .nroInscripcion("S002")
                .build();

        save(estudiante1);
        save(estudiante2);
    }
}
