package com.simplilearn.cabproapi.repository;

import com.simplilearn.cabproapi.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab, Integer> {
}
