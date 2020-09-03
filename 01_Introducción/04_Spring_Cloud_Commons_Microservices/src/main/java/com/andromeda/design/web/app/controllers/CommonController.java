package com.andromeda.design.web.app.controllers;

import com.andromeda.design.web.app.services.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class CommonController<E, S extends ICommonService<E>> {

    protected S service;

    @Autowired
    public CommonController(S service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> ver(@PathVariable Long id) {

        Optional<E> optional = this.service.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optional.get());
    }

    @PostMapping
    ResponseEntity<?> postCreate(@RequestBody E entity) {
        E response = this.service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delDelete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}