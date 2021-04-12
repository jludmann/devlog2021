package com.jeremy.CoursJAVA.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeremy.CoursJAVA.dao.UtilisateurDao;
import com.jeremy.CoursJAVA.model.Utilisateur;
import com.jeremy.CoursJAVA.security.JwtUtil;
import com.jeremy.CoursJAVA.security.UserDetailsServiceCustom;
import com.jeremy.CoursJAVA.view.CustomJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;
    JwtUtil jwtUtil;
    AuthenticationManager authenticationManager;
    UserDetailsServiceCustom userDetailsServiceCustom;

    @Autowired
    UtilisateurController(UtilisateurDao utilisateurDao,
                          JwtUtil jwtUtil,
                          AuthenticationManager authenticationManager,
                          UserDetailsServiceCustom userDetailsServiceCustom) {
        this.utilisateurDao = utilisateurDao;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceCustom = userDetailsServiceCustom;
    }

    @PostMapping("/authentification")
    public String authentification(@RequestBody Utilisateur utilisateur) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        utilisateur.getLogin(), utilisateur.getPassword()
                )
        );

        UserDetails userDetails = this.userDetailsServiceCustom.loadUserByUsername(utilisateur.getLogin());

        return jwtUtil.generateToken(userDetails);

    }

    @JsonView(CustomJsonView.VueUtilisateur.class)
    @GetMapping("/user/utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable int id) {


        return utilisateurDao.findById(id).orElse(null);

    }

    @JsonView(CustomJsonView.VueUtilisateur.class)
    @GetMapping("/user/utilisateurs")
    public List<Utilisateur> getUtilisateur() {

        return utilisateurDao.findAll();
    }

    @PostMapping("/admin/utilisateur")
    public boolean addUtilisateur(@RequestBody Utilisateur user) {

            utilisateurDao.save(user);

        return true;

    }

    @DeleteMapping("/admin/utilisateur/{id}")
    public boolean deleteUtilisateur(@PathVariable int id) {

        utilisateurDao.deleteById(id);

        return true;

    }

}
