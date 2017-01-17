//CMaisonUser.java

public class CMaisonUser extends CMaison {
    public CMaisonUser() {
        super();

        //Appareils
        CVolet v1 = new CVolet("v1", TypeAppareil.VOLET);
        ma_liste_appareils.add(v1);
        CVolet v2 = new CVolet("v2", TypeAppareil.VOLET);
        ma_liste_appareils.add(v2);
        CVolet v3 = new CVolet("v3", TypeAppareil.VOLET);
        ma_liste_appareils.add(v3);
        CVolet v4 = new CVolet("v4", TypeAppareil.VOLET);
        ma_liste_appareils.add(v4);
        CFenetre fen = new CFenetre("fen", TypeAppareil.FENETRE);
        ma_liste_appareils.add(fen);
        CChauffage rad1 = new CChauffage("rad1", TypeAppareil.CHAUFFAGE);
        ma_liste_appareils.add(rad1);
        CAutre_appareil cafe = new CAutre_appareil("cafe", TypeAppareil.AUTRE_APPAREIL);
        ma_liste_appareils.add(cafe);
        CAutre_appareil hf = new CAutre_appareil("hf", TypeAppareil.AUTRE_APPAREIL);
        ma_liste_appareils.add(hf);
        CAlarme a1 = new CAlarme("a1", TypeAppareil.ALARME);
        ma_liste_appareils.add(a1);
        CEclairage e1 = new CEclairage("e1", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(e1);
        CEclairage e2 = new CEclairage("e2", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(e2);
        CEclairage e3 = new CEclairage("e3", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(e3);

        //Interfaces
        CTelecommande c1 = new CTelecommande("c1", TypeInterface.TELECOMMANDE);
        ma_liste_appareils.add(c1);
        CInterrupteur b1 = new CInterrupteur("b1", TypeInterface.INTERRUPTEUR);
        ma_liste_appareils.add(b1);
        CInterrupteur b2 = new CInterrupteur("b2", TypeInterface.INTERRUPTEUR);
        ma_liste_appareils.add(b2);
        CMobile t1 = new CMobile("t1", TypeInterface.MOBILE);
        ma_liste_appareils.add(t1);

        //Programmations
        CProgrammation p1 = new CProgrammation("soiree");
        CDate p1d1 = new CDate(2012, -1, 1, 18, 0);
        p1.addDate(p1d1);
        ma_liste_programmations.add(p1);

        CProgrammation p2 = new CProgrammation("soireeMusique");
        CDate p2d1 = new CDate(2012, 11, 20, 19, 30);
        p2.addDate(p2d1);
        CDate p2d2 = new CDate(2012, 12, 31, 23, 59);
        p2.addDate(p2d2);
        ma_liste_programmations.add(p2);

        //Associations
        t1.addScenarioAssocie("depart");
        c1.addScenarioAssocie("noel1");
        c1.addScenarioAssocie("noel2");
        c1.addScenarioAssocie("noel3");
        b1.addScenarioAssocie("bonjour");
        b2.addScenarioAssocie("depart");

        //Finalisation
        monHabitat = new HabitatSpecific(ma_liste_appareils, ma_liste_ens_appareils, ma_liste_scenarios, ma_liste_interfaces, ma_liste_programmations);
    }
}