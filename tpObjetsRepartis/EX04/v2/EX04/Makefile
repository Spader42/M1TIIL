

MODULE = tpcorba/exo4
JAVA  = abonneImpl.java gestionabonnesImpl.java Serveur.java Client.java Liste.java
IDL   = server.idl

CLASS = $(JAVA:%.java=classes/$(MODULE)/%.class) 


all: subdir idl src


src:	$(CLASS)
idl:	$(IDL:.idl=.jacorb)
	



############################################
## Do not change anything after this line
############################################

classes/$(MODULE)/%.class : %.java
	javac -d classes  $<

####

.SUFFIXES:
.SUFFIXES:      .idl .jacorb

.idl.jacorb:
	idl -d generated  $<
	javac -d classes generated/$(MODULE)/*.java
	touch $*.jacorb 

####

clean::
	rm -rf core *.jacorb *.ref 
	rm -rf classes generated

####

subdir:
	if [ ! -d classes ]; then \
	   mkdir classes;  \
	fi;
	if [ ! -d generated ]; then \
	   mkdir generated;  \
	fi;


