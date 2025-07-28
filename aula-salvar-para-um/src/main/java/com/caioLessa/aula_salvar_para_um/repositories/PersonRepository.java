package com.caioLessa.aula_salvar_para_um.repositories;

import com.caioLessa.aula_salvar_para_um.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
