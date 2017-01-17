//HabitatSpecific.java

import java.util.ArrayList;

public class HabitatSpecific extends Habitat {
    public HabitatSpecific(  ArrayList<CAppareil> lapp,
                             ArrayList<CEnsAppareil> lens,
                             ArrayList<CScenario> lscen,
                             ArrayList<CInterface> lint,
                             ArrayList<CProgrammation> lprog) {
        super(lapp,lens,lscen,lint,lprog);
    }

    public void execScenarioNum(int num) {
        System.out.println("Execution du scenario "+ this.l_scenarios.get(num).getNomScenario() + "...");


        //Scenarii
        switch(num) {
        case 0: //Scenario salon
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("s1"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("s2"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            break;
        case 1: //Scenario aurevoir
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {
            appareil.appliquer(TypeActionAppareil.ETEINDRE);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("v1"))
            appareil.appliquer(TypeActionAppareil.FERMER);
            break;
        case 2: //Scenario bonjour
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("v1"))
            appareil.appliquer(TypeActionAppareil.OUVRIR);
            break;
        case 3: //Scenario gestionnaireVolet
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("v1"))
            if(appareil.etatAppareil.equals(TypeEtatAppareil.OUVERT)) {
            appareil.appliquer(TypeActionAppareil.FERMER);
            }
            else {
            appareil.appliquer(TypeActionAppareil.OUVRIR);
            }
            break;
        }
    }
}