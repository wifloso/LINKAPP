/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Carlos
 */
@Embeddable
public class AmistadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EMISOR")
    private int emisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEPTOR")
    private int receptor;

    public AmistadPK() {
    }

    public AmistadPK(int emisor, int receptor) {
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public int getEmisor() {
        return emisor;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) emisor;
        hash += (int) receptor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmistadPK)) {
            return false;
        }
        AmistadPK other = (AmistadPK) object;
        if (this.emisor != other.emisor) {
            return false;
        }
        if (this.receptor != other.receptor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AmistadPK[ emisor=" + emisor + ", receptor=" + receptor + " ]";
    }
    
}
