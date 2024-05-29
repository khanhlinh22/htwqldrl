package com.drl.repository.impl;

import com.drl.pojo.HoatDong;
import com.drl.repository.HoatDongRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HoatDongRepositoryImpl implements HoatDongRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<HoatDong> getHoatDongs(Map<String, String> params) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<HoatDong> criteriaQuery = criteriaBuilder.createQuery(HoatDong.class);
        Root<HoatDong> root = criteriaQuery.from(HoatDong.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("ten"), "%" + kw + "%"));
        }
        String dieuId = params.get("dieuId");
        if (dieuId != null && !dieuId.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("dieuId"), Integer.valueOf(dieuId)));
        }

        criteriaQuery.where(predicates.toArray(Predicate[]::new));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));

        Query query = session.createQuery(criteriaQuery);

        String p = params.get("page");
        if (p != null && !p.isEmpty()) {
            int pageSize = Integer.parseInt(env.getProperty("hoatDong.pageSize"));
            int start = (Integer.parseInt(p) - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);
        }

        return query.getResultList();
    }

    @Override
    public void addOrUpdate(HoatDong h) {
        Session session = sessionFactory.getCurrentSession();
        if (h.getId() > 0) {
            session.update(h);
        } else {
            session.save(h);
        }
    }

    public HoatDong getHoatDongByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(HoatDong.class, id);
    }

    @Override
    public void deleteHoatDong(int id) {
        Session session = sessionFactory.getCurrentSession();
        HoatDong h = this.getHoatDongByID(id);
        session.delete(h);
    }

    @Override
    public HoatDong getHoatDongByIDd(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
