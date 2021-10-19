package se.lexicon.todo_it_api.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.conversions.ConversionService;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.form.PersonFormDto;
import se.lexicon.todo_it_api.model.entity.Person;
import se.lexicon.todo_it_api.service.PersonServiceImpl;

import java.util.Collection;

@RestController
public class PersonRestController implements PersonController {

    private PersonServiceImpl personService;
    private ConversionService convert;

    @Autowired
    public PersonRestController(PersonServiceImpl personService,
                                ConversionService convert){
        this.personService = personService;
        this.convert = convert;

    }

    @Override
    public ResponseEntity<PersonDto> assignTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    @PostMapping("/todo/api/v1/")
    public ResponseEntity<PersonFormDto> create(@RequestBody PersonFormDto personFormDto) {

        PersonDto personDto = personService.create(personFormDto);
        Person person = convert.


        return
    }

    @Override
    public ResponseEntity<String> deletePerson(Integer personId) {
        return null;
    }

    @Override
    public ResponseEntity<?> find(String type) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<PersonDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PersonDto> findById(Integer personId) {
        return null;
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
}
