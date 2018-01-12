package com.dp3.dao;


import com.dp3.domain.Cellar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CellarRepository extends MongoRepository<Cellar, String> {

}