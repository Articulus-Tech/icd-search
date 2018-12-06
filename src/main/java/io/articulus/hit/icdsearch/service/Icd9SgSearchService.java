package io.articulus.hit.icdsearch.service;

import io.articulus.hit.icdsearch.jpa.Icd9SgRepository;
import io.articulus.hit.icdsearch.model.Icd9Sg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/icd9sg")
@Api(tags = {"icd9sg"})
public class Icd9SgSearchService {
    private Icd9SgRepository repository;

    @Autowired
    public Icd9SgSearchService(Icd9SgRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{icdCode}")
    @ApiOperation(value = "Search for ICD9-CM procedure code {icdCode}",
            notes = "code format can be either with or without . notation. IE 011.00 or 01100")
    public Icd9Sg getByCode(@PathVariable("icdCode") String icdCode) {
        return repository.findByCode(icdCode);
    }

    @GetMapping("/find/{phrase}")
    @ApiOperation(value="Search for word/phrase in the ICD9 CM procedure full description field")
    public List<Icd9Sg> findByPhrase(@PathVariable("phrase") String phrase) {
        return repository.findByLongNameContaining(phrase);
    }
}
