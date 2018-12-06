package io.articulus.hit.icdsearch.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Icd10 {

    @Column
    private String categoryCode;

    @Column
    private String diagnosisCode;

    @Id
    @Column
    private String fullCode;

    @Column
    private String abbreviatedDescription;

    @Column
    private String fullDescription;

    @Column
    private String categoryTitle;

}