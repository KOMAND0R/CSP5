package com.lab5.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends CrudRepository<Student, Integer> {

}
