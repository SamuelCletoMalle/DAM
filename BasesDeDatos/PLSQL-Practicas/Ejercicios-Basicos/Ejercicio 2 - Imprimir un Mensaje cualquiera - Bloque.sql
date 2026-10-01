DECLARE
	texto varchar2(30);
BEGIN
	texto:=&Ingresetexto;
	DBMS_OUTPUT.PUT_LINE(texto);
END;  
/ 

SET SERVEROUTPUT ON;
DECLARE
	texto varchar2(30);
BEGIN
	texto:=&Ingresetexto;
	 IF  length(texto)>10 THEN
		DBMS_OUTPUT.PUT_LINE(texto);
	ELSE
		DBMS_OUTPUT.PUT_LINE('el texto introducido es menor de 10 caracteres');
	END IF;
END;  
/


 

