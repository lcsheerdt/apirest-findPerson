package io.github.lcsheerdt.service;

import io.github.lcsheerdt.domain.entities.PersonEntity;
import io.github.lcsheerdt.infra.jpa.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    // Create
    public PersonEntity saveNewPerson(PersonEntity entity){
        if (entity == null) {
            throw new RuntimeException("Pessoa nao encontrada!");
        }

        PersonEntity save = personRepository.save(entity);

        return save;
    }

    // Read
    public PersonEntity findPersonById(Long id) {

      return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa nao encontrada"));
    }

    // Update
    public PersonEntity updatePerson(Long id, PersonEntity entity) {
        if (entity == null) {
            throw new RuntimeException("Pessoa nao encontrada!");
        }

        PersonEntity pessoa = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa nao encontrada"));

        pessoa.setName(entity.getName());
        pessoa.setAddress(entity.getAddress());

        PersonEntity save = personRepository.save(pessoa);
        return save;
    }

    // Delete
    public void deletePersonById(Long id){
        try {
            personRepository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Pessoa nao encontrada!");
        }
    }
}
