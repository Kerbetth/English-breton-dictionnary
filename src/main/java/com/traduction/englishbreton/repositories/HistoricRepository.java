package com.traduction.englishbreton.repositories;


import com.traduction.englishbreton.domain.Historic;
import com.traduction.englishbreton.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricRepository extends CrudRepository<Historic, Long> {
    List<Historic> findByWord(Word word);
}
