package com.smoothiemx.web.app.services;

import com.smoothiemx.web.app.models.Alumno;

import java.util.Optional;

public interface IAlumnoService {

    Iterable<Alumno> findAll();

    Optional<Alumno> findById(Long id);

    Alumno save(Alumno alumno);

    void deleteById(Long id);
}