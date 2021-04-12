package com.jeremy.CoursJAVA.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeremy.CoursJAVA.dao.CompetenceDao;
import com.jeremy.CoursJAVA.model.Competence;
import com.jeremy.CoursJAVA.view.CustomJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CompetenceController {

    CompetenceDao competenceDao;

    @Autowired
    CompetenceController(CompetenceDao competenceDao) {
        this.competenceDao = competenceDao;
    }

    @GetMapping("/admin/competence/{id}")
    @JsonView(CustomJsonView.VueCompetence.class)
    public Competence getCompetence(@PathVariable int id) {


        return competenceDao.findById(id).orElse(null);

    }

    @JsonView(CustomJsonView.VueCompetence.class)
    @GetMapping("/admin/competences")
    public List<Competence> getCompetence() {

        return competenceDao.findAll();
    }

    @PostMapping("/admin/competence")
    public boolean addCompetence(@RequestBody Competence user) {

            competenceDao.save(user);

        return true;

    }

    @DeleteMapping("/admin/competence/{id}")
    public boolean deleteCompetence(@PathVariable int id) {

        competenceDao.deleteById(id);

        return true;

    }

}
