package com.drl.repository.impl;

import com.drl.pojo.Khoa;
import com.drl.repository.KhoaRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class KhoaRepositoryImpl implements KhoaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Khoa> getKhoas() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNamedQuery("Khoa.findAll", Khoa.class);
        return query.getResultList();
    }
}
