/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "compromiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compromiso.findAll", query = "SELECT c FROM Compromiso c")
    , @NamedQuery(name = "Compromiso.findByIdcompromiso", query = "SELECT c FROM Compromiso c WHERE c.idcompromiso = :idcompromiso")
    , @NamedQuery(name = "Compromiso.findByCompromiso", query = "SELECT c FROM Compromiso c WHERE c.compromiso = :compromiso")})
public class Compromiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompromiso")
    private Integer idcompromiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "compromiso")
    private String compromiso;
    @JoinColumn(name = "acta_reunion_idacta_reunion", referencedColumnName = "idacta_reunion")
    @ManyToOne(optional = false)
    private ActaReunion actaReunionIdactaReunion;
    @JoinColumn(name = "participante_idparticipante", referencedColumnName = "idparticipante")
    @ManyToOne(optional = false)
    private Participante participanteIdparticipante;

    public Compromiso() {
    }

    public Compromiso(Integer idcompromiso) {
        this.idcompromiso = idcompromiso;
    }

    public Compromiso(Integer idcompromiso, String compromiso) {
        this.idcompromiso = idcompromiso;
        this.compromiso = compromiso;
    }

    public Integer getIdcompromiso() {
        return idcompromiso;
    }

    public void setIdcompromiso(Integer idcompromiso) {
        this.idcompromiso = idcompromiso;
    }

    public String getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    public ActaReunion getActaReunionIdactaReunion() {
        return actaReunionIdactaReunion;
    }

    public void setActaReunionIdactaReunion(ActaReunion actaReunionIdactaReunion) {
        this.actaReunionIdactaReunion = actaReunionIdactaReunion;
    }

    public Participante getParticipanteIdparticipante() {
        return participanteIdparticipante;
    }

    public void setParticipanteIdparticipante(Participante participanteIdparticipante) {
        this.participanteIdparticipante = participanteIdparticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompromiso != null ? idcompromiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compromiso)) {
            return false;
        }
        Compromiso other = (Compromiso) object;
        if ((this.idcompromiso == null && other.idcompromiso != null) || (this.idcompromiso != null && !this.idcompromiso.equals(other.idcompromiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Compromiso[ idcompromiso=" + idcompromiso + " ]";
    }
    
}
