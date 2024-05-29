    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.drl.repositories.impl;

    import com.drl.pojo.HoatDong;
    import com.drl.repositories.HoatDongRepository;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import javax.persistence.Query;
    import javax.persistence.criteria.CriteriaBuilder;
    import javax.persistence.criteria.CriteriaQuery;
    import javax.persistence.criteria.Predicate;
    import javax.persistence.criteria.Root;
    import org.hibernate.Session;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.PropertySource;
    import org.springframework.core.env.Environment;
    import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Transactional;

    /**
     *
     * @author DELL
     */
    @Repository
    @Transactional
    @PropertySource("classpath:configs.properties")
    public class HoatDongRepositoryImpl implements HoatDongRepository {

        @Autowired
        private Environment env;

        @Autowired
        private LocalSessionFactoryBean factory;

        @Override
        public List<HoatDong> getHoatDongs(Map<String, String> params) {
            Session s = this.factory.getObject().openSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện

            CriteriaQuery<HoatDong> q = b.createQuery(HoatDong.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(HoatDong.class);//Muốn lấy trường (column)
            q.select(r);
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
            }
            String dieuId = params.get("dieuId");
            if (dieuId != null && !dieuId.isEmpty()) {
                predicates.add(b.equal(r.get("dieuId"), Integer.valueOf(dieuId)));
            }

            q.where(predicates.toArray(Predicate[]::new));

            q.orderBy(b.desc(r.get("id")));
            Query query = s.createQuery(q);

            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int pageSize = Integer.parseInt(env.getProperty("hoatDong.pageSize"));
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
            List<HoatDong> hoatDongs = query.getResultList();
            return hoatDongs;
        }

        @Override
        public void addOrUpdate(HoatDong h) {
            Session s = this.factory.getObject().getCurrentSession();
            if (h.getId() > 0) {
                s.update(h);
            } else {
                s.save(h);
            }
        }

        @Override
        public HoatDong getHoatDongByIDd(int id) {
            Session s = this.factory.getObject().getCurrentSession();
            return s.get(HoatDong.class, id);
        }

        @Override
        public void deleteHoatDong(int id) {
            Session s = this.factory.getObject().getCurrentSession();
            HoatDong h = this.getHoatDongByIDd(id);
            s.delete(h);
        }
    }
