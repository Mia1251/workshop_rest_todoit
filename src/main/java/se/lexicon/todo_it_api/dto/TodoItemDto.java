package se.lexicon.todo_it_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemDto {

    private Integer toDoId;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private PersonDtoSmall assignee;

}
