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
        case 0: //Scenario soiree
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {
            appareil.appliquer(TypeActionAppareil.FERMER);
            }
            break;
        case 1: //Scenario depart
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {
            appareil.appliquer(TypeActionAppareil.FERMER);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {
            appareil.appliquer(TypeActionAppareil.ETEINDRE);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("fen"))
            if(appareil.etatAppareil.equals(TypeEtatAppareil.FERME)) {
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            }
            else {
            appareil.appliquer(TypeActionAppareil.ETEINDRE);
            }
            break;
        case 2: //Scenario bonjour
            for(CAppareil appareil : this.l_appareils)
            if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {
            appareil.appliquer(TypeActionAppareil.OUVRIR);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("a1"))
            appareil.appliquer(TypeActionAppareil.ETEINDRE);
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("cafe"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("rad1"))
            if(appareil.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            }
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("hf"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            break;
        case 3: //Scenario noel3
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("e3"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            break;
        case 4: //Scenario noel2
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("e2"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            break;
        case 5: //Scenario noel1
            for(CAppareil appareil : this.l_appareils)
            if(appareil.getNomAppareil().equals("e1"))
            appareil.appliquer(TypeActionAppareil.ALLUMER);
            break;
        }
    }
}