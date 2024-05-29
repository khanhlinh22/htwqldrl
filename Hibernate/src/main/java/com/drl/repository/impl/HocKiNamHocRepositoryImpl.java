package com.drl.repository.impl;

import com.drl.pojo.HocKiNamHoc;
import com.drl.repository.HocKiNamHocRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class HocKiNamHocRepositoryImpl implements HocKiNamHocRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<HocKiNamHoc> getHocKiNamHocs() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNamedQuery("HocKiNamHoc.findAll", HocKiNamHoc.class);
        return query.getResultList();
    }
}
