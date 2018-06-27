/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Beans.ParticipanteBean;
import Entidades.Participante;
import javax.el.ELContext;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alejandro
 */

@FacesConverter("participanteConverter")
public class participanteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ELContext elc = FacesContext.getCurrentInstance().getELContext();
        ParticipanteBean participanteBean = (ParticipanteBean) elc.getELResolver().getValue(elc, null, "participanteBean");
        for (Participante participante : participanteBean.getAll()) {
            if (("" + participante.hashCode()).equalsIgnoreCase(value)) {
                return participante;
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
