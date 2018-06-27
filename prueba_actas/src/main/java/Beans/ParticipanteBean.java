/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Participante;
import Facade.ParticipanteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class ParticipanteBean implements Serializable{

    @EJB
    private ParticipanteFacade pf;
    
    private Participante participante;
    /**
     * Creates a new instance of ParticipanteBean
     */
    public ParticipanteBean() {
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    /**
     * Retorna todos los participantes existentes en la Base de Datos
     * @return 
     */
    public List<Participante> getAll(){
        return pf.findAll();
    }
    
    /**
     * Registra un participante
     */
    public void makeParticipante(){
        System.out.println("Primer Nombre: " + participante.getNombre1());
        try {
            pf.create(participante);
            participante = new Participante();
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Participante ingresado exitosamente", null));
        } catch (Exception e) {
            System.err.println("Error al insertar participante: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al insertar participante: " + e.getMessage(), null));
        }
    }
    
    public List<Participante> resultdataAutoComplete(String query){
        List<Participante> participantes = getAll();
        List<Participante> autoComplete = new ArrayList<>();
        if (query.equals("")) {
            return participantes;
        } else {
            for (Participante participante1 : participantes) {
                if (participante1.getNombre1().startsWith(query) || participante1.getNombre1().equals(query) || participante1.getNombre2().startsWith(query) || participante1.getNombre2().equals(query) || participante1.getApellido1().startsWith(query) || participante1.getApellido1().equals(query) || participante1.getApellido2().startsWith(query) || participante1.getApellido2().equals(query)) {
                    autoComplete.add(participante1);
                }
            }
            return autoComplete;
        }
    }
    
    @PostConstruct
    public void init(){
        participante = new Participante();
    }
}
