package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {

    @Autowired
    private FeedingRepository feedingRepository;

    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingTypeByName(typeName);
    }

    @Transactional(rollbackFor =  UnfeasibleFeedingException.class)
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        PetType petTypeOfThePet=p.getPet().getType(); 
        PetType feedingPetType=p.getFeedingType().getPetType();
        if(!petTypeOfThePet.equals(feedingPetType)){
            throw new UnfeasibleFeedingException();
        }else{
            return feedingRepository.save(p);
        }
    }

    
}
