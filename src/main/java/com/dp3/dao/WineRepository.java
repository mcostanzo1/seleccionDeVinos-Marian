package com.dp3.dao;


import com.dp3.domain.Wine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WineRepository extends MongoRepository<Wine, String> {

}