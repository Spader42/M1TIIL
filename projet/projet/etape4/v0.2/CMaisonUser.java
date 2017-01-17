//CMaisonUser.java

public class CMaisonUser extends CMaison {
    public CMaisonUser() {
        super();

        //Appareils
        CVoletFenetre v1 = new CVoletFenetre("v1", TypeAppareil.VOLET);
        ma_liste_appareils.add(v1);
        CEclairage e1 = new CEclairage("e1", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(e1);
        CEclairage s1 = new CEclairage("s1", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(s1);
        CEclairage s2 = new CEclairage("s2", TypeAppareil.ECLAIRAGE);
        ma_liste_appareils.add(s2);

        //Interfaces
        CInterface toutAllumer = new CInterface("toutAllumer", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(toutAllumer);
        CInterface toutEteindre = new CInterface("toutEteindre", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(toutEteindre);
        CInterface allumerSalon = new CInterface("allumerSalon", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(allumerSalon);
        CInterface ouvertureVolet = new CInterface("ouvertureVolet", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(ouvertureVolet);
        CInterface fermetureVolet = new CInterface("fermetureVolet", TypeInterface.INTERRUPTEUR);
        ma_liste_interfaces.add(fermetureVolet);

        //Scenarii
    String ouvrirVolet_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"v1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.OUVRIR);\n" + 
"";
    CScenario ouvrirVolet = new CScenario("ouvrirVolet", ouvrirVolet_contenu);
    ma_liste_scenarios.add(ouvrirVolet);
    String fermerVolet_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"v1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.FERMER);\n" + 
"";
    CScenario fermerVolet = new CScenario("fermerVolet", fermerVolet_contenu);
    ma_liste_scenarios.add(fermerVolet);
    String salon_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"s1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"s2\"))\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"";
    CScenario salon = new CScenario("salon", salon_contenu);
    ma_liste_scenarios.add(salon);
    String aurevoir_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {\n" + 
"appareil.appliquer(TypeActionAppareil.ETEINDRE);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"v1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.FERMER);\n" + 
"";
    CScenario aurevoir = new CScenario("aurevoir", aurevoir_contenu);
    ma_liste_scenarios.add(aurevoir);
    String bonjour_contenu = "for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {\n" + 
"appareil.appliquer(TypeActionAppareil.ALLUMER);\n" + 
"}\n" + 
"for(CAppareil appareil : this.l_appareils)\n" + 
"if(appareil.getNomAppareil().equals(\"v1\"))\n" + 
"appareil.appliquer(TypeActionAppareil.OUVRIR);\n" + 
"";
    CScenario bonjour = new CScenario("bonjour", bonjour_contenu);
    ma_liste_scenarios.add(bonjour);

        //Programmations
        CProgrammation p1 = new CProgrammation("ouvrirVolet");
        CDate p1d1 = new CDate(2016, 11, -1, -1, -1);
        p1.addDate(p1d1);
        ma_liste_programmations.add(p1);

        //Associations
        fermetureVolet.addScenarioAssocie("fermerVolet");
        toutAllumer.addScenarioAssocie("bonjour");
        allumerSalon.addScenarioAssocie("salon");
        ouvertureVolet.addScenarioAssocie("ouvrirVolet");
        toutEteindre.addScenarioAssocie("aurevoir");

        //Finalisation
        monHabitat = new HabitatSpecific(ma_liste_appareils, ma_liste_ens_appareils, ma_liste_scenarios, ma_liste_interfaces, ma_liste_programmations);
    }
}