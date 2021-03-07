package com.traduction.englishbreton.domain;



import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LITERALEXAMPLE")
@EqualsAndHashCode(of = "id")
public class LiteralExample implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String definition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", referencedColumnName="id")
    @NotNull
    private Word word;

}
