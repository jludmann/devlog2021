package com.jeremy.CoursJAVA.dao;

import com.jeremy.CoursJAVA.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDao extends JpaRepository<Statut, Integer> {
}
