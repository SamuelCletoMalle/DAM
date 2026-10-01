CREATE OR REPLACE PROCEDURE IMPRIMIR5NUMEROS
IS
    i integer;
BEGIN
	i:=1;
	DBMS_OUTPUT.PUT_LINE(' Los 5 primeros numeros son ' );
	DBMS_OUTPUT.PUT_LINE(' -------------------------- ' );
	while (i<=5) loop
		DBMS_OUTPUT.PUT_LINE(i);
		i:=i+1;
	end loop;
END;  
/ 



 

