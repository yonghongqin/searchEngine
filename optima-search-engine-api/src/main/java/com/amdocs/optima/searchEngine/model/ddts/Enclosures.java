/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.ddts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author QINY
 */
@Entity
@Table(name = "enclosures")
@NamedQueries({
    @NamedQuery(name = "Enclosures.findAll", query = "SELECT e FROM Enclosures e")})
public class Enclosures implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnclosuresPK enclosuresPK;
    @Column(name = "OPERATION")
    private String operation;
    @Column(name = "OP_DATE")
    @Temporal(TemporalType.DATE)
    private Date opDate;
    @Column(name = "ENGINEER")
    private String engineer;
    @Column(name = "TEXT")
    private String text;

    public Enclosures() {
    }

    public Enclosures(EnclosuresPK enclosuresPK) {
        this.enclosuresPK = enclosuresPK;
    }

    public Enclosures(String identifier, String name) {
        this.enclosuresPK = new EnclosuresPK(identifier, name);
    }

    public EnclosuresPK getEnclosuresPK() {
        return enclosuresPK;
    }

    public void setEnclosuresPK(EnclosuresPK enclosuresPK) {
        this.enclosuresPK = enclosuresPK;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enclosuresPK != null ? enclosuresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enclosures)) {
            return false;
        }
        Enclosures other = (Enclosures) object;
        if ((this.enclosuresPK == null && other.enclosuresPK != null) || (this.enclosuresPK != null && !this.enclosuresPK.equals(other.enclosuresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amdocs.optima.searchEngine.model.ddts.Enclosures[ enclosuresPK=" + enclosuresPK + " ]";
    }
    
}
