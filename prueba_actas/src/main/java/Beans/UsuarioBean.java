/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/prueba_actas/faces/" + url);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
