package org.springframework.samples.petclinic.feeding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="feeding_type")
public class FeedingType extends BaseEntity {
    
    @NotEmpty
    @Column(unique=true)
    @Length(min=3, max=30)
    String name;
    
    @NotEmpty
    String description;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="pet_type_id")
    PetType petType;
}
