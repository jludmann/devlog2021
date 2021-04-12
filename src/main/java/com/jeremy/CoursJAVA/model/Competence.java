package com.jeremy.CoursJAVA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.jeremy.CoursJAVA.view.CustomJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueCompetence.class})
    private int id;
    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueCompetence.class})
    private String nom;

    @JsonView({CustomJsonView.VueCompetence.class})
    @ManyToMany(mappedBy = "listeCompetences")
    private List<Utilisateur> listeUtilisateurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }
}

