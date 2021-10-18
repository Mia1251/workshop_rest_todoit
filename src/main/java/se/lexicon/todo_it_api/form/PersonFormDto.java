package se.lexicon.todo_it_api.form;

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
@Service
public class PersonFormDto {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
