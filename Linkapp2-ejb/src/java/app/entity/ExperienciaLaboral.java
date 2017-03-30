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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "EXPERIENCIA_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaInicio", query = "SELECT e FROM ExperienciaLaboral e WHERE e.experienciaLaboralPK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaFinal", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "ExperienciaLaboral.findByPuesto", query = "SELECT e FROM ExperienciaLaboral e WHERE e.puesto = :puesto")
    , @NamedQuery(name = "ExperienciaLaboral.findByEmpresaId", query = "SELECT e FROM ExperienciaLaboral e WHERE e.experienciaLaboralPK.empresaId = :empresaId")
    , @NamedQuery(name = "ExperienciaLaboral.findByUsuarioId", query = "SELECT e FROM ExperienciaLaboral e WHERE e.experienciaLaboralPK.usuarioId = :usuarioId")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExperienciaLaboralPK experienciaLaboralPK;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PUESTO")
    private String puesto;
    @JoinColumn(name = "EMPRESA_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(ExperienciaLaboralPK experienciaLaboralPK) {
        this.experienciaLaboralPK = experienciaLaboralPK;
    }

    public ExperienciaLaboral(ExperienciaLaboralPK experienciaLaboralPK, String puesto) {
        this.experienciaLaboralPK = experienciaLaboralPK;
        this.puesto = puesto;
    }

    public ExperienciaLaboral(Date fechaInicio, int empresaId, int usuarioId) {
        this.experienciaLaboralPK = new ExperienciaLaboralPK(fechaInicio, empresaId, usuarioId);
    }

    public ExperienciaLaboralPK getExperienciaLaboralPK() {
        return experienciaLaboralPK;
    }

    public void setExperienciaLaboralPK(ExperienciaLaboralPK experienciaLaboralPK) {
        this.experienciaLaboralPK = experienciaLaboralPK;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experienciaLaboralPK != null ? experienciaLaboralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.experienciaLaboralPK == null && other.experienciaLaboralPK != null) || (this.experienciaLaboralPK != null && !this.experienciaLaboralPK.equals(other.experienciaLaboralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.ExperienciaLaboral[ experienciaLaboralPK=" + experienciaLaboralPK + " ]";
    }
    
}
