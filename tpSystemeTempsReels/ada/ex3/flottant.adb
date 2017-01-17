
with Text_Io;
use Text_Io;

with mes_io;
use mes_io;

procedure Flottant is
    max     : float;
    min     : float;
    somme   : float := 0.0;
    curr    : float;
    n       : float := 0.0;
begin
     loop
        Text_Io.Put_Line("Entrez un flottant :");
        floatio.Get(curr);
        if somme = 0.0
            then    somme   := curr;
                    max     := curr;
                    min     := curr;
            else    somme   := somme + curr;
        end if;
        
        if curr = 0.0
            then    Put("Nombre total : ");
                    floatio.Put(somme);
                    New_Line;
                    somme := somme / n;
                    Put("Nombre de flottants rentrés : ");
                    floatio.Put(n);
                    New_Line;
                    Put("Moyenne : ");
                    floatio.Put(somme);
                    New_Line; 
                    Put("Max : ");
                    floatio.Put(max);
                    New_Line;
                    Put("Min : ");
                    floatio.Put(min);
                    New_Line;
        end if;
        
        if curr > max
            then max := curr;
        end if;
        
        if curr < min
            then min := curr;
        end if;
              
        n := n + 1.0;
        exit when curr = 0.0;
     end loop;
end Flottant;
