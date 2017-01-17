
setenv CORBA_HOME /home/commun_depinfo/enseignants/singhoff/JACORB/

setenv ANT_HOME $CORBA_HOME/apache-ant-1.6.5
setenv JAVA_HOME $CORBA_HOME/jdk1.6.0_21
setenv JACORB_HOME $CORBA_HOME/JacORB

setenv JAVA_CMD java

setenv PATH $ANT_HOME/bin:$JAVA_HOME/bin:$PATH
setenv PATH $JACORB_HOME/bin:$JACORB_HOME/etc:$JACORB_HOME/lib:$JACORB_HOME/classes:$JACORB_HOME/src:$PATH

setenv CLASSPATH $JACORB_HOME/classes:$JACORB_HOME/lib:$ANT_HOME/lib:$JAVA_HOME/lib:.:classes

setenv LD_LIBRARY_PATH $CORBA_HOME/libs
setenv LD_LIBRARY_PATH $JACORB_HOME/libs








