package com.traduction.englishbreton.domain;



import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "COMMONNOUN")
@EqualsAndHashCode(of = "id")
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String definition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", referencedColumnName="id")
    @NotNull
    private Word word;

}
