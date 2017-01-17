import java_cup.runtime.Symbol;

%%
%unicode
%cup
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

//Autre appareils
autre_appareil  = "autre_appareil"
tv              = "tv"
hifi            = "hifi"
cafetiere       = "cafetiere"
video_proj      = "video_proj"
lave_vaisselle  = "lave_vaisselle"
lave_linge      = "lave_linge"
seche_linge     = "seche_linge"
ordinateur      = "ordinateur"
portail         = "portail"

//Interfaces
interrupteur    = "interrupteur"
mobile          = "mobile"
telephone       = "telephone"
telecommande    = "telecommande"
tablette        = "tablette"

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
ident       = [a-zA-Z_]+[a-zA-Z0-9_]*
espace      = " " | \t
finligne    = "\n"

erreur_ident    = [0-9]+[a-zA-Z]+
erreur_chaine   = \"[^\"\n]*\n

%%
{chaine}            { return new Symbol(sym.CHAINE, new String(yytext())); }

//Appareils
{eclairage}         { return new Symbol(sym.ECLAIRAGE); }
{volet}             { return new Symbol(sym.VOLET); }
{chauffage}         { return new Symbol(sym.CHAUFFAGE); }
{alarme}            { return new Symbol(sym.ALARME); }
{fenetre}           { return new Symbol(sym.FENETRE); }


//Interface
{interrupteur}      { return new Symbol(sym.INTERRUPTEUR); }
{mobile}            { return new Symbol(sym.MOBILE); }
{telephone}         { return new Symbol(sym.TELEPHONE); }
{telecommande}      { return new Symbol(sym.TELECOMMANDE); }
{tablette}          { return new Symbol(sym.TABLETTE); }

//Autre appareils
{autre_appareil}    { return new Symbol(sym.AUTRE_APPAREIL); }
{tv}                { return new Symbol(sym.TV); }
{hifi}              { return new Symbol(sym.HIFI); }
{cafetiere}         { return new Symbol(sym.CAFETIERE); }
{video_proj}        { return new Symbol(sym.VIDEO_PROJ); }
{lave_vaisselle}    { return new Symbol(sym.LAVE_VAISSELLE); }
{lave_linge}        { return new Symbol(sym.LAVE_LINGE); }
{seche_linge}       { return new Symbol(sym.SECHE_LINGE); }
{ordinateur}        { return new Symbol(sym.ORDINATEUR); }
{portail}           { return new Symbol(sym.PORTAIL); }

//Etats appareils
{allume}    { return new Symbol(sym.ALLUME); }
{eteint}    { return new Symbol(sym.ETEINT); }
{demi}      { return new Symbol(sym.DEMI); }
{eco}       { return new Symbol(sym.ECO); }
{ouvert}    { return new Symbol(sym.OUVERT); }
{ferme}     { return new Symbol(sym.FERME); }

//Methodes appareils
{ouvrir}            { return new Symbol(sym.OUVRIR); }
{fermer}            { return new Symbol(sym.FERMER); }
{eteindre}          { return new Symbol(sym.ETEINDRE); }
{allumer}           { return new Symbol(sym.ALLUMER); }
{tamiser}           { return new Symbol(sym.TAMISER); }
{etat}              { return new Symbol(sym.ETAT); }
{allumer_partiel}   { return new Symbol(sym.ALLUMER_PARTIEL); }
{allumer_eco}       { return new Symbol(sym.ALLUMER_ECO); }
{ouvrir_partiel}    { return new Symbol(sym.OUVRIR_PARTIEL); }
{fermer_partiel}    { return new Symbol(sym.FERMER_PARTIEL); }

//Instructions
{pourtout}  { return new Symbol(sym.POURTOUT); }
{faire}     { return new Symbol(sym.FAIRE); }
{fait}      { return new Symbol(sym.FAIT); }
{si}        { return new Symbol(sym.SI); }
{alors}     { return new Symbol(sym.ALORS); }
{sinon}     { return new Symbol(sym.SINON); }
{fsi}       { return new Symbol(sym.FSI); }

//Fonctions DOMUS
{definir}               { return new Symbol(sym.DEFINIR); }
{executer_scenario}     { return new Symbol(sym.EXECUTER_SCENARIO); }
{associer}              { return new Symbol(sym.ASSOCIER); }
{programmer}            { return new Symbol(sym.PROGRAMMER); }
{message}               { return new Symbol(sym.MESSAGE); }

//Balises MODUS
{PROGRAMME_DOMUS}           { return new Symbol(sym.PROGRAMME_DOMUS); }
{DECLARATION_APPAREILS}     { return new Symbol(sym.DECLARATION_APPAREILS); }
{DECLARATION_INTERFACES}    { return new Symbol(sym.DECLARATION_INTERFACES); }
{DECLARATION_SCENARII}      { return new Symbol(sym.DECLARATION_SCENARII); }
{DECLARATION_COMMANDES}     { return new Symbol(sym.DECLARATION_COMMANDES); }
{SCENARIO}                  { return new Symbol(sym.SCENARIO); }

//Operateurs
{commentaire}       { }
{par_gauche}        { return new Symbol(sym.PAR_GAUCHE); }
{par_droite}        { return new Symbol(sym.PAR_DROITE); }
{aco_gauche}        { return new Symbol(sym.ACO_GAUCHE); }
{ACO_DROITE}        { return new Symbol(sym.ACO_DROITE); }
{affectation}       { return new Symbol(sym.AFFECTATION); }
{egalite}           { return new Symbol(sym.EGALITE); }
{point_virgule}     { return new Symbol(sym.POINT_VIRGULE); }
{chevron_gauche}    { return new Symbol(sym.CHEVRON_GAUCHE); }
{chevron_droit}     { return new Symbol(sym.CHEVRON_DROIT); }
{slash}             { return new Symbol(sym.SLASH); }
{underscore}        { return new Symbol(sym.UNDERSCORE); }
{point}             { return new Symbol(sym.POINT); }
{virgule}           { return new Symbol(sym.VIRGULE); }
{deux_point}        { return new Symbol(sym.DEUX_POINT); }

// qqs exemples de règles lexicales légales...
{entier}    { return new Symbol(sym.ENTIER, new Integer(yytext())); }
{ident}     { return new Symbol(sym.IDENTIFIANT, new String(yytext())); }
{espace}    { }
{finligne}  { } 


//qqs exemples de règles de détection d'erreurs lexicales...
{erreur_ident}  { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => syntaxe identificateur non respectee ! "); }

{erreur_chaine} { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => fin de chaine attendue ! "); }

. { System.out.println("Erreur ligne "+(yyline+1)+" colonne "+(yycolumn+1)+" : "+yytext()+" => caractÃšre inconnu ! "); } 

