# Makefile by Romain Le Moigne.
# Pour le mini projet de compilation,
# de la pomotion 2016-2017 de M1 TIIL, UBO brest.

SOURCE=./#Répertoire dans lequel se trouvent les fichiers .lex et .cup.
BIN=./#Répertoire dans lequel seront présents les fichiers .class et .java.

JAVA=java
JAVAC=javac -d $(BIN)
JFLEX=$(JAVA) JFlex.Main -d $(BIN)
JCUP=$(JAVA) java_cup.Main

LEXNAME=projet.lex#Nom du fichier .lex
CUPNAME=projet.cup#Nom du fichier .cup

#Compilation du parser et du lexer à partir des fichiers générés par jFlex et JCup.
compilation: JFlexGeneration JCupGeneration
	@echo " /=====================================\\"
	@echo "|   Compilation du parser et du lexer   |"
	@echo " \\=====================================/"
	$(JAVAC) $(BIN)parser.java $(BIN)sym.java $(BIN)Yylex.java

#Compilation de la spécification JFlex avec JFlex.
JFlexGeneration: $(SOURCE)$(LEXNAME)
	@echo " /=========================================\\"
	@echo "|   Compilation de la spécification JFlex   |"
	@echo " \\=========================================/"
	$(JFLEX) $(SOURCE)$(LEXNAME)

#Génération du programme d'analyse syntaxique avec JCup, puis déplacement des fichiers générés
#vers le dossier bin car JCup ne gère pas la redirection des fichiers générés.
JCupGeneration: $(SOURCE)$(CUPNAME)
	@echo " /================================================\\"
	@echo "|   Génération du programme d'analyse syntaxique   |"
	@echo " \\================================================/"
	$(JCUP) $(SOURCE)$(CUPNAME)

#Suppression de tous les fichiers dans le dossier bin.
clean:
	@echo " /=============================\\"
	@echo "|   Suppression des fichiers   |"
	@echo " \\============================/"
	rm -f $(BIN)*.class
	rm -f $(BIN)*.java
