/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.ActaReunion;
import Entidades.Compromiso;
import Entidades.Participante;
import Facade.ActaReunionFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alejandro
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class ActaReunionBean implements Serializable{

    @EJB
    private ActaReunionFacade actaReunionFacade;
    
    private ActaReunion actaReunion, selectedActaReunion;
    private Participante participante;
    private Compromiso compromiso;
    
    private Integer idActaPrint;
    /**
     * Creates a new instance of ActaReunionBean
     */
    public ActaReunionBean() {
    }

    public ActaReunion getActaReunion() {
        return actaReunion;
    }

    public void setActaReunion(ActaReunion actaReunion) {
        this.actaReunion = actaReunion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Compromiso getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(Compromiso compromiso) {
        this.compromiso = compromiso;
    }

    public ActaReunion getSelectedActaReunion() {
        return selectedActaReunion;
    }

    public void setSelectedActaReunion(ActaReunion selectedActaReunion) {
        this.selectedActaReunion = selectedActaReunion;
    }
    
    public List<Participante> getParticipantesReunion(ActaReunion act){
        return act.getParticipanteList();
    }
    
    public List<Compromiso> getCompromisosReunion(ActaReunion act){
        return act.getCompromisoList();
    }

    public Integer getIdActaPrint() {
        return idActaPrint;
    }

    public void setIdActaPrint(Integer idActaPrint) {
        this.idActaPrint = idActaPrint;
    }
    
    /**
     * Selecciona el acta a imprimir
     */
    public void actatoPrint(){
        for (ActaReunion actaReunion1 : getAll()) {
            if (actaReunion1.getIdactaReunion().equals(idActaPrint)) {
                selectedActaReunion = actaReunion1;
                return;
            }
        }
    }
    
    /**
     * Redirecciona a la página de impresión de acta
     * @param act 
     */
    public void redirecttoPrint(ActaReunion act){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/prueba_actas/faces/actas/print.xhtml?acta="+act.getIdactaReunion());
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna todas las actas existentes en la base de datos
     * @return 
     */
    public List<ActaReunion> getAll(){
        return actaReunionFacade.findAll();
    }
    /**
     * Añade participantes a la lista de integrantes
     */
    public void addParticipante(){
        actaReunion.getParticipanteList().add(participante);
        FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Participante agregado", null));
    }
    
    /**
     * Añade compromiso a acta de reunión
     */
    public void addCompromiso(){
        compromiso.setActaReunionIdactaReunion(actaReunion);
        actaReunion.getCompromisoList().add(compromiso);
        compromiso = new Compromiso();
        FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Compromiso agregado", null));
    }
    
    /**
     * Insertar acta en la base de datos
     */
    public void makeActa(){
        try {
            actaReunionFacade.create(actaReunion);
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Acta de reunión creada exitosamente", null));
        } catch (Exception e) {
            System.err.println("Error al crear acta de reunión: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al crear acta de reunión: " + e.getMessage(), null));
        }
    }
    
    @PostConstruct
    public void init(){
        actaReunion = new ActaReunion();
        selectedActaReunion = new ActaReunion();
        actaReunion.setParticipanteList(new ArrayList<Participante>());
        actaReunion.setCompromisoList(new ArrayList<Compromiso>());
        compromiso = new Compromiso();
    }
}
