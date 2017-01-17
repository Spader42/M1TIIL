with Text_Io;
use Text_Io;

procedure Lire_int is 

   i : integer := 0;
   package int_io is new Text_Io.Integer_Io(Integer);

begin

   Put_Line("saisir un entier : ");
   int_io.Get(i);
   int_io.Put(i);

end Lire_int;



