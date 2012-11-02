/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "bs_user", catalog = "bs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsUser.findAll", query = "SELECT b FROM BsUser b"),
    @NamedQuery(name = "BsUser.findByUserId", query = "SELECT b FROM BsUser b WHERE b.userId = :userId"),
    @NamedQuery(name = "BsUser.findByUserName", query = "SELECT b FROM BsUser b WHERE b.userName = :userName"),
    @NamedQuery(name = "BsUser.findByUserPassword", query = "SELECT b FROM BsUser b WHERE b.userPassword = :userPassword"),
    @NamedQuery(name = "BsUser.findByUserSince", query = "SELECT b FROM BsUser b WHERE b.userSince = :userSince")})
public class BsUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_since")
    private int userSince;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_info")
    private String userInfo;
    @OneToMany(mappedBy = "bsUserId")
    private Collection<BsComment> bsCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bsUserId")
    private Collection<BsPost> bsPostCollection;

    public BsUser() {
    }

    public BsUser(Integer userId) {
        this.userId = userId;
    }

    public BsUser(Integer userId, String userName, String userPassword, int userSince) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSince = userSince;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserSince() {
        return userSince;
    }

    public void setUserSince(int userSince) {
        this.userSince = userSince;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @XmlTransient
    public Collection<BsComment> getBsCommentCollection() {
        return bsCommentCollection;
    }

    public void setBsCommentCollection(Collection<BsComment> bsCommentCollection) {
        this.bsCommentCollection = bsCommentCollection;
    }

    @XmlTransient
    public Collection<BsPost> getBsPostCollection() {
        return bsPostCollection;
    }

    public void setBsPostCollection(Collection<BsPost> bsPostCollection) {
        this.bsPostCollection = bsPostCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsUser)) {
            return false;
        }
        BsUser other = (BsUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return userName;
    }
    
}
