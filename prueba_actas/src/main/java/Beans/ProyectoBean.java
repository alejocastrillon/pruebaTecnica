/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Proyecto;
import Facade.ProyectoFacade;
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
public class ProyectoBean implements Serializable{

    @EJB
    private ProyectoFacade facade;
    
    private Proyecto proyecto;
    /**
     * Creates a new instance of ProyectoBean
     */
    public ProyectoBean() {
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    /**
     * Retorna todos los proyectos existentes en la base de datos
     * @return 
     */
    public List<Proyecto> getAll(){
        return facade.findAll();
    }
    
    /**
     * Inserta un proyecto en la base de datos
     */
    public void makeProyecto(){
        try {
            facade.create(proyecto);
            proyecto = new Proyecto();
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto creado exitosamente", null));
        } catch (Exception e) {
            System.err.println("Error al crear proyecto: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al crear proyecto: " + e.getMessage(), null));
        }
    }
    
    /**
     * Filtra los datos según lo que haya en el autoComplete
     * @param query
     * @return 
     */
    public List<Proyecto> resultdataAutoComplete(String query){
        List<Proyecto> proyectos = getAll();
        List<Proyecto> autoComplete =  new ArrayList<>();
        if (query.equals("")) {
            return proyectos;
        } else {
            for (Proyecto proyecto1 : proyectos) {
                String idProyecto = String.valueOf(proyecto1.getIdproyecto());
                if (idProyecto.equals(query) || proyecto1.getNombre().startsWith(query) || proyecto1.getNombre().equals(query)) {
                    autoComplete.add(proyecto1);
                }
            }
            return autoComplete;
        }
    }
    
    @PostConstruct
    public void init(){
        proyecto = new Proyecto();
    }
}
