/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Beans.ProyectoBean;
import Entidades.Proyecto;
import javax.el.ELContext;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alejandro
 */

@FacesConverter("proyectoConverter")
public class proyectoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ELContext elc = FacesContext.getCurrentInstance().getELContext();
        ProyectoBean proyectoBean = (ProyectoBean) elc.getELResolver().getValue(elc, null, "proyectoBean");
        for (Proyecto proyecto : proyectoBean.getAll()) {
            if (("" + proyecto.hashCode()).equalsIgnoreCase(value)) {
                return proyecto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return "" + value.hashCode();
        }
        return null;
    }
    
}
