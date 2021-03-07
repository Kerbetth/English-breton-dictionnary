package com.traduction.englishbreton.domain.pos;



import com.traduction.englishbreton.domain.Word;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
public class CommonNoun extends Word{
    String plural;
    char gender;
}
