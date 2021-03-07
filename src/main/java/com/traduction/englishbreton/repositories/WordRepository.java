package com.traduction.englishbreton.repositories;

import com.traduction.englishbreton.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findByWordDerivation(Word word);
    Optional<Word> findByWord(String word);
    Optional<Word> findById(Long id);
}
