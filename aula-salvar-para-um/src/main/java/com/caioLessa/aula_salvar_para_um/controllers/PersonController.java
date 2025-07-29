package com.caioLessa.aula_salvar_para_um.controllers;

import com.caioLessa.aula_salvar_para_um.dto.PersonDepartmentDTO;
import com.caioLessa.aula_salvar_para_um.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insert(PersonDepartmentDTO dto) {
        dto = personService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
