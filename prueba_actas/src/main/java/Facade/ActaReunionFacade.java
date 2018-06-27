/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.ActaReunion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandro
 */
@Stateless
public class ActaReunionFacade extends AbstractFacade<ActaReunion> {

    @PersistenceContext(unitName = "com.mycompany_prueba_actas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActaReunionFacade() {
        super(ActaReunion.class);
    }
    
}
