package io.articulus.hit.icdsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
class Icd9 {
    @Column
    @Id
    @JsonProperty
    private String code;

    @Column
    private String longName;

    @Column
    private String shortName;
}
