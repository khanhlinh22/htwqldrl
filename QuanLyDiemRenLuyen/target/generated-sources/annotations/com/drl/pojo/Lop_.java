package com.drl.pojo;

import com.drl.pojo.Khoa;
import com.drl.pojo.SinhVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-29T16:50:33")
@StaticMetamodel(Lop.class)
public class Lop_ { 

    public static volatile SetAttribute<Lop, SinhVien> sinhVienSet;
    public static volatile SingularAttribute<Lop, Integer> id;
    public static volatile SingularAttribute<Lop, String> ten;
    public static volatile SingularAttribute<Lop, Khoa> khoaId;

}