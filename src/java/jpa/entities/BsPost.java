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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "bs_post", catalog = "bs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsPost.findAll", query = "SELECT b FROM BsPost b"),
    @NamedQuery(name = "BsPost.findByPostId", query = "SELECT b FROM BsPost b WHERE b.postId = :postId"),
    @NamedQuery(name = "BsPost.findByPostTitle", query = "SELECT b FROM BsPost b WHERE b.postTitle = :postTitle"),
    @NamedQuery(name = "BsPost.findByPostPublished", query = "SELECT b FROM BsPost b WHERE b.postPublished = :postPublished"),
    @NamedQuery(name = "BsPost.findByPostAlias", query = "SELECT b FROM BsPost b WHERE b.postAlias = :postAlias")})
public class BsPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_id")
    private Integer postId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "post_title")
    private String postTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "post_body")
    private String postBody;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_published")
    private int postPublished;
    @Size(max = 255)
    @Column(name = "post_alias")
    private String postAlias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bsPost")
    private Collection<BsPostTag> bsPostTagCollection;
    @JoinColumn(name = "bs_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private BsUser bsUserId;

    public BsPost() {
    }

    public BsPost(Integer postId) {
        this.postId = postId;
    }

    public BsPost(Integer postId, String postTitle, String postBody, int postPublished) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postPublished = postPublished;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public int getPostPublished() {
        return postPublished;
    }
    public String getPostPublishedFullDate(){
        java.sql.Date date = new java.sql.Date((long)((long)this.postPublished * (long)1000));
        return date.toString();
    }

    public void setPostPublished(int postPublished) {
        this.postPublished = postPublished;
    }

    public String getPostAlias() {
        return postAlias;
    }

    public void setPostAlias(String postAlias) {
        this.postAlias = postAlias;
    }

    @XmlTransient
    public Collection<BsPostTag> getBsPostTagCollection() {
        return bsPostTagCollection;
    }

    public void setBsPostTagCollection(Collection<BsPostTag> bsPostTagCollection) {
        this.bsPostTagCollection = bsPostTagCollection;
    }

    public BsUser getBsUserId() {
        return bsUserId;
    }

    public void setBsUserId(BsUser bsUserId) {
        this.bsUserId = bsUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postId != null ? postId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsPost)) {
            return false;
        }
        BsPost other = (BsPost) object;
        if ((this.postId == null && other.postId != null) || (this.postId != null && !this.postId.equals(other.postId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BsPost[ postId=" + postId + " ]";
    }
    
}
