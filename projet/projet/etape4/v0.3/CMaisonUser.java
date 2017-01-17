//CMaisonUser.java

public class CMaisonUser extends CMaison {
    public CMaisonUser() {
        super();

        //Appareils
        CVoletFenetre v1 = new CVoletFenetre("v1", TypeAppareil.VOLET);
        ma_liste_appareils.add(v1);
        CVoletFenetre v2 = new CVoletFenetre("v2", TypeAppareil.VOLET);
        ma_liste_appareils.add(v2);
        CVoletFenetre v3 = new CVoletFenetre("v3", TypeAppareil.VOLET);
        ma_liste_appareils.add(v3);
        CVoletFenetre v4 = new CVoletFenetre("v4", TypeAppareil.VOLET);
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
        CInterface c1 = new CInterface("c1", TypeInterface.TELECOMMANDE);
        ma_liste_interfaces.add(c1);
        CInterface b1 = new CInterface("b1", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(b1);
        CInterface b2 = new CInterface("b2", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(b2);
        CInterface t1 = new CInterface("t1", TypeInterface.MOBILE);
        ma_liste_interfaces.add(t1);

        //Scenarii
    String soiree_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {\n" + 
"appareil.appliquer(TypeActionAppareil.FERMER);\n" + 
"}\n" + 
"";
    CScenario soiree = new CScenario("soiree", soiree_contenu);
    ma_liste_scenarios.add(soiree);
    String depart_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {\n" + 
"appareil.appliquer(TypeActionAppareil.FERMER);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {\n" + 
"appareil.appliquer(TypeActionAppareil.ETEINDRE);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"fen\"))\n" + 
"if(appareil.etatAppareil.equals(TypeEtatAppareil.FERME)) {\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"}\n" + 
"else {\n" + 
"appareil.appliquer(TypeActionAppareil.ETEINDRE);\n" + 
"}\n" + 
"";
    CScenario depart = new CScenario("depart", depart_contenu);
    ma_liste_scenarios.add(depart);
    String bonjour_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.VOLET)) {\n" + 
"appareil.appliquer(TypeActionAppareil.OUVRIR);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"a1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ETEINDRE);\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"cafe\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"rad1\"))\n" + 
"if(appareil.etatAppareil.equals(TypeEtatAppareil.ETEINT)) {\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"hf\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"";
    CScenario bonjour = new CScenario("bonjour", bonjour_contenu);
    ma_liste_scenarios.add(bonjour);
    String noel3_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"e3\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"";
    CScenario noel3 = new CScenario("noel3", noel3_contenu);
    ma_liste_scenarios.add(noel3);
    String noel2_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"e2\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"";
    CScenario noel2 = new CScenario("noel2", noel2_contenu);
    ma_liste_scenarios.add(noel2);
    String noel1_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"e1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"";
    CScenario noel1 = new CScenario("noel1", noel1_contenu);
    ma_liste_scenarios.add(noel1);

        //Programmations
        CProgrammation p1 = new CProgrammation("soiree");
        CDate p1d1 = new CDate(2012, -1, 1, 18, 0);
        p1.addDate(p1d1);
        ma_liste_programmations.add(p1);

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