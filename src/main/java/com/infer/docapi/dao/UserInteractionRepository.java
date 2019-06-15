package com.infer.docapi.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.infer.docapi.domain.UserInteractionMatrics;

@Repository
public interface UserInteractionRepository extends MongoRepository<UserInteractionMatrics, String>{
	@Query(value= "{'docId': ?0, 'paragraphSeqNo': ?1}")
	public UserInteractionMatrics getUserInteractionMatric(String docId, int seqNo);
	
	@Query(value = "{'docId': ?0}")
	public List<UserInteractionMatrics> getByDocID(String docId);
}
