package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{

    private final FeedingService feedingService;
    
    public FeedingTypeFormatter(FeedingService feedingService){
        this.feedingService=feedingService;
    }
    
    @Override
    public String print(FeedingType object, Locale locale) {
        return object.getName();
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {
        FeedingType ft=feedingService.getFeedingType(text);
        if(ft==null){
            throw new ParseException("Feeding type not found: " + text, 0);
        }else{
            return ft;
        }
    }
    
}
