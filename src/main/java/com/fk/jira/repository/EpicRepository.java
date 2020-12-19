package com.fk.jira.repository;


import com.fk.jira.dao.Epic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepository extends MongoRepository<Epic, String> {
}
