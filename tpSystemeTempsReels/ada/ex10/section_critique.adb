with Semaphores;
use Semaphores;
with text_io;
use text_io;
with Ada.Numerics.Discrete_Random;

procedure Section_Critique is
    Mutex : Semaphore;
    nb_plein, nb_vide : Semaphore;
    fifoMax : Integer := 5;
    indiceProd : Integer := 0;
    indiceConso : Integer := 0;
    fifo : array (0..fifoMax) of Integer;
    package intio is new Integer_Io(Integer);
    task type Une;
    task body Une is
    begin
        loop
            Mutex.P;
            Mutex.V;
        end loop;
    end Une;
    
    task type Afficher is
        entry Affichage;
    end Afficher;
    
    task body Afficher is
    begin
        accept Affichage do
            Put("FIFO : [");
            for i in 1..fifo'length loop
                Put(integer'Image(fifo(i))); 
            end loop;
            Put_Line("]");
        end Affichage;
    end Afficher;
    Afficheur : Afficher;
    task type Producteur is
        entry setId(data : in Integer);
    end Producteur;
    
    task body Producteur is
        id : Integer := 0;
    begin
        accept setId(data : in Integer) do
            id := data;
        end setId;
        loop    
            nb_vide.P;
            fifo(indiceProd) := 9;
            indiceProd := (indiceProd + 1) mod fifoMax;
            Put("[");
            intio.Put(id);
            Put_Line("] Je Prends");
            nb_plein.V;
            Afficheur.Affichage;
        end loop;
    end Producteur;
    
    task type Consommateur is
        entry setId(data : in Integer);
    end Consommateur;
    
    task body Consommateur is
        id : Integer := 0;
    begin
        accept setId(data : in Integer) do
            id := data;
        end setId;
        loop
            fifo(indiceConso) := 0;
            indiceConso := (indiceConso + 1) mod fifoMax;
            nb_vide.V;
            Put("[");
            intio.Put(id);
            Put_Line("] Je consomme");
            nb_plein.P;
            Afficheur.Affichage;
        end loop;
    end Consommateur;
    
    type Une_Ptr is access Une;
    Plusieurs : array (1..10) of Une_Ptr;
    maxProd : Integer := 10;
    maxConso :Integer := 5;
    type TableProd is array (1..maxProd) of Producteur;
    type TableConso is array (1..maxConso) of Consommateur;
    prod : TableProd;
    conso : TableConso;
begin
    for i in 1..fifoMax loop
   	    fifo(i):= 0;
    end loop;
    Mutex.Init(1);
    nb_vide.Init(4);
    nb_plein.Init(0);
    for i in 1..10 loop
   	    Plusieurs(i):= new Une;
    end loop;
    for i in 1..maxProd loop
   	    prod(i).setId(i);
    end loop;
    for i in 1..maxConso loop
   	    conso(i).setId(i);
    end loop;
end Section_Critique;
