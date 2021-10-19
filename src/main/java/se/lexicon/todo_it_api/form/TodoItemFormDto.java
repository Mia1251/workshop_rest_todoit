package se.lexicon.todo_it_api.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemFormDto {

    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
}
