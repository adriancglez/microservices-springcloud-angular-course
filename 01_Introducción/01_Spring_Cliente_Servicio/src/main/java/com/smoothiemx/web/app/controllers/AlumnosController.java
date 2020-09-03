package com.smoothiemx.web.app.controllers;

import com.andromeda.design.web.app.controllers.CommonController;
import com.smoothiemx.web.app.models.Alumno;
import com.smoothiemx.web.app.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnosController extends CommonController<Alumno, IAlumnoService> {

    public AlumnosController(IAlumnoService service) {
        super(service);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> putUpdate(@RequestBody Alumno alumno, @PathVariable Long id) {

        Optional<Alumno> optionalAlumno = super.service.findById(id);

        if (optionalAlumno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoResponse = optionalAlumno.get();
        alumnoResponse.setNombre(alumno.getNombre());
        alumnoResponse.setApellido(alumno.getApellido());
        alumnoResponse.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(super.service.save(alumnoResponse));
    }
}