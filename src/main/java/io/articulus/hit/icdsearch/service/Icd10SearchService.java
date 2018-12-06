package io.articulus.hit.icdsearch.service;

import io.articulus.hit.icdsearch.jpa.Icd10Repository;
import io.articulus.hit.icdsearch.model.Icd10;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/icd10")
@Api(tags = {"icd10"})
public class Icd10SearchService {

    private Icd10Repository repository;

    @Autowired
    public Icd10SearchService(Icd10Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/{icdCode}")
    @ApiOperation(value = "Search for ICD10 code {icdCode}",
            notes = "code format can be either with or without . notation. IE 011.00 or 01100")
    public Icd10 getByCode(@PathVariable("icdCode") String icdCode) {
        return repository.findByFullCode(icdCode);
    }

    @GetMapping("/find/{phrase}")
    @ApiOperation(value="Search for word/phrase in the ICD10 full description field")
    public List<Icd10> findByPhrase(@PathVariable("phrase") String phrase) {
        return repository.findByFullDescriptionContaining(phrase);
    }
}