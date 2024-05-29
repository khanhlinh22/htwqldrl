/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "bai_viet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaiViet.findAll", query = "SELECT b FROM BaiViet b"),
    @NamedQuery(name = "BaiViet.findById", query = "SELECT b FROM BaiViet b WHERE b.id = :id"),
    @NamedQuery(name = "BaiViet.findByTen", query = "SELECT b FROM BaiViet b WHERE b.ten = :ten"),
    @NamedQuery(name = "BaiViet.findByNgayTao", query = "SELECT b FROM BaiViet b WHERE b.ngayTao = :ngayTao"),
    @NamedQuery(name = "BaiViet.findByNoiDung", query = "SELECT b FROM BaiViet b WHERE b.noiDung = :noiDung")})
public class BaiViet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 105)
    @Column(name = "noi_dung")
    private String noiDung;
    @JoinColumn(name = "hoat_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HoatDong hoatDongId;
    @OneToMany(mappedBy = "baiVietId")
    private Set<Comment> commentSet;

    public BaiViet() {
    }

    public BaiViet(Integer id) {
        this.id = id;
    }

    public BaiViet(Integer id, String ten, Date ngayTao, String noiDung) {
        this.id = id;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.noiDung = noiDung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public HoatDong getHoatDongId() {
        return hoatDongId;
    }

    public void setHoatDongId(HoatDong hoatDongId) {
        this.hoatDongId = hoatDongId;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof BaiViet)) {
            return false;
        }
        BaiViet other = (BaiViet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.BaiViet[ id=" + id + " ]";
    }
    
}
