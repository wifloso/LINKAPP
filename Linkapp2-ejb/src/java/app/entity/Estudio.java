/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "ESTUDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e")
    , @NamedQuery(name = "Estudio.findByFechaInicio", query = "SELECT e FROM Estudio e WHERE e.estudioPK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Estudio.findByFechaFinal", query = "SELECT e FROM Estudio e WHERE e.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Estudio.findByTipo", query = "SELECT e FROM Estudio e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Estudio.findByCentroFormacionId", query = "SELECT e FROM Estudio e WHERE e.estudioPK.centroFormacionId = :centroFormacionId")
    , @NamedQuery(name = "Estudio.findByUsuarioId", query = "SELECT e FROM Estudio e WHERE e.estudioPK.usuarioId = :usuarioId")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudioPK estudioPK;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Size(max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "CENTRO_FORMACION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CentroFormacion centroFormacion;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Estudio() {
    }

    public Estudio(EstudioPK estudioPK) {
        this.estudioPK = estudioPK;
    }

    public Estudio(Date fechaInicio, int centroFormacionId, int usuarioId) {
        this.estudioPK = new EstudioPK(fechaInicio, centroFormacionId, usuarioId);
    }

    public EstudioPK getEstudioPK() {
        return estudioPK;
    }

    public void setEstudioPK(EstudioPK estudioPK) {
        this.estudioPK = estudioPK;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
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
        hash += (estudioPK != null ? estudioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.estudioPK == null && other.estudioPK != null) || (this.estudioPK != null && !this.estudioPK.equals(other.estudioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Estudio[ estudioPK=" + estudioPK + " ]";
    }
    
}
