/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "sinh_vien_hoat_dong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinhVienHoatDong.findAll", query = "SELECT s FROM SinhVienHoatDong s"),
    @NamedQuery(name = "SinhVienHoatDong.findById", query = "SELECT s FROM SinhVienHoatDong s WHERE s.id = :id"),
    @NamedQuery(name = "SinhVienHoatDong.findByTrangThai", query = "SELECT s FROM SinhVienHoatDong s WHERE s.trangThai = :trangThai")})
public class SinhVienHoatDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trang_thai")
    private short trangThai;
    @JoinColumn(name = "hoat_dong_id", referencedColumnName = "id")
    @ManyToOne
    private HoatDong hoatDongId;
    @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")
    @ManyToOne
    private SinhVien sinhVienId;

    public SinhVienHoatDong() {
    }

    public SinhVienHoatDong(Integer id) {
        this.id = id;
    }

    public SinhVienHoatDong(Integer id, short trangThai) {
        this.id = id;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(short trangThai) {
        this.trangThai = trangThai;
    }

    public HoatDong getHoatDongId() {
        return hoatDongId;
    }

    public void setHoatDongId(HoatDong hoatDongId) {
        this.hoatDongId = hoatDongId;
    }

    public SinhVien getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(SinhVien sinhVienId) {
        this.sinhVienId = sinhVienId;
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
        if (!(object instanceof SinhVienHoatDong)) {
            return false;
        }
        SinhVienHoatDong other = (SinhVienHoatDong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.SinhVienHoatDong[ id=" + id + " ]";
    }
    
}
