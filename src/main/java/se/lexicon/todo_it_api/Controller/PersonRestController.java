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
import se.lexicon.todo_it_api.service.TodoItemServiceImpl;

import java.util.Collection;

@RestController
public class PersonRestController implements PersonController {

    private final PersonServiceImpl personService;
    private final TodoItemServiceImpl todoItemService;
    private final ConversionService convert;

    @Autowired
    public PersonRestController(PersonServiceImpl personService,
                                ConversionService convert, TodoItemServiceImpl todoItemService) {
        this.personService = personService;
        this.todoItemService = todoItemService;
        this.convert = convert;

    }
        @Override
    @GetMapping("/todo/api/v1/persons/{personid}/{todoitemid}")
    public ResponseEntity<PersonDto> assignTodoItem(@PathVariable("personid") Integer personId,@PathVariable("todoitemid") Integer todoItemId) {

        PersonDto personDto = personService.addTodoItem(personId, todoItemId);

            return ResponseEntity.ok(personDto);

        }

    @Override
    @PostMapping("/todo/api/v1/")
    public ResponseEntity<PersonDto> create(@RequestBody PersonFormDto personFormDto) {

        PersonDto personDto = personService.create(personFormDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
    }

    @Override
    @DeleteMapping("/todo/api/v1/persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer personId) {

        personService.delete(personId);

        return ResponseEntity.ok().build();


    }

    @Override
    public ResponseEntity<?> find(String type) {


        return null;
    }

    @Override
    @GetMapping("/todo/api/v1/persons")
    public ResponseEntity<Collection<PersonDto>> findAll() {

        Collection<PersonDto> personDtos = personService.findAll();

        return ResponseEntity.ok(personDtos);
    }

    @Override
    @GetMapping("/todo/api/v1/persons/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable("id") Integer personId) {

        PersonDto personDto = personService.findById(personId);

        return ResponseEntity.ok(personDto);
    }

    @Override
    @GetMapping("/todo/api/v1/persons/findIdlePeople")
    public ResponseEntity<Collection<PersonDto>> findIdlePeople() {

        Collection<PersonDto> personDtos = personService.findIdlePeople();

        return ResponseEntity.ok(personDtos);
    }

    @Override
    public ResponseEntity<Collection<TodoItemDto>> getTodoItems(Integer todoItemId) {

        // Collection<TodoItemDto> TodoItemDtos = todoItemService.();

        return null;
    }

    @Override
    @DeleteMapping("/todo/api/v1/persons/{id}")
    public ResponseEntity<PersonDto> removeTodoItem(Integer personId, Integer todoItemId) {

        personService.removeTodoItem(personId, todoItemId);

        return ResponseEntity.ok().build();
    }



    @Override
    @PutMapping("/todo/api/v1/persons/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable("id") Integer personId,@RequestBody PersonFormDto personFormDto) {


        return ResponseEntity.ok().body(personService.update(personId, personFormDto));
    }
}
