/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.hibernate;

//import com.drl.pojo.Category;
//import com.drl.pojo.Comment;
//import com.drl.pojo.OrderDetail;
//import com.drl.pojo.ProdTag;
//import com.drl.pojo.Product;
//import com.drl.pojo.SaleOrder;
//import com.drl.pojo.Tag;
//import com.drl.pojo.User;
import com.drl.pojo.BaiViet;
import com.drl.pojo.ChuyenVienCtsv;
import com.drl.pojo.Comment;
import com.drl.pojo.Dieu;
import com.drl.pojo.HoatDong;
import com.drl.pojo.HocKi;
import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.Khoa;
import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.pojo.TroLySinhVien;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HiberateUtils {
    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        
//        Properties props = new Properties();
//        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
//        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//        props.put(Environment.URL, "jdbc:mysql://localhost/qldrl");
//        props.put(Environment.USER, "root");
//        props.put(Environment.PASS, "Admin@123");
//        props.put(Environment.SHOW_SQL, "true");
          //conf.setProperties(props);
        
          conf.addAnnotatedClass(BaiViet.class);
          conf.addAnnotatedClass(ChuyenVienCtsv.class);
          conf.addAnnotatedClass(Comment.class);
          conf.addAnnotatedClass(Dieu.class);
          conf.addAnnotatedClass(HoatDong.class);
          conf.addAnnotatedClass(HocKi.class);
          conf.addAnnotatedClass(HocKiNamHoc.class);
          conf.addAnnotatedClass(Khoa.class);
          conf.addAnnotatedClass(Lop.class);
          conf.addAnnotatedClass(NamHoc.class);
          conf.addAnnotatedClass(NguoiDung.class);
          conf.addAnnotatedClass(SinhVien.class);
          conf.addAnnotatedClass(SinhVienHoatDong.class);
          conf.addAnnotatedClass(TroLySinhVien.class);


//        conf.addAnnotatedClass(Category.class);
//        conf.addAnnotatedClass(Product.class);
//        conf.addAnnotatedClass(Comment.class);
//        conf.addAnnotatedClass(Tag.class);
//        conf.addAnnotatedClass(ProdTag.class);
//        conf.addAnnotatedClass(User.class);
//        conf.addAnnotatedClass(SaleOrder.class);
//        conf.addAnnotatedClass(OrderDetail.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(registry);
    }
    
    public static SessionFactory getFactory() {
        return FACTORY;
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
