package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.repositories.AnimalRepository;
import com.lambdaschool.zoo.services.AnimalService;
import com.lambdaschool.zoo.views.GetZooCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalControler {
    @Autowired
    AnimalService animalservice;

    @GetMapping(value="/animals/count")
    public ResponseEntity<?> getAnimalCount()
    {
        List<GetZooCount> count = animalservice.getZooCounts();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
