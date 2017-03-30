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
public class ExperienciaLaboralPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPRESA_ID")
    private int empresaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private int usuarioId;

    public ExperienciaLaboralPK() {
    }

    public ExperienciaLaboralPK(Date fechaInicio, int empresaId, int usuarioId) {
        this.fechaInicio = fechaInicio;
        this.empresaId = empresaId;
        this.usuarioId = usuarioId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
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
        hash += (int) empresaId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboralPK)) {
            return false;
        }
        ExperienciaLaboralPK other = (ExperienciaLaboralPK) object;
        if ((this.fechaInicio == null && other.fechaInicio != null) || (this.fechaInicio != null && !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        if (this.empresaId != other.empresaId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.ExperienciaLaboralPK[ fechaInicio=" + fechaInicio + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
