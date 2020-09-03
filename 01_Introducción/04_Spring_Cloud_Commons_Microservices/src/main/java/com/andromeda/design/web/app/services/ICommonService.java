package com.andromeda.design.web.app.services;

import java.util.Optional;

public interface ICommonService<E> {

    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E save(E alumno);

    void deleteById(Long id);
}