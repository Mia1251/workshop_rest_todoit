package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.form.PersonFormDto;

import java.util.List;

public interface PersonService {

    PersonDto addTodoItem(Integer personId, Integer todoItemId);

    PersonDto create(PersonFormDto personFormDto);

    boolean delete(Integer personId);

    List<PersonDto> findAll();

    PersonDto findById(Integer personId);

    List<PersonDto> findIdlePeople();

    PersonDto removeTodoItem(Integer personId, Integer todoItemId);

    PersonDto update(Integer personId, PersonFormDto personFormDto);

}