%%
%class lexer
%unicode
%int
%standalone
%line
%column

%{
int nbCar = 0;
int nbMots = 0;
int nbLignes = 0;
%}

%eof{
System.out.println("Nombre de caracteres : "+nbCar);
System.out.println("Nombre de mots : "+nbMots);
System.out.println("Nombre de lignes : "+nbLignes);
System.out.println("Fin de l'annalyse lexicale");
%eof}

alphabetMin = (a|z|e|r|t|y|u|i|o|p|q|s|d|f|g|h|j|k|l|m|w|x|c|v|b|n)*
alphabetMaj = (A|Z|E|R|T|Y|U|I|O|P|Q|S|D|F|G|H|J|K|L|M|W|X|C|V|B|N)*
chiffre = (1|2|3|4|5|6|7|8|9)*

%%
{ alphabetMin } { nbCar++; }
{ alphabetMax } { nbCar++; }
{ chiffre }     { nbCar++; }
[\b]    { nbMots++; }
[\n]    { nbLignes++; }
.       { }
