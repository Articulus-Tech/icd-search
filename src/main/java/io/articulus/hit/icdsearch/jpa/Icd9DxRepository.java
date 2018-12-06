package io.articulus.hit.icdsearch.jpa;

import io.articulus.hit.icdsearch.model.Icd9Dx;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Icd9DxRepository extends CrudRepository<Icd9Dx, String> {
    public Icd9Dx findByCode(String code);

    public List<Icd9Dx> findByLongNameContaining(String phrase);
}
