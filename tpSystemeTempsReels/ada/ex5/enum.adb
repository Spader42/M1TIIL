with Text_Io;
use Text_Io;

procedure Enum is
    type commandes is (a_droite, a_gauche, avancer, reculer);
    nbError : Integer := 0;
    nbErrorMax : Integer := 5;
    data    : commandes;
    COMMANDE_UTILISATEUR : exception;
    package enumio is new Text_Io.Enumeration_Io(commandes);
    package intio is new Integer_Io(Integer);
    procedure main is
    begin
        loop
            Put_Line("Entrez une commande :");
            if nbError = 5
                then
                    raise COMMANDE_UTILISATEUR;
            end if;
            enumio.Get(data);
        end loop;
    exception
        when DATA_ERROR =>  
            nbError := nbError + 1;
            Put("DATA_ERROR : ");
            intio.Put(nbError);
            New_Line;
            main;
        when COMMANDE_UTILISATEUR => 
            Put_Line("COMMANDE_UTILISATEUR");
        when others =>
            Put_Line("RANDOM_ERROR");
    end main;
begin
    main;
end Enum;
