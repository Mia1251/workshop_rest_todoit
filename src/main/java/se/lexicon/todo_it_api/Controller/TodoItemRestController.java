package se.lexicon.todo_it_api.Controller;

import org.springframework.web.bind.annotation.RestController;
import se.lexicon.todo_it_api.service.TodoItemServiceImpl;

@RestController
public class TodoItemRestController {

    private TodoItemServiceImpl todoItemService;

    public TodoItemRestController(TodoItemServiceImpl todoItemService){
        this.todoItemService = todoItemService;
    }

}
