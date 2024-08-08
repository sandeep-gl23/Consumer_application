package com.example.developer2.Repository;

import com.example.developer2.Entity.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyRepository extends MongoRepository<Field,String> {

    @Query
    Optional<Field> findByCodeAndVersion(String code, Double version);

    @Query("{ 'code': ?0 }")
    Optional<Field> findFieldByCode(String code);
}
