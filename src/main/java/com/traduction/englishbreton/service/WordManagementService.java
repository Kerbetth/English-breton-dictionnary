package com.traduction.englishbreton.service;

import com.traduction.englishbreton.domain.Word;
import com.traduction.englishbreton.domain.pos.Adjective;
import com.traduction.englishbreton.domain.pos.CommonNoun;
import com.traduction.englishbreton.domain.pos.Verb;
import com.traduction.englishbreton.dto.WordCreation;
import com.traduction.englishbreton.repositories.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class WordManagementService {

    @Autowired
    protected WordRepository wordRepository;


    /**
     * -addABankAccount(BankAccount) link a bankAccount IBAN to the userAccount in order to withdrawing and depositing money
     */
    public boolean addAWord(WordCreation wordCreation) {
        if (wordRepository.findByWord(wordCreation.getWord()).isEmpty()) {
            Word word = new Word();
            switch (wordCreation.getPartOfSpeech()){
                case 1:
                    word = new CommonNoun(wordCreation.getPlural(), wordCreation.getGender());
                    break;
                case 2:
                    word = new Verb(wordCreation.getInfinitive(), wordCreation.getPassive());
                    break;
                case 3:
                    word = new Adjective(wordCreation.getQuality());
                    break;
            }
            word.setLanguage(wordCreation.getLanguage());
            word.setPhonetics(wordCreation.getPhonetics());
            word.setLanguage(wordCreation.getLanguage());
            word.setWord(wordCreation.getWord());
            Set<Word> words = new HashSet<>();
            for (Long id : wordCreation.getOtherLanguageWordIds()){
                words.add(wordRepository.findById(id).get());
            }
            word.setWordOtherLanguage(words);
            //word.setLiteralExamples(wordCreation.getLiteralExamples());
            //word.setDefinitions(wordCreation.getDefinition());
            wordRepository.save(word);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This word has already been added");
        }
    }

}