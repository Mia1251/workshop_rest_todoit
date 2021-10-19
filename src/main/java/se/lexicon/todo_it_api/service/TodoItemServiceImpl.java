package se.lexicon.todo_it_api.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import se.lexicon.todo_it_api.conversions.ConversionService;
import se.lexicon.todo_it_api.data.PersonDAO;
import se.lexicon.todo_it_api.data.TodoItemDAO;
import se.lexicon.todo_it_api.dto.TodoItemDto;
import se.lexicon.todo_it_api.exception.AppResourceNotFoundException;
import se.lexicon.todo_it_api.form.TodoItemFormDto;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final PersonDAO personDao;
    private final TodoItemDAO todoItemDao;
    private final ConversionService convert;

    @Autowired
    public TodoItemServiceImpl(PersonDAO personDao,TodoItemDAO todoItemDao, ConversionService convert) {
        this.personDao = personDao;
        this.todoItemDao = todoItemDao;
        this.convert = convert;

    }
    @Override
    public TodoItemDto create(TodoItemFormDto todoItemDto) {
        TodoItem saved = todoItemDao.save(convert.toTodoItem(todoItemDto));

        return convert.toTodoDto(saved);
    }

    @Override
    public boolean delete(Integer todoItemId) {

        todoItemDao.deleteById(todoItemId);

        return !personDao.existsById(todoItemId);

    }

    @Override
    public List<TodoItemDto> findAll() {
        List<TodoItemDto> TodoItems = new ArrayList<>();

        for(TodoItem todoItem: todoItemDao.findAll()){
            TodoItems.add(convert.toTodoDto(todoItem));
        }

        return TodoItems;
    }

    @Override
    public List<TodoItemDto> findAllByPersonId(Integer personId) {

        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findAll()){
            if (todoItem.getAssignee().getPersonId()==personId){
                todoItemDtos.add(convert.toTodoDto(todoItem));
            }
        }

    return todoItemDtos;
    }

    @Override
    public List<TodoItemDto> findAllUnassigned() {
        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findUnassignedTodoItems()){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }

        return todoItemDtos;


    }

    @Override
    public List<TodoItemDto> findAllUnfinishedAndOverdue() {
        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findAllUnfinishedAndOverdue()){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }


        return todoItemDtos;
    }

    @Override
    public List<TodoItemDto> findByDeadlineAfter(LocalDate localDate) {
        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findByDeadlineAfter(localDate)){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }


        return todoItemDtos;
    }

    @Override
    public List<TodoItemDto> findByDeadlineBefore(LocalDate localDate) {

        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findByDeadLineBefore(localDate)){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }


        return todoItemDtos;
    }

    @Override
    public List<TodoItemDto> findByDeadlineBetween(LocalDate localDate1, LocalDate localDate2) {
        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findByDeadlineBetween(localDate1,localDate2)){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }


        return todoItemDtos;
    }

    @Override
    public List<TodoItemDto> findByDoneStatus(boolean done) {
        List<TodoItemDto> todoItemDtos = new ArrayList<>();
        for(TodoItem todoItem: todoItemDao.findByDoneStatus(done)){

            todoItemDtos.add(convert.toTodoDto(todoItem));

        }


        return todoItemDtos;

    }

    @Override
    public TodoItemDto findById(Integer todoItemId) {
        Optional<TodoItem> foundById = todoItemDao.findById(todoItemId);
        TodoItem todoItem = foundById.orElseThrow(() -> new AppResourceNotFoundException("Could not find TodoItem By Id " + todoItemId));
        return convert.toTodoItem(todoItem);
    }

    @Override
    public List<TodoItemDto> findByTitle(String title) {
        return null;
    }

    @Override
    public TodoItemDto update(Integer todoItemId, TodoItemFormDto todoItemFormDto) {
        return null;
    }
}
