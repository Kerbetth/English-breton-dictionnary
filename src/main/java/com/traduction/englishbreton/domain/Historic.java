package com.traduction.englishbreton.domain;



import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "HISTRORIC")
@EqualsAndHashCode(of = "id")
public class Historic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", referencedColumnName="id")
    @NotNull
    Word word;

    String operationType;
    String description;
}
