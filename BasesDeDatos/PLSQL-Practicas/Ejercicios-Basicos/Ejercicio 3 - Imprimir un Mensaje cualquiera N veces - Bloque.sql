DECLARE
    num number;
	i number;
	texto varchar2(40); 
BEGIN
    num:=&IngreseNumeroVeces;
	texto:=&Ingresetexto;
	i:=1;
	DBMS_OUTPUT.PUT_LINE(' el mensaje se va a imprimir ' || num || ' Veces ');
	DBMS_OUTPUT.PUT_LINE(' ------------------------------------------------');
	while (i<=num) loop
		DBMS_OUTPUT.PUT_LINE(texto);
		DBMS_OUTPUT.PUT_LINE(' ');
		i:=i+1;
	end loop
END;  
/ 



 

