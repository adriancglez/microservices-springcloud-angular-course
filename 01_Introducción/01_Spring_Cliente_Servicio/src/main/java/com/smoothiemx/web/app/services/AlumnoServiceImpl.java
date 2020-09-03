package com.smoothiemx.web.app.services;

import com.andromeda.design.web.app.services.CommonServiceImpl;
import com.smoothiemx.web.app.models.Alumno;
import com.smoothiemx.web.app.repositories.IAlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService {

    public AlumnoServiceImpl(IAlumnoRepository repository) {
        super(repository);
    }
}
