package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding,Integer>{
    List<Feeding> findAll();
    
    @Query("Select f FROM  FeedingType f")
    List<FeedingType> findAllFeedingTypes();
    
    Optional<Feeding> findById(int id);
    
    Feeding save(Feeding p);

    @Query("Select ft FROM FeedingType ft WHERE ft.name like %?1")
    FeedingType findFeedingTypeByName(String name);
}
