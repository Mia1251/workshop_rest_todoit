package se.lexicon.todo_it_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.conversions.ConversionService;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.form.TodoItemFormDto;
import se.lexicon.todo_it_api.service.TodoItemServiceImpl;

import java.util.Collection;

@RestController
public class TodoItemRestController implements TodoItemController{

    private final TodoItemServiceImpl todoItemService;
    private final ConversionService convert;

    @Autowired
    public TodoItemRestController(TodoItemServiceImpl todoItemService, ConversionService convert) {
        this.todoItemService = todoItemService;
        this.convert = convert;
    }

    @Override
    public ResponseEntity<TodoItemFormDto> create(TodoItemFormDto todoItemDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<TodoItemDto>> find(String title, String[] todoLeft) {
        return null;
    }

    @Override
    public ResponseEntity<TodoItemDto> findById(Integer todoItemId) {
        return null;
    }

    @Override
    public ResponseEntity<TodoItemDto> update(Integer todoItemId, TodoItemFormDto todoItemFormDto) {
        return null;
    }
}
