%%
%class lexer
%unicode
%int
%standalone
%line
%column

%{
int nb = 0;
%}

%eof{
System.out.println("Nombre de caracteres ignores : "+nb);
System.out.println("Fin de l'annalyse lexicale");
%eof}

pairpair = (aa|bb)*((ab|ba)(aa|bb)*(ab|ba)(aa|bb)*)*

%%
a*b* { System.out.println("Que de a, ou que des b, ou des a d'abord et des b ensuite : "+yytext()); }
{pairpair} { System.out.println("Nombre de pair de a et de b : "+yytext()); }
[\n]    {}
.       { nb++; }
(0|1)+ { System.out.println("Un nombre binaire : "+yytext()); }
