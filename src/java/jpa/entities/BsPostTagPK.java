/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sergio
 */
@Embeddable
public class BsPostTagPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ps_post_id")
    private int psPostId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bs_post_tag_tag")
    private String bsPostTagTag;

    public BsPostTagPK() {
    }

    public BsPostTagPK(int psPostId, String bsPostTagTag) {
        this.psPostId = psPostId;
        this.bsPostTagTag = bsPostTagTag;
    }

    public int getPsPostId() {
        return psPostId;
    }

    public void setPsPostId(int psPostId) {
        this.psPostId = psPostId;
    }

    public String getBsPostTagTag() {
        return bsPostTagTag;
    }

    public void setBsPostTagTag(String bsPostTagTag) {
        this.bsPostTagTag = bsPostTagTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) psPostId;
        hash += (bsPostTagTag != null ? bsPostTagTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsPostTagPK)) {
            return false;
        }
        BsPostTagPK other = (BsPostTagPK) object;
        if (this.psPostId != other.psPostId) {
            return false;
        }
        if ((this.bsPostTagTag == null && other.bsPostTagTag != null) || (this.bsPostTagTag != null && !this.bsPostTagTag.equals(other.bsPostTagTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BsPostTagPK[ psPostId=" + psPostId + ", bsPostTagTag=" + bsPostTagTag + " ]";
    }
    
}
