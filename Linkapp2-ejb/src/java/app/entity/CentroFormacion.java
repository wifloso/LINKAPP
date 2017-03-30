/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "CENTRO_FORMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroFormacion.findAll", query = "SELECT c FROM CentroFormacion c")
    , @NamedQuery(name = "CentroFormacion.findById", query = "SELECT c FROM CentroFormacion c WHERE c.id = :id")
    , @NamedQuery(name = "CentroFormacion.findByNombre", query = "SELECT c FROM CentroFormacion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CentroFormacion.findByUbicacion", query = "SELECT c FROM CentroFormacion c WHERE c.ubicacion = :ubicacion")})
public class CentroFormacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "UBICACION")
    private String ubicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "centroFormacion")
    private Collection<Estudio> estudioCollection;

    public CentroFormacion() {
    }

    public CentroFormacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlTransient
    public Collection<Estudio> getEstudioCollection() {
        return estudioCollection;
    }

    public void setEstudioCollection(Collection<Estudio> estudioCollection) {
        this.estudioCollection = estudioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroFormacion)) {
            return false;
        }
        CentroFormacion other = (CentroFormacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.CentroFormacion[ id=" + id + " ]";
    }
    
}
