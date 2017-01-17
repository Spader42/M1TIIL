%%
%class lexer
%unicode
%int
%standalone
%line
%column

%{
int nbCarGarde = 0;
int nbCarSuppr = 0;
int nbCar = 0;
int nbLignes = 0;
%}

%eof{
System.out.println("\nNombre de caractères gardés : "+nbCarGarde);
System.out.println("Nombre de caractères supprimés: "+nbCarSuppr);
System.out.println("Nombre de caractères totals : "+nbCar);

%eof}

caractereAGarder = [a-zA-Z]

%%
[\n] { nbCar += yylength(); nbCarSuppr += yylength();}
{ caractereAGarder }+ { nbCar += yylength(); nbCarGarde += yylength(); System.out.print(yytext());}
.       { nbCar += yylength(); nbCarSuppr += yylength();}
