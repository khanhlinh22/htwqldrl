/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.HoatDong;
import com.drl.pojo.NguoiDung;
import java.util.List;
import javax.persistence.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.drl.repositories.NguoiDungRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class NguoiDungRepositorympl implements NguoiDungRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public boolean addUser(NguoiDung nguoiDung) {
        return false;
    }

    @Override
    public List<NguoiDung> getUsers(String username) {
        Session s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện

            CriteriaQuery<NguoiDung> q = b.createQuery(NguoiDung.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(NguoiDung.class);//Muốn lấy trường (column)
            q = q.select(r);
            if(!username.isEmpty()){
                Predicate p = b.equal(r.get("username").as(String.class), username.trim());
                q = q.where(p);
            }
            Query query = s.createQuery(q);
            return query.getResultList();
    }
    
   
    
}
