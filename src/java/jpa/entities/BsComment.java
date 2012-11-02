/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "bs_comment", catalog = "bs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsComment.findAll", query = "SELECT b FROM BsComment b"),
    @NamedQuery(name = "BsComment.findByCommentId", query = "SELECT b FROM BsComment b WHERE b.commentId = :commentId"),
    @NamedQuery(name = "BsComment.findByCommentUsername", query = "SELECT b FROM BsComment b WHERE b.commentUsername = :commentUsername"),
    @NamedQuery(name = "BsComment.findByCommentUseremail", query = "SELECT b FROM BsComment b WHERE b.commentUseremail = :commentUseremail"),
    @NamedQuery(name = "BsComment.findByCommentUsersite", query = "SELECT b FROM BsComment b WHERE b.commentUsersite = :commentUsersite"),
    @NamedQuery(name = "BsComment.findByCommentPublished", query = "SELECT b FROM BsComment b WHERE b.commentPublished = :commentPublished")})
public class BsComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id")
    private Integer commentId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment_body")
    private String commentBody;
    @Size(max = 255)
    @Column(name = "comment_username")
    private String commentUsername;
    @Size(max = 255)
    @Column(name = "comment_useremail")
    private String commentUseremail;
    @Size(max = 500)
    @Column(name = "comment_usersite")
    private String commentUsersite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_published")
    private int commentPublished;
    @JoinColumn(name = "bs_user_id", referencedColumnName = "user_id")
    @ManyToOne
    private BsUser bsUserId;

    public BsComment() {
    }

    public BsComment(Integer commentId) {
        this.commentId = commentId;
    }

    public BsComment(Integer commentId, String commentBody, int commentPublished) {
        this.commentId = commentId;
        this.commentBody = commentBody;
        this.commentPublished = commentPublished;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }

    public String getCommentUseremail() {
        return commentUseremail;
    }

    public void setCommentUseremail(String commentUseremail) {
        this.commentUseremail = commentUseremail;
    }

    public String getCommentUsersite() {
        return commentUsersite;
    }

    public void setCommentUsersite(String commentUsersite) {
        this.commentUsersite = commentUsersite;
    }

    public int getCommentPublished() {
        return commentPublished;
    }

    public void setCommentPublished(int commentPublished) {
        this.commentPublished = commentPublished;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsComment)) {
            return false;
        }
        BsComment other = (BsComment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BsComment[ commentId=" + commentId + " ]";
    }
    
}
