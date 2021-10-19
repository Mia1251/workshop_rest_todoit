package se.lexicon.todo_it_api.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.conversions.ConversionService;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.form.PersonFormDto;
import se.lexicon.todo_it_api.model.entity.Person;
import se.lexicon.todo_it_api.service.PersonServiceImpl;

import java.util.Collection;

@RestController
public class PersonRestController implements PersonController {

    private final PersonServiceImpl personService;
    private final ConversionService convert;

    @Autowired
    public PersonRestController(PersonServiceImpl personService, ConversionService convert) {
        this.personService = personService;
        this.convert = convert;
    }

    @Override
    public ResponseEntity<PersonDto> assignTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    @PostMapping("/todo/api/v1/")
    public ResponseEntity<PersonDto> create(@RequestBody PersonFormDto personFormDto) {

        PersonDto personDto = personService.create(personFormDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
    }

    @Override
    @DeleteMapping("/todo/api/v1/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer personId){

        personService.delete(personId);

            return ResponseEntity.ok().build();


    }

    @Override
    public ResponseEntity<?> find(String type) {



        return null;
    }

    @Override
    public ResponseEntity<Collection<PersonDto>> findAll() {

        Collection<PersonDto> personDtos = personService.findAll();

        return ResponseEntity.ok(personDtos);
    }

    @Override
    public ResponseEntity<PersonDto> findById(Integer personId) {

        PersonDto personDto = personService.findById(personId);

        return ResponseEntity.ok(personDto);
    }

    @Override
    public ResponseEntity<Collection<PersonDto>> findIdlePeople() {
        return null;
    }

    @Override
    public ResponseEntity<Collection<TodoItemDto>> getTodoItems(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<PersonDto> removeTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<PersonDto> update(Integer personId, PersonFormDto personFormDto) {
        return null;
    }
}
