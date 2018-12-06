package io.articulus.hit.icdsearch.jpa;

import io.articulus.hit.icdsearch.model.Icd10;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Icd10Repository extends CrudRepository<Icd10, String> {
    public Icd10 findByFullCode(String code);

    public List<Icd10> findByFullDescriptionContaining(String phrase);
}
