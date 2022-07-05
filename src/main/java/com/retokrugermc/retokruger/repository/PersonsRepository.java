package com.retokrugermc.retokruger.repository;

import com.retokrugermc.retokruger.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {


}
