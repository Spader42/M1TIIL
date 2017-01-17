import java_cup.runtime.Symbol;
%%
%unicode
%cup
%line
%column

alphabet = [a-zA-Z]

%%

{alphabet} { return new Symbol(sym.STRING, new String(yytext())); }
\n {}
.  {}
