package com.caioLessa.aula_salvar_para_um.services;

import com.caioLessa.aula_salvar_para_um.dto.PersonDepartmentDTO;
import com.caioLessa.aula_salvar_para_um.entities.Department;
import com.caioLessa.aula_salvar_para_um.entities.Person;
import com.caioLessa.aula_salvar_para_um.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        Department dept = new Department();
        System.out.println(dto.getDepartment().getId());
        dept.setId(dto.getDepartment().getId());
        entity.setDepartment(dept);
        entity = personRepository.save(entity);
        return new PersonDepartmentDTO(entity);
    }
}
