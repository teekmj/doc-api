package com.infer.docapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.SelectedTextMatrix;

@Repository
public interface TextMatrixRepository extends MongoRepository<SelectedTextMatrix, String>{
}
