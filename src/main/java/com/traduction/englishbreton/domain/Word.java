package com.traduction.englishbreton.domain;



import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "WORD")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String word;
    int language;
    int year;
    String phonetics;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    List<Definition> definitions;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    List<LiteralExample> literalExamples;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Historic> historics;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Word> wordsDerivation;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Word> wordOtherLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commonNoun_id", referencedColumnName="id")
    @NotNull
    private Word wordParent;

}
