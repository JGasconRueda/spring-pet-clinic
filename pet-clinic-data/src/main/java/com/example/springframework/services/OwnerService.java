package com.example.springframework.services;

import com.example.springframework.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);

}
