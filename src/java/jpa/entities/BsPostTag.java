/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "bs_post_tag", catalog = "bs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsPostTag.findAll", query = "SELECT b FROM BsPostTag b"),
    @NamedQuery(name = "BsPostTag.findByPsPostId", query = "SELECT b FROM BsPostTag b WHERE b.bsPostTagPK.psPostId = :psPostId"),
    @NamedQuery(name = "BsPostTag.findByBsPostTagTag", query = "SELECT b FROM BsPostTag b WHERE b.bsPostTagPK.bsPostTagTag = :bsPostTagTag")})
public class BsPostTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BsPostTagPK bsPostTagPK;
    @JoinColumn(name = "ps_post_id", referencedColumnName = "post_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BsPost bsPost;

    public BsPostTag() {
    }

    public BsPostTag(BsPostTagPK bsPostTagPK) {
        this.bsPostTagPK = bsPostTagPK;
    }

    public BsPostTag(int psPostId, String bsPostTagTag) {
        this.bsPostTagPK = new BsPostTagPK(psPostId, bsPostTagTag);
    }

    public BsPostTagPK getBsPostTagPK() {
        return bsPostTagPK;
    }

    public void setBsPostTagPK(BsPostTagPK bsPostTagPK) {
        this.bsPostTagPK = bsPostTagPK;
    }

    public BsPost getBsPost() {
        return bsPost;
    }

    public void setBsPost(BsPost bsPost) {
        this.bsPost = bsPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bsPostTagPK != null ? bsPostTagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsPostTag)) {
            return false;
        }
        BsPostTag other = (BsPostTag) object;
        if ((this.bsPostTagPK == null && other.bsPostTagPK != null) || (this.bsPostTagPK != null && !this.bsPostTagPK.equals(other.bsPostTagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BsPostTag[ bsPostTagPK=" + bsPostTagPK + " ]";
    }
    
}
