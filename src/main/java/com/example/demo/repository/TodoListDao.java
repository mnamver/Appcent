package com.example.demo.repository;

import com.example.demo.entity.Todo;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;
import java.util.Optional;


public interface TodoListDao extends CouchbaseRepository<Todo, String> {

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} and userId = $1")
    List<Todo> findByUserId(String userId);

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} and todoId = $1")
    Optional<Todo> findById(String id);

    @Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and todoId = $1")
    Long existsByTodoId(String id);

}
