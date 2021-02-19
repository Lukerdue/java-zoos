package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repositories.TelephoneRepository;
import com.lambdaschool.zoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooControllers {
    @Autowired
    private ZooRepository zoorepo;

    @GetMapping(value="/zoos", produces={"application/json"})
    public ResponseEntity<?> getAllZoos()
    {
        List<Zoo> zoos = new ArrayList<>();
        zoorepo.findAll().iterator().forEachRemaining(zoos::add);

        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    @GetMapping(value="/zoo/{zooid}", produces={"application/json"})
    public ResponseEntity<?> findById(@PathVariable long zooid)
    {
        Zoo zoo = zoorepo.findById(zooid)
                .orElseThrow(()-> new EntityNotFoundException("Zoo with id "+zooid+" not found"));
        System.out.println(zoo);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }
}
