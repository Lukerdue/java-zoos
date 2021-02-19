package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repositories.AnimalRepository;
import com.lambdaschool.zoo.views.GetZooCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value="animalservices")
public class AnimalServiceImpl implements AnimalService{
@Autowired
    private AnimalRepository animalrepo;

    @Override
    public List<GetZooCount> getZooCounts() {
        return animalrepo.getZooCount();
    }
}

