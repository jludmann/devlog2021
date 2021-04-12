package com.jeremy.CoursJAVA.security;

import com.jeremy.CoursJAVA.dao.UtilisateurDao;
import com.jeremy.CoursJAVA.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UtilisateurDao utilisateurDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Utilisateur utilisateur = utilisateurDao.findByLogin(s);


        return new UserDetailsCustom(utilisateur);
    }
}
