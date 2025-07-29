package com.caioLessa.aula_salvar_para_um.services;

import com.caioLessa.aula_salvar_para_um.dto.PersonDTO;
import com.caioLessa.aula_salvar_para_um.dto.PersonDepartmentDTO;
import com.caioLessa.aula_salvar_para_um.entities.Department;
import com.caioLessa.aula_salvar_para_um.entities.Person;
import com.caioLessa.aula_salvar_para_um.repositories.DepartmentRepository;
import com.caioLessa.aula_salvar_para_um.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private DepartmentRepository departmentRepository;

    public PersonService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
        entity.setDepartment(dept);
        entity = personRepository.save(entity);
        return new PersonDepartmentDTO(entity);
    }

    /*public PersonDTO insert(PersonDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());
        entity.setDepartment(dept);
        entity = personRepository.save(entity);
        return new PersonDTO(entity);
    }*/
}
