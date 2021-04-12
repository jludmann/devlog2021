package com.jeremy.CoursJAVA.dao;

import com.jeremy.CoursJAVA.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer> {
}
