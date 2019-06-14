package com.infer.docapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.PolicyDoc;

@Repository
public interface PolicyDocRepository extends MongoRepository<PolicyDoc, String>{

}
