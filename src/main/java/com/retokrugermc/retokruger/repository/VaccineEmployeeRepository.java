package com.retokrugermc.retokruger.repository;

import com.retokrugermc.retokruger.models.VaccineEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineEmployeeRepository extends CrudRepository<VaccineEmployee,Integer> {

}
