package com.thc.realspr.repository;

import com.thc.realspr.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbpostRepository extends JpaRepository<Tbpost, String> {
}
