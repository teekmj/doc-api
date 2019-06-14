package com.infer.docapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.ISOGuidelinePolicy;

@Repository
public interface ISOGuidelinePolicyRepository extends MongoRepository<ISOGuidelinePolicy, String>{

}
