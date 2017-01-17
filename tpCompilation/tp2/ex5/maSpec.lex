import java_cup.runtime.Symbol;
%%
%unicode
%cup
%line
%column

alphabet = [a-zA-Z0-9' ']
parg = ['(']
pard = [')']


%%

{alphabet} { return new Symbol(sym.STRING, new String(yytext())); }
")" { return new Symbol(sym.PARD, new Integer(1)); }
"(" { return new Symbol(sym.PARG, new Integer(1)); }
\n  { return new Symbol(sym.NEWLINE, new String(yytext())); } 
.   { return new Symbol(sym.WHATEVER, new String(yytext())); }
