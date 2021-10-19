package se.lexicon.todo_it_api.Controller;


import org.springframework.http.ResponseEntity;
import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.form.TodoItemFormDto;

import java.util.Collection;

public interface TodoItemController {

    ResponseEntity<TodoItemFormDto> create(TodoItemFormDto todoItemDto);
    ResponseEntity<String> delete(Integer todoItemId);
    ResponseEntity<Collection<TodoItemDto>> find(String title, String[] todoLeft);  // Not completed fully!
    ResponseEntity<TodoItemDto> findById(Integer todoItemId);
    ResponseEntity<TodoItemDto> update(Integer todoItemId, TodoItemFormDto todoItemFormDto);


}
