package io.github.lcsheerdt.api.controller;

import io.github.lcsheerdt.domain.entities.PersonEntity;
import io.github.lcsheerdt.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;


    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonEntity saveNewPerson(@RequestBody PersonEntity entity){
        return personService.saveNewPerson(entity);
    }

    // Read
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PersonEntity findPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public PersonEntity updatePerson(@PathVariable Long id,@RequestBody PersonEntity entity) {
        return personService.updatePerson(id, entity);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }
}
