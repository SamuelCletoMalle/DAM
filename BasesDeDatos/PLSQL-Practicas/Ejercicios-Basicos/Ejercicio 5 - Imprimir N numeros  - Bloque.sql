DECLARE
    i integer;
	num number;
BEGIN
	num:=&IntroduceelNumero;
	i:=1;
	DBMS_OUTPUT.PUT_LINE(' Los ' || num ||' primeros numeros son ' );
	DBMS_OUTPUT.PUT_LINE(' ------------------------------------- ' );
	while (i<=num) loop
		DBMS_OUTPUT.PUT_LINE(i);
		i:=i+1;
	end loop;
END;  
/ 



 

