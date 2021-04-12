package com.jeremy.CoursJAVA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.jeremy.CoursJAVA.view.CustomJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Statut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomJsonView.VueUtilisateur.class})
    private int id;

    @JsonView({CustomJsonView.VueUtilisateur.class})
    private String denomination;

    @JsonIgnore
    @OneToMany(mappedBy = "statut")
    private List<Utilisateur> listeUtilisateurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }
}
