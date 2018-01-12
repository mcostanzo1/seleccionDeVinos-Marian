package com.dp3.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dp3.domain.Usuario;

@Repository
public interface UserRepository extends MongoRepository<Usuario, String> {
    public Usuario findByUsername(String username);
}
