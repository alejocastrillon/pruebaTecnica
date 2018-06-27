/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author alejandro
 */
@Entity
@Table(name = "participante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p")
    , @NamedQuery(name = "Participante.findByIdparticipante", query = "SELECT p FROM Participante p WHERE p.idparticipante = :idparticipante")
    , @NamedQuery(name = "Participante.findByNombre1", query = "SELECT p FROM Participante p WHERE p.nombre1 = :nombre1")
    , @NamedQuery(name = "Participante.findByNombre2", query = "SELECT p FROM Participante p WHERE p.nombre2 = :nombre2")
    , @NamedQuery(name = "Participante.findByApellido1", query = "SELECT p FROM Participante p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Participante.findByApellido2", query = "SELECT p FROM Participante p WHERE p.apellido2 = :apellido2")})
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparticipante")
    private Integer idparticipante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 45)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @ManyToMany(mappedBy = "participanteList")
    private List<ActaReunion> actaReunionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participanteIdparticipante")
    private List<Compromiso> compromisoList;

    public Participante() {
    }

    public Participante(Integer idparticipante) {
        this.idparticipante = idparticipante;
    }

    public Participante(Integer idparticipante, String nombre1, String apellido1) {
        this.idparticipante = idparticipante;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
    }

    public Integer getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(Integer idparticipante) {
        this.idparticipante = idparticipante;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @XmlTransient
    public List<ActaReunion> getActaReunionList() {
        return actaReunionList;
    }

    public void setActaReunionList(List<ActaReunion> actaReunionList) {
        this.actaReunionList = actaReunionList;
    }

    @XmlTransient
    public List<Compromiso> getCompromisoList() {
        return compromisoList;
    }

    public void setCompromisoList(List<Compromiso> compromisoList) {
        this.compromisoList = compromisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparticipante != null ? idparticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.idparticipante == null && other.idparticipante != null) || (this.idparticipante != null && !this.idparticipante.equals(other.idparticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Participante[ idparticipante=" + idparticipante + " ]";
    }
    
    public String toStringAutoComplete(){
        return this.nombre1 + " " + this.nombre2 + " " + this.apellido1 + " " + this.apellido2;
    }
    
}
