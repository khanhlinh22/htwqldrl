/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.drl.hibernate;

import com.drl.pojo.BaiViet;
import com.drl.pojo.SinhVien;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author trinh
 */
public class Hibernate {

    public static void main(String[] args) {
        try (Session s = HiberateUtils.getFACTORY().openSession()){
            Query q = s.createNamedQuery("SinhVien.findAll");
            List <SinhVien> sinhviens = q.getResultList();
            sinhviens.forEach(p -> System.out.println(p.getId()));
        }
    }
}
