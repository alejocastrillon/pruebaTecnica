package Entidades;

import Entidades.ActaReunion;
import Entidades.Compromiso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T16:35:28")
@StaticMetamodel(Participante.class)
public class Participante_ { 

    public static volatile ListAttribute<Participante, Compromiso> compromisoList;
    public static volatile SingularAttribute<Participante, String> apellido2;
    public static volatile SingularAttribute<Participante, String> apellido1;
    public static volatile SingularAttribute<Participante, Integer> idparticipante;
    public static volatile SingularAttribute<Participante, String> nombre2;
    public static volatile SingularAttribute<Participante, String> nombre1;
    public static volatile ListAttribute<Participante, ActaReunion> actaReunionList;

}