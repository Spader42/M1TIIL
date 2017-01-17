//SPécification JFlex
import java_cup.runtime.Symbol;

%%
%unicode
%cup
%line
%column

%%
"+" { return new Symbol(sym.PLUS); }
"-" { return new Symbol(sym.MOINS); }
"/" { return new Symbol(sym.DIV); }
"*" { return new Symbol(sym.MULT); }
"(" { return new Symbol(sym.LP); }
")" { return new Symbol(sym.RP); }
[0-9]+ { return new Symbol(sym.NB, new Integer(yytext())); }

\n { return new Symbol(sym.NL); }

[/t/r/f] {}

. {}
