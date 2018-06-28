package Entidades;

import Entidades.Compromiso;
import Entidades.Participante;
import Entidades.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T23:33:48")
@StaticMetamodel(ActaReunion.class)
public class ActaReunion_ { 

    public static volatile ListAttribute<ActaReunion, Compromiso> compromisoList;
    public static volatile SingularAttribute<ActaReunion, Date> fecha;
    public static volatile SingularAttribute<ActaReunion, String> ubicacion;
    public static volatile SingularAttribute<ActaReunion, Integer> idactaReunion;
    public static volatile SingularAttribute<ActaReunion, String> contenidos;
    public static volatile ListAttribute<ActaReunion, Participante> participanteList;
    public static volatile SingularAttribute<ActaReunion, Date> fechaProximaReunion;
    public static volatile SingularAttribute<ActaReunion, Proyecto> proyectoIdproyecto;

}