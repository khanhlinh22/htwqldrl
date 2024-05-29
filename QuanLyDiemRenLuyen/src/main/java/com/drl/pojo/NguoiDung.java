/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "nguoi_dung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n"),
    @NamedQuery(name = "NguoiDung.findById", query = "SELECT n FROM NguoiDung n WHERE n.id = :id"),
    @NamedQuery(name = "NguoiDung.findByHo", query = "SELECT n FROM NguoiDung n WHERE n.ho = :ho"),
    @NamedQuery(name = "NguoiDung.findByTen", query = "SELECT n FROM NguoiDung n WHERE n.ten = :ten"),
    @NamedQuery(name = "NguoiDung.findByNamSinh", query = "SELECT n FROM NguoiDung n WHERE n.namSinh = :namSinh"),
    @NamedQuery(name = "NguoiDung.findByGioiTinh", query = "SELECT n FROM NguoiDung n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "NguoiDung.findByAvatar", query = "SELECT n FROM NguoiDung n WHERE n.avatar = :avatar"),
    @NamedQuery(name = "NguoiDung.findByUsername", query = "SELECT n FROM NguoiDung n WHERE n.username = :username"),
    @NamedQuery(name = "NguoiDung.findByEmail", query = "SELECT n FROM NguoiDung n WHERE n.email = :email"),
    @NamedQuery(name = "NguoiDung.findByPassword", query = "SELECT n FROM NguoiDung n WHERE n.password = :password"),
    @NamedQuery(name = "NguoiDung.findByRole", query = "SELECT n FROM NguoiDung n WHERE n.role = :role")})
public class NguoiDung implements Serializable {
//    public static final String ADMIN ="ROLE_ADMIN";
//    public static final String ASSISTANT ="ROLE_ASSISTANT";
//    public static final String CTSVOU ="ROLE_CTSVOU";
//    public static final String STUDENT ="ROLE_STUDENT";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_sinh")
    private int namSinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioi_tinh")
    private short gioiTinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 205)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
      @OneToOne(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
    private ChuyenVienCtsv chuyenVienCtsv;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
    private TroLySinhVien troLySinhVien;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "nguoiDungId")
    private Set<Comment> commentSet;
     @OneToOne(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
    private SinhVien sinhVien;
    public NguoiDung() {
    }

    public NguoiDung(Integer id) {
        this.id = id;
    }

    public NguoiDung(Integer id, String ho, String ten, int namSinh, short gioiTinh, String avatar, String username, String email, String password, String role) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.avatar = avatar;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
     
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public ChuyenVienCtsv getChuyenVienCtsv() {
        return chuyenVienCtsv;
    }

    public void setChuyenVienCtsv(ChuyenVienCtsv chuyenVienCtsv) {
        this.chuyenVienCtsv = chuyenVienCtsv;
    }

    public TroLySinhVien getTroLySinhVien() {
        return troLySinhVien;
    }

    public void setTroLySinhVien(TroLySinhVien troLySinhVien) {
        this.troLySinhVien = troLySinhVien;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
     public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
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
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drl.pojo.NguoiDung[ id=" + id + " ]";
    }
    
}
