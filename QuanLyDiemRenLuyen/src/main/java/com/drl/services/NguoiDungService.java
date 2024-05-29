/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.NguoiDung;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungService extends UserDetailsService{
    boolean addUser(NguoiDung nguoiDung);
    List<NguoiDung>getUsers(String username);
}
