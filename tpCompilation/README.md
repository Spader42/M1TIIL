Pour ces TPs faire :

JFlex :

java JFlex.main <maSpec>.lex
javac lexer.java
java lexer <nomFichier>

JCup :

java JFlex.Main <maSpec>.lex
java java_cup.Main <maSpec>.cup
javac parser.java sym.java Yylex.java
java parser < <nomFichier>
