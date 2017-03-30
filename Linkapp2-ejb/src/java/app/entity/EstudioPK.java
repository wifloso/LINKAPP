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
public class EstudioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CENTRO_FORMACION_ID")
    private int centroFormacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private int usuarioId;

    public EstudioPK() {
    }

    public EstudioPK(Date fechaInicio, int centroFormacionId, int usuarioId) {
        this.fechaInicio = fechaInicio;
        this.centroFormacionId = centroFormacionId;
        this.usuarioId = usuarioId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCentroFormacionId() {
        return centroFormacionId;
    }

    public void setCentroFormacionId(int centroFormacionId) {
        this.centroFormacionId = centroFormacionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaInicio != null ? fechaInicio.hashCode() : 0);
        hash += (int) centroFormacionId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudioPK)) {
            return false;
        }
        EstudioPK other = (EstudioPK) object;
        if ((this.fechaInicio == null && other.fechaInicio != null) || (this.fechaInicio != null && !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        if (this.centroFormacionId != other.centroFormacionId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.EstudioPK[ fechaInicio=" + fechaInicio + ", centroFormacionId=" + centroFormacionId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
