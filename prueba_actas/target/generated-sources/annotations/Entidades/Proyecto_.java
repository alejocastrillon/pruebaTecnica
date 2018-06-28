package Entidades;

import Entidades.ActaReunion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T23:33:48")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Integer> idproyecto;
    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile ListAttribute<Proyecto, ActaReunion> actaReunionList;

}