package com.ExpenseTrackerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTrackerApplication.entity.Expenses;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Long> {

}