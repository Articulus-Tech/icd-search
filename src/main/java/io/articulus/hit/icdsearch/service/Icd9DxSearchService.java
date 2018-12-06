package io.articulus.hit.icdsearch.service;

import io.articulus.hit.icdsearch.jpa.Icd9DxRepository;
import io.articulus.hit.icdsearch.model.Icd9Dx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/icd9")
@Api(tags = {"icd9"})
public class Icd9DxSearchService {

    private Icd9DxRepository repository;

    @Autowired
    public Icd9DxSearchService(Icd9DxRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{icdCode}")
    @ApiOperation(value = "Search for ICD9-CM diagnosis code {icdCode}",
            notes = "code format can be either with or without . notation. IE 011.00 or 01100")
    public Icd9Dx getByCode(@PathVariable("icdCode") String icdCode) {
        return repository.findByCode(icdCode);
    }

    @GetMapping("/find/{phrase}")
    @ApiOperation(value="Search for word/phrase in the ICD9 CM full description field")
    public List<Icd9Dx> findByPhrase(@PathVariable("phrase") String phrase) {
        return repository.findByLongNameContaining(phrase);
    }
}
