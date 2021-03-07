package com.traduction.englishbreton.dto;



import com.traduction.englishbreton.domain.LiteralExample;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class WordCreation {

    int language;
    int partOfSpeech;
    String word;

    /** commons nouns variable**/
    String plural;
    char gender;

    /** verbs variable**/
    String passive;
    String infinitive;

    /** adjectives variable**/
    String quality;

    int year;
    List<String> definition;
    Set<LiteralExample> literalExamples;
    Set<Long> otherLanguageWordIds;
    String phonetics;

}
