/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.NguoiDung;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungRepository {
    boolean addUser(NguoiDung nguoiDung);
    List<NguoiDung> getUsers(String username);
}
