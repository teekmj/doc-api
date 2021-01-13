package com.infer.docapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.SelectedTextMatrics;

@Repository
public interface TextMatrixRepository extends MongoRepository<SelectedTextMatrics, String>{
}
