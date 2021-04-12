package com.jeremy.CoursJAVA.dao;

import com.jeremy.CoursJAVA.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByLogin(String login);

}
