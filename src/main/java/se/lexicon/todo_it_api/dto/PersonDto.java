package se.lexicon.todo_it_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonDto {

    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<TodoItemDtoSmall> todoItems;

}
