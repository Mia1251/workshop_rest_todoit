package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.form.PersonFormDto;

import java.util.List;

public class PersonServiceImpl implements PersonService{

    @Override
    public PersonDto addTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public PersonDto create(PersonFormDto personFormDto) {


        return null;
    }

    @Override
    public boolean delete(Integer personId) {
        return false;
    }

    @Override
    public List<PersonDto> findAll() {
        return null;
    }

    @Override
    public PersonDto findById(Integer personId) {
        return null;
    }

    @Override
    public List<PersonDto> findIdlePeople() {
        return null;
    }

    @Override
    public PersonDto removeTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public PersonDto update(Integer personId, PersonFormDto personFormDto) {
        return null;
    }
}
