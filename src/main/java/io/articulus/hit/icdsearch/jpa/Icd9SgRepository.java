package io.articulus.hit.icdsearch.jpa;

import io.articulus.hit.icdsearch.model.Icd9Sg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Icd9SgRepository extends CrudRepository<Icd9Sg, String> {
    public Icd9Sg findByCode(String code);

    public List<Icd9Sg> findByLongNameContaining(String phrase);
}
