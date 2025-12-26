package com.example.SUPNUM_TD1_23044.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SUPNUM_TD1_23044.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

}