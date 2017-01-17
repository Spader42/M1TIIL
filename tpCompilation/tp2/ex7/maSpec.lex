import java_cup.runtime.Symbol;
%%
%unicode
%cup
%line
%column

chiffre = [0-9]
entier = {chiffre}+
float = {chiffre}+\.{chiffre}+
type = ["int""float""double""boolean"]
commentaire = "//".*~\n
chaine = \*[]
%%

{chiffre}+ { return new Symbol(sym.ENTIER, new Integer(yytext())); }
\n {}
.  {}
