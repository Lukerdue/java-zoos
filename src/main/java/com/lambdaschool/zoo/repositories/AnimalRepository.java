package com.lambdaschool.zoo.repositories;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.GetZooCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(value="SELECT a.animaltype, a.animalid, count(za.zooid) AS counts "+
            "FROM animals a LEFT JOIN zooanimals za ON za.animalid = a.animalid "
            +"GROUP BY a.animalid", nativeQuery = true)
    List<GetZooCount> getZooCount();
}
