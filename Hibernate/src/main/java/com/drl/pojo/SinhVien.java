/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author trinh
 */
@Entity
@Table(name = "sinh_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinhVien.findAll", query = "SELECT s FROM SinhVien s"),
    @NamedQuery(name = "SinhVien.findById", query = "SELECT s FROM SinhVien s WHERE s.id = :id")})
public class SinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lop lopId;
    @JoinColumn(name = "nam_hoc_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NamHoc namHocId;
    @OneToMany(mappedBy = "sinhVienId")
    private Set<SinhVienHoatDong> sinhVienHoatDongSet;

    public SinhVien() {
    }

    public SinhVien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lop getLopId() {
        return lopId;
    }

    public void setLopId(Lop lopId) {
        this.lopId = lopId;
    }

    public NamHoc getNamHocId() {
        return namHocId;
    }

    public void setNamHocId(NamHoc namHocId) {
        this.namHocId = namHocId;
    }

    @XmlTransient
    public Set<SinhVienHoatDong> getSinhVienHoatDongSet() {
        return sinhVienHoatDongSet;
    }

    public void setSinhVienHoatDongSet(Set<SinhVienHoatDong> sinhVienHoatDongSet) {
        this.sinhVienHoatDongSet = sinhVienHoatDongSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SinhVien)) {
            return false;
        }
        SinhVien other = (SinhVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.SinhVien[ id=" + id + " ]";
    }
    
}
