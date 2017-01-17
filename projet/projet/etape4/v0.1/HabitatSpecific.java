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

        switch(num) {
        }
    }
}