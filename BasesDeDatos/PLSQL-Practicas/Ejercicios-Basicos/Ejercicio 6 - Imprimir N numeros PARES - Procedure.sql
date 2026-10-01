create or replace 
PROCEDURE imprimirpares (n integer)
is
   i integer; 
begin  
    i:=0;
    while i<=n loop
       if mod(i,2)=0
          then DBMS_OUTPUT.PUT_LINE(' NUMERO ' || i );
       end if;
       i:=i+1;
    end loop;
end;



 

