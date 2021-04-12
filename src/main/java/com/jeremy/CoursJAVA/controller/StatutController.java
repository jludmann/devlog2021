package com.jeremy.CoursJAVA.controller;

import com.jeremy.CoursJAVA.dao.StatutDao;
import com.jeremy.CoursJAVA.model.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class StatutController {

    StatutDao statutDao;

    @Autowired
    StatutController(StatutDao statutDao) {
        this.statutDao = statutDao;
    }

    @GetMapping("/admin/statut/{id}")
    public Statut getStatut(@PathVariable int id) {


        return statutDao.findById(id).orElse(null);

    }


    @GetMapping("/admin/statuts")
    public List<Statut> getStatut() {

        return statutDao.findAll();
    }

    @PostMapping("/admin/statut")
    public boolean addStatut(@RequestBody Statut user) {

            statutDao.save(user);

        return true;

    }

    @DeleteMapping("/admin/statut/{id}")
    public boolean deleteStatut(@PathVariable int id) {

        statutDao.deleteById(id);

        return true;

    }

}
