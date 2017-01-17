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

caractere = [a-zA-Z0-9]

%%
{ caractere }+ { nbMots++; nbCar += yylength(); }
[\n] { nbLignes++; }
.       { }
