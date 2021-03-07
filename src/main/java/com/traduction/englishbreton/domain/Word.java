package com.traduction.englishbreton.domain;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "WORDS")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class Word implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String word;

    @Column(nullable = false, length = 50)
    private int language;

    @Column(nullable = false, length = 5)
    private int year;

    @Column(nullable = false, length = 50)
    private String phonetics;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private List<Definition> definitions;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private List<LiteralExample> literalExamples;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Historic> historics;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Word> wordsDerivation;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Word> wordOtherLanguage;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", referencedColumnName="id")
    private Word wordParent;

}
