%%
%class lexer
%unicode
%int
%standalone
%line
%column

%{
	public int getYyLine(){
		return yyline+1;
	}
	public int getYyColumn(){
		return yycolumn+1;
	}
	public String getYyText(){
		return yytext();
	}
%}

//Appareils
eclairage       = "eclairage"
volet           = "volet"
chauffage       = "chauffage"
alarme          = "alarme"
fenetre         = "fenetre"
autre_appareil  = "autre_appareil"
interrupteur    = "interrupteur"
mobile          = "mobile"
telephone       = "telephone"
telecommande    = "telecommande"
tablette        = "tablette"
tv              = "tv"
hifi            = "hifi"
cafetiere       = "cafetiere"
video_proj      = "video_proj"
lave_vaisselle  = "lave_vaisselle"
lave_linge      = "lave_linge"
seche_linge     = "seche_linge"
ordinateur      = "ordinateur"
portail         = "portail"

//Etats appareils
allume  = "allume"
eteint  = "eteint"
demi    = "demi"
eco     = "eco"
ouvert  = "ouvert"
ferme   = "ferme"

//Methodes appareils
ouvrir          = "ouvrir"
fermer          = "fermer"
eteindre        = "eteindre"
allumer         = "allumer"
tamiser         = "tamiser"
etat            = "etat"
allumer_partiel = "allumer_partiel"
allumer_eco     = "allumer_eco"
ouvrir_partiel  = "ouvrir_partiel"
fermer_partiel  = "fermer_partiel"

//Instructions
pourtout    = "pourtout"
faire       = "faire"
fait        = "fait"
si          = "si"
alors       = "alors"
sinon       = "sinon"
fsi         = "fsi"

//Fonctions DOMUS
definir             = "definir"
executer_scenario   = "executer_scenario"
associer            = "associer"
programmer          = "programmer"
message             = "message"

//Balises MODUS
PROGRAMME_DOMUS         = "PROGRAMME_DOMUS"
DECLARATION_APPAREILS   = "DECLARATION_APPAREILS"
DECLARATION_INTERFACES  = "DECLARATION_INTERFACES"
DECLARATION_SCENARII    = "DECLARATION_SCENARII"
DECLARATION_COMMANDES   = "DECLARATION_COMMANDES"
SCENARIO                = "SCENARIO"

//Operateurs
commentaire     = "//".*{finligne}
par_gauche      = "("
par_droite      = ")"
aco_gauche      = "{"
ACO_DROITE      = "}"
affectation     = "="
egalite         = {affectation}{affectation}
point_virgule    = ";"
chevron_gauche  = "<"
chevron_droit   = ">"
GUILLEMET       = "\""
slash           = "/"
underscore      = "_"
point           = "."
virgule         = ","
deux_point      = ":"

chiffre     = [0-9]
entier      = {chiffre}+
chaine      = {GUILLEMET}.*{GUILLEMET}
ident       = [a-zA-Z]+[a-zA-Z0-9]*
espace      = " "
finligne    = "\n"

erreur_ident    = [0-9]+[a-zA-Z]+
erreur_chaine   = \"[^\"\n]*\n

%%
{chaine}          { System.out.println("Reconnaissance : chaine : " + yytext() + ""); }

//Appareils
{eclairage}         { System.out.println("Reconnaissance : eclairage"); }
{volet}             { System.out.println("Reconnaissance : volet"); }
{chauffage}         { System.out.println("Reconnaissance : chauffage"); }
{alarme}            { System.out.println("Reconnaissance : alarme"); }
{fenetre}           { System.out.println("Reconnaissance : fenetre"); }
{autre_appareil}    { System.out.println("Reconnaissance : autre_appareil"); }
{interrupteur}      { System.out.println("Reconnaissance : interrupteur"); }
{mobile}            { System.out.println("Reconnaissance : mobile"); }
{telephone}         { System.out.println("Reconnaissance : telephone"); }
{telecommande}      { System.out.println("Reconnaissance : telecommande"); }
{tablette}          { System.out.println("Reconnaissance : tablette"); }
{tv}                { System.out.println("Reconnaissance : tv"); }
{hifi}              { System.out.println("Reconnaissance : hifi"); }
{cafetiere}         { System.out.println("Reconnaissance : cafetiere"); }
{video_proj}        { System.out.println("Reconnaissance : video_proj"); }
{lave_vaisselle}    { System.out.println("Reconnaissance : lave_vaisselle"); }
{lave_linge}        { System.out.println("Reconnaissance : lave_linge"); }
{seche_linge}       { System.out.println("Reconnaissance : seche_linge"); }
{ordinateur}        { System.out.println("Reconnaissance : ordinateur"); }
{portail}           { System.out.println("Reconnaissance : portail"); }

//Etats appareils
{allume}    { System.out.println("Reconnaissance : allume"); }
{eteint}    { System.out.println("Reconnaissance : eteint"); }
{demi}      { System.out.println("Reconnaissance : demi"); }
{eco}       { System.out.println("Reconnaissance : eco"); }
{ouvert}    { System.out.println("Reconnaissance : ouvert"); }
{ferme}     { System.out.println("Reconnaissance : ferme"); }

//Methodes appareils
{ouvrir}            { System.out.println("Reconnaissance : ouvrir"); }
{fermer}            { System.out.println("Reconnaissance : fermer"); }
{eteindre}          { System.out.println("Reconnaissance : eteindre"); }
{allumer}           { System.out.println("Reconnaissance : allumer"); }
{tamiser}           { System.out.println("Reconnaissance : tamiser"); }
{etat}              { System.out.println("Reconnaissance : etat"); }
{allumer_partiel}   { System.out.println("Reconnaissance : allumer_partiel"); }
{allumer_eco}       { System.out.println("Reconnaissance : allumer_eco"); }
{ouvrir_partiel}    { System.out.println("Reconnaissance : ouvrir_partiel"); }
{fermer_partiel}    { System.out.println("Reconnaissance : fermer_partiel"); }

//Instructions
{pourtout}  { System.out.println("Reconnaissance : pourtout"); }
{faire}     { System.out.println("Reconnaissance : faire"); }
{fait}      { System.out.println("Reconnaissance : fait"); }
{si}        { System.out.println("Reconnaissance : si"); }
{alors}     { System.out.println("Reconnaissance : alors"); }
{sinon}     { System.out.println("Reconnaissance : sinon"); }
{fsi}       { System.out.println("Reconnaissance : fsi"); }

//Fonctions DOMUS
{definir}               { System.out.println("Reconnaissance : definir"); }
{executer_scenario}     { System.out.println("Reconnaissance : executer_scenario"); }
{associer}              { System.out.println("Reconnaissance : associer"); }
{programmer}            { System.out.println("Reconnaissance : programmer"); }
{message}               { System.out.println("Reconnaissance : message"); }

//Balises MODUS
{PROGRAMME_DOMUS}           { System.out.println("Reconnaissance : PROGRAMME_DOMUS"); }
{DECLARATION_APPAREILS}     { System.out.println("Reconnaissance : DECLARATION_APPAREILS"); }
{DECLARATION_INTERFACES}    { System.out.println("Reconnaissance : DECLARATION_INTERFACES"); }
{DECLARATION_SCENARII}      { System.out.println("Reconnaissance : DECLARATION_SCENARII"); }
{DECLARATION_COMMANDES}     { System.out.println("Reconnaissance : DECLARATION_COMMANDES"); }
{SCENARIO}                  { System.out.println("Reconnaissance : SCENARIO"); }

//Operateurs
{commentaire}       { System.out.println("Reconnaissance : commentaire : \"" + yytext() + "\""); }
{par_gauche}        { System.out.println("Reconnaissance : ("); }
{par_droite}        { System.out.println("Reconnaissance : )"); }
{aco_gauche}        { System.out.println("Reconnaissance : {"); }
{ACO_DROITE}        { System.out.println("Reconnaissance : }"); }
{affectation}       { System.out.println("Reconnaissance : ="); }
{egalite}           { System.out.println("Reconnaissance : =="); }
{point_virgule}     { System.out.println("Reconnaissance : ;"); }
{chevron_gauche}    { System.out.println("Reconnaissance : <"); }
{chevron_droit}     { System.out.println("Reconnaissance : >"); }
{slash}             { System.out.println("Reconnaissance : /"); }
{underscore}        { System.out.println("Reconnaissance : _"); }
{point}             { System.out.println("Reconnaissance : ."); }
{virgule}           { System.out.println("Reconnaissance : ,"); }
{deux_point}        { System.out.println("Reconnaissance : :"); }

// qqs exemples de règles lexicales légales...
{entier}    { System.out.println("Reconnaissance : entier : \"" + yytext() + "\""); }
{ident}     { System.out.println("Reconnaissance : identifiant : \"" + yytext() + "\""); }
{espace}    { System.out.println("Reconnaissance : espace"); }
{finligne}  {  } 


//qqs exemples de règles de détection d'erreurs lexicales...
{erreur_ident}  { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => syntaxe identificateur non respectee ! "); }

{erreur_chaine} { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => fin de chaine attendue ! "); }

. { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => caractÃšre inconnu ! "); } 

