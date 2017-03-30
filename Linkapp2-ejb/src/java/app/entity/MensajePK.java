/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Carlos
 */
@Embeddable
public class MensajePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMISOR")
    private int emisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEPTOR")
    private int receptor;

    public MensajePK() {
    }

    public MensajePK(Date fecha, int emisor, int receptor) {
        this.fecha = fecha;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) emisor;
        hash += (int) receptor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajePK)) {
            return false;
        }
        MensajePK other = (MensajePK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
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
        return "app.entity.MensajePK[ fecha=" + fecha + ", emisor=" + emisor + ", receptor=" + receptor + " ]";
    }
    
}
