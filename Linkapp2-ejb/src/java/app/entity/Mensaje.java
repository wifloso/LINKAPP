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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "MENSAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")
    , @NamedQuery(name = "Mensaje.findByFecha", query = "SELECT m FROM Mensaje m WHERE m.mensajePK.fecha = :fecha")
    , @NamedQuery(name = "Mensaje.findByTexto", query = "SELECT m FROM Mensaje m WHERE m.texto = :texto")
    , @NamedQuery(name = "Mensaje.findByEmisor", query = "SELECT m FROM Mensaje m WHERE m.mensajePK.emisor = :emisor")
    , @NamedQuery(name = "Mensaje.findByReceptor", query = "SELECT m FROM Mensaje m WHERE m.mensajePK.receptor = :receptor")
    , @NamedQuery(name = "Mensaje.findByLeido", query = "SELECT m FROM Mensaje m WHERE m.leido = :leido")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensajePK mensajePK;
    @Size(max = 250)
    @Column(name = "TEXTO")
    private String texto;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @Column(name = "LEIDO")
    private Short leido;
    @JoinColumn(name = "EMISOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "RECEPTOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Mensaje() {
    }

    public Mensaje(MensajePK mensajePK) {
        this.mensajePK = mensajePK;
    }

    public Mensaje(Date fecha, int emisor, int receptor) {
        this.mensajePK = new MensajePK(fecha, emisor, receptor);
    }

    public MensajePK getMensajePK() {
        return mensajePK;
    }

    public void setMensajePK(MensajePK mensajePK) {
        this.mensajePK = mensajePK;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    public Short getLeido() {
        return leido;
    }

    public void setLeido(Short leido) {
        this.leido = leido;
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
        hash += (mensajePK != null ? mensajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.mensajePK == null && other.mensajePK != null) || (this.mensajePK != null && !this.mensajePK.equals(other.mensajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Mensaje[ mensajePK=" + mensajePK + " ]";
    }
    
}
