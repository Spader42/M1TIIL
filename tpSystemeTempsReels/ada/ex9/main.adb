with Text_Io;
use Text_Io;

procedure Main is
    maxStation : Integer := 3;
    package intio is new Integer_Io(Integer);
    value : Integer := 0;
    task type Station is
        entry Numero (
            Num : in Integer );
        entry Recevoir_Message (
            Msg : in Integer );
    end Station;
    task body Station is
        id : Integer := 0;
    begin
        accept Numero(Num : in Integer) do
            id := Num;
        end Numero;
        loop
            accept Recevoir_Message(Msg: in Integer) do
                Put("[");
                intio.Put(id);
                Put("] J'ai reçu : ");
                intio.Put(Msg);
                New_Line;
            end Recevoir_Message;
        end loop;
    end Station;
    type TableStation is array (1..maxStation) of Station;
    taskStation : TableStation;
begin
    for i in 1..maxStation loop
        taskStation(i).Numero(i);
    end loop;
    loop
        Put("Entrez un nombre : ");
        intio.Get(value);
        for i in 1..maxStation loop
            taskStation(i).Recevoir_Message(value);
        end loop;
        New_Line;
    end loop;
end Main;
