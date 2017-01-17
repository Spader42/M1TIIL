import java_cup.runtime.Symbol;
%%
%unicode
%cup
%line
%column

parasite = pr[s]+[t]+ | PR[S]+[T]+

%%

{parasite} { return new Symbol(sym.STRING, new String(yytext())); }
\n {}
.  {}
