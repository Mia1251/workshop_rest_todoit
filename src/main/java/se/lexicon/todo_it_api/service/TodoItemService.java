package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.form.TodoItemFormDto;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemService {

    TodoItemDto create(TodoItemFormDto todoItemDto);

    boolean delete(Integer todoItemId);

    List<TodoItemDto> findAll();

    List<TodoItemDto> findAllByPersonId(Integer personId);

    List<TodoItemDto> findAllUnassigned();

    List<TodoItemDto> findAllUnfinishedAndOverdue();

    List<TodoItemDto> findByDeadlineAfter(LocalDate localDate);

    List<TodoItemDto> findByDeadlineBefore(LocalDate localDate);

    List<TodoItemDto> findByDeadlineBetween(LocalDate localDate1, LocalDate localDate2);

    List<TodoItemDto> findByDoneStatus(boolean done);

    TodoItemDto findById(Integer todoItemId);

    List<TodoItemDto> findByTitle(String title);

    TodoItemDto update(Integer todoItemId, TodoItemFormDto todoItemFormDto);

}
