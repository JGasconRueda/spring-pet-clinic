package com.example.springframework.repositories;

import com.example.springframework.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName (String lastName);

    List<Owner> findByLastNameLike(String lastName);
}
