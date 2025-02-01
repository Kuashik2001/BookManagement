package com.bs.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.bookstore.entity.MyBookList;

@Repository
public interface MyBookResository extends JpaRepository<MyBookList, Integer> {

}
