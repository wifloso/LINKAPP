/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "AMISTAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amistad.findAll", query = "SELECT a FROM Amistad a")
    , @NamedQuery(name = "Amistad.findByAceptado", query = "SELECT a FROM Amistad a WHERE a.aceptado = :aceptado")
    , @NamedQuery(name = "Amistad.findByEmisor", query = "SELECT a FROM Amistad a WHERE a.amistadPK.emisor = :emisor")
    , @NamedQuery(name = "Amistad.findByReceptor", query = "SELECT a FROM Amistad a WHERE a.amistadPK.receptor = :receptor")})
public class Amistad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmistadPK amistadPK;
    @Column(name = "ACEPTADO")
    private Short aceptado;
    @JoinColumn(name = "EMISOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "RECEPTOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Amistad() {
    }

    public Amistad(AmistadPK amistadPK) {
        this.amistadPK = amistadPK;
    }

    public Amistad(int emisor, int receptor) {
        this.amistadPK = new AmistadPK(emisor, receptor);
    }

    public AmistadPK getAmistadPK() {
        return amistadPK;
    }

    public void setAmistadPK(AmistadPK amistadPK) {
        this.amistadPK = amistadPK;
    }

    public Short getAceptado() {
        return aceptado;
    }

    public void setAceptado(Short aceptado) {
        this.aceptado = aceptado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amistadPK != null ? amistadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amistad)) {
            return false;
        }
        Amistad other = (Amistad) object;
        if ((this.amistadPK == null && other.amistadPK != null) || (this.amistadPK != null && !this.amistadPK.equals(other.amistadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Amistad[ amistadPK=" + amistadPK + " ]";
    }
    
}
