package com.smoothiemx.web.app.controllers;

import com.smoothiemx.web.app.models.Alumno;
import com.smoothiemx.web.app.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnosController {

    IAlumnoService alumnoService;

    @Autowired
    public AlumnosController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    ResponseEntity<?> getAlumnos() {
        return ResponseEntity.ok().body(this.alumnoService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAlumno(@PathVariable Long id) {

        Optional<Alumno> optionalAlumno = this.alumnoService.findById(id);

        if (optionalAlumno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalAlumno.get());
    }

    @PostMapping
    ResponseEntity<?> postCreate(@RequestBody Alumno alumno) {
        Alumno alumnoResponse = this.alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> putUpdate(@RequestBody Alumno alumno, @PathVariable Long id) {

        Optional<Alumno> optionalAlumno = this.alumnoService.findById(id);

        if (optionalAlumno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoResponse = optionalAlumno.get();
        alumnoResponse.setNombre(alumno.getNombre());
        alumnoResponse.setApellido(alumno.getApellido());
        alumnoResponse.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoService.save(alumnoResponse));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delDelete(@PathVariable Long id) {
        this.alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}