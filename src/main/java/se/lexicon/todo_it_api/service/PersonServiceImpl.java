package se.lexicon.todo_it_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.todo_it_api.conversions.ConversionService;
import se.lexicon.todo_it_api.data.PersonDAO;
import se.lexicon.todo_it_api.data.TodoItemDAO;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.form.PersonFormDto;
import se.lexicon.todo_it_api.model.entity.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonDAO personDao;
    private final TodoItemDAO todoItemDao;
    private final ConversionService convert;

    @Autowired
    public PersonServiceImpl(PersonDAO personDao, TodoItemDAO todoItemDao, ConversionService convert) {
        this.personDao = personDao;
        this.todoItemDao = todoItemDao;
        this.convert = convert;
    }

    @Override
    public PersonDto addTodoItem(Integer personId, Integer todoItemId) {
        return null;
    }

    @Override
    public PersonDto create(PersonFormDto personFormDto) {

        Person saved = personDao.save(convert.toPerson(personFormDto));

        return convert.toPersonDto(saved);
    }

    @Override
    public boolean delete(Integer personId) {

        personDao.deleteById(personId);

        return personDao.findById(personId).isPresent();
    }

    @Override
    public List<PersonDto> findAll() {

        return null;
    }

    @Override
    public PersonDto findById(Integer personId) {
        Optional<Person> foundById = personDao.findById(personId);
        Person person = foundById.orElse(());
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
    public PersonDto update(Integer personId, PersonFormDto updateForm) {

        Optional<Person> foundPerson = personDao.findById(personId);

        if (foundPerson.isPresent()) {
            foundPerson.get().setFirstName(updateForm.getFirstName());
            foundPerson.get().setLastName(updateForm.getLastName());
            foundPerson.get().setBirthDate(updateForm.getBirthDate());
        }
        if (foundPerson.isPresent()){
            return convert.toPersonDto(foundPerson.get());
        }else {
            throw new IllegalArgumentException("Could not find Person By Id");
        }
    }
}
