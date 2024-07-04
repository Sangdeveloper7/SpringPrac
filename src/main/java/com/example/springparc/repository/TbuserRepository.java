package com.example.springparc.repository;

import com.example.springparc.domain.Tbuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TbuserRepository extends JpaRepository<Tbuser, String> {
}
