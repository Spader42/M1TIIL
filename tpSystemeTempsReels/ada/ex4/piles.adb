with Text_Io;
use Text_Io;
package body Piles is

   procedure Vider is 
   begin
      Nb := 0;
   end Vider;

   function Est_Vide return Boolean is 
   begin
      return Nb = 0;
   end Est_Vide;

   function Sommet return Element is 
   begin
      if Nb = 0 then
         raise Pile_Vide;
      end if;
      return Donnees(Nb);
   end Sommet;

   procedure Empiler (
         V : in     Element ) is 
   begin
      if Nb = Taille then
         raise Pile_Pleine;
      end if;
      Nb := Nb + 1;
      Donnees(Nb) := V;
   end Empiler;

   procedure Depiler is 
   begin
      if Nb = 0 then
         raise Pile_Vide;
      end if;
      Nb:= Nb - 1;
   end Depiler;
   
   procedure Inverser is
   tmp : Element;
   begin
       for i in 1..(Nb/2) loop
           tmp := Donnees(i);
           Donnees(i) := Donnees(Nb - i + 1);
           Donnees(Nb - i + 1) := tmp; 
       end loop;
   end Inverser;
   
   procedure AfficherPile is
   Res : Element;
   begin
   for i in 1..(Nb) loop
       Res := Donnees(i);
       AfficherElement(Res);
       New_Line;
       end loop;
   end AfficherPile;
end Piles;

