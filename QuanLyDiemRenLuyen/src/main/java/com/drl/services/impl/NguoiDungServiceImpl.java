/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.NguoiDung;
import com.drl.repositories.NguoiDungRepository;
import com.drl.services.NguoiDungService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author ADMIN
 */
@Service("userDetailsService")
public class NguoiDungServiceImpl implements NguoiDungService{
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Override
    public boolean addUser(NguoiDung nguoiDung) {
        return this.nguoiDungRepository.addUser(nguoiDung);
    }

    @Override
    public List<NguoiDung> getUsers(String username) {
        return this.nguoiDungRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           List<NguoiDung> nguoiDungs = this.getUsers(username);
        if(nguoiDungs.isEmpty())
            throw new UsernameNotFoundException("User khong ton tai");
        NguoiDung nguoiDung = nguoiDungs.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(nguoiDung.getRole()));
        return new org.springframework.security.core.userdetails.User(nguoiDung.getUsername(), nguoiDung.getPassword(), auth);
    }
}
