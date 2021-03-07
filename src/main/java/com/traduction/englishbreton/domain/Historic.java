package com.traduction.englishbreton.domain;



import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BANKACCOUNT")
@EqualsAndHashCode(of = "id")
public class Historic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commonNoun_id", referencedColumnName="id")
    @NotNull
    Word word;

    String operationType;
    String description;
}
