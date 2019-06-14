package com.infer.docapi.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.PolicyDoc;

@Repository
public interface PolicyDocRepository extends MongoRepository<PolicyDoc, String>{
	@Query(value= "{}", fields = "{ 'id' : 1, 'name' : 1, 'type' : 1, 'compliance' : 1}")
	public List<PolicyDoc> getAllDocNames();
}
