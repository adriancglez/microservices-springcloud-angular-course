package com.smoothiemx.web.app.repositories;

import com.smoothiemx.web.app.models.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
}
