/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.ddts;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author QINY
 */
@Embeddable
public class EnclosuresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDENTIFIER")
    private String identifier;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    public EnclosuresPK() {
    }

    public EnclosuresPK(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identifier != null ? identifier.hashCode() : 0);
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnclosuresPK)) {
            return false;
        }
        EnclosuresPK other = (EnclosuresPK) object;
        if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier))) {
            return false;
        }
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amdocs.optima.searchEngine.model.ddts.EnclosuresPK[ identifier=" + identifier + ", name=" + name + " ]";
    }
    
}
