package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Todo;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;


public interface RegisterDao extends CouchbaseRepository<Account, String> {

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}")
    List<Account> findAll();

    @Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and username = $1")
    Long existsByUsername(String username);

    @Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and mail = $1")
    Long existsByMail(String mail);

    @Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and userId = $1")
    Long existsByAccountId(String userId);
}
