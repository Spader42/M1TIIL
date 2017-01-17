with Text_Io;
use Text_Io;

procedure Tache is
    package intio is new Integer_Io(Integer);
    task type element is
        entry setId(data : in Integer);
    end element;
    task body element is
        id : Integer := 0;
    begin
        accept setId(data : in Integer) do
            id := data;
        end setId;
        while True loop
            Put("Je suis : ");
            intio.Put(id);
            New_Line;
            delay 1.0;
        end loop;
    end element;
    id : Integer := 0;
    idMax : Integer := 10;
    type TableElement is array (1..idMax) of element;
    taskElement : TableElement;
begin
    for i in 1..idMax loop
        taskElement(i).setId(i);
    end loop;
end Tache;
