/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "acta_reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActaReunion.findAll", query = "SELECT a FROM ActaReunion a")
    , @NamedQuery(name = "ActaReunion.findByIdactaReunion", query = "SELECT a FROM ActaReunion a WHERE a.idactaReunion = :idactaReunion")
    , @NamedQuery(name = "ActaReunion.findByFecha", query = "SELECT a FROM ActaReunion a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "ActaReunion.findByUbicacion", query = "SELECT a FROM ActaReunion a WHERE a.ubicacion = :ubicacion")
    , @NamedQuery(name = "ActaReunion.findByContenidos", query = "SELECT a FROM ActaReunion a WHERE a.contenidos = :contenidos")
    , @NamedQuery(name = "ActaReunion.findByFechaProximaReunion", query = "SELECT a FROM ActaReunion a WHERE a.fechaProximaReunion = :fechaProximaReunion")})
public class ActaReunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacta_reunion")
    private Integer idactaReunion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contenidos")
    private String contenidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_proxima_reunion")
    @Temporal(TemporalType.DATE)
    private Date fechaProximaReunion;
    @JoinTable(name = "lista_participantes", joinColumns = {
        @JoinColumn(name = "acta_reunion_idacta_reunion", referencedColumnName = "idacta_reunion")}, inverseJoinColumns = {
        @JoinColumn(name = "participante_idparticipante", referencedColumnName = "idparticipante")})
    @ManyToMany
    private List<Participante> participanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actaReunionIdactaReunion")
    private List<Compromiso> compromisoList;
    @JoinColumn(name = "proyecto_idproyecto", referencedColumnName = "idproyecto")
    @ManyToOne(optional = false)
    private Proyecto proyectoIdproyecto;

    public ActaReunion() {
    }

    public ActaReunion(Integer idactaReunion) {
        this.idactaReunion = idactaReunion;
    }

    public ActaReunion(Integer idactaReunion, Date fecha, String ubicacion, String contenidos, Date fechaProximaReunion) {
        this.idactaReunion = idactaReunion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.contenidos = contenidos;
        this.fechaProximaReunion = fechaProximaReunion;
    }

    public Integer getIdactaReunion() {
        return idactaReunion;
    }

    public void setIdactaReunion(Integer idactaReunion) {
        this.idactaReunion = idactaReunion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContenidos() {
        return contenidos;
    }

    public void setContenidos(String contenidos) {
        this.contenidos = contenidos;
    }

    public Date getFechaProximaReunion() {
        return fechaProximaReunion;
    }

    public void setFechaProximaReunion(Date fechaProximaReunion) {
        this.fechaProximaReunion = fechaProximaReunion;
    }

    @XmlTransient
    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

    @XmlTransient
    public List<Compromiso> getCompromisoList() {
        return compromisoList;
    }

    public void setCompromisoList(List<Compromiso> compromisoList) {
        this.compromisoList = compromisoList;
    }

    public Proyecto getProyectoIdproyecto() {
        return proyectoIdproyecto;
    }

    public void setProyectoIdproyecto(Proyecto proyectoIdproyecto) {
        this.proyectoIdproyecto = proyectoIdproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactaReunion != null ? idactaReunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActaReunion)) {
            return false;
        }
        ActaReunion other = (ActaReunion) object;
        if ((this.idactaReunion == null && other.idactaReunion != null) || (this.idactaReunion != null && !this.idactaReunion.equals(other.idactaReunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ActaReunion[ idactaReunion=" + idactaReunion + " ]";
    }
    
}
