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
@Table(name = "bs_config", catalog = "bs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsConfig.findAll", query = "SELECT b FROM BsConfig b"),
    @NamedQuery(name = "BsConfig.findByConfigName", query = "SELECT b FROM BsConfig b WHERE b.configName = :configName"),
    @NamedQuery(name = "BsConfig.findByConfigValue", query = "SELECT b FROM BsConfig b WHERE b.configValue = :configValue"),
    @NamedQuery(name = "BsConfig.findByConfigNullable", query = "SELECT b FROM BsConfig b WHERE b.configNullable = :configNullable"),
    @NamedQuery(name = "BsConfig.findByConfigType", query = "SELECT b FROM BsConfig b WHERE b.configType = :configType")})
public class BsConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "config_name")
    private String configName;
    @Size(max = 1000)
    @Column(name = "config_value")
    private String configValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "config_nullable")
    private boolean configNullable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "config_type")
    private String configType;

    public BsConfig() {
    }

    public BsConfig(String configName) {
        this.configName = configName;
    }

    public BsConfig(String configName, boolean configNullable, String configType) {
        this.configName = configName;
        this.configNullable = configNullable;
        this.configType = configType;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public boolean getConfigNullable() {
        return configNullable;
    }

    public void setConfigNullable(boolean configNullable) {
        this.configNullable = configNullable;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configName != null ? configName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsConfig)) {
            return false;
        }
        BsConfig other = (BsConfig) object;
        if ((this.configName == null && other.configName != null) || (this.configName != null && !this.configName.equals(other.configName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BsConfig[ configName=" + configName + " ]";
    }
    
}
