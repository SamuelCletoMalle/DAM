CREATE OR REPLACE PROCEDURE ImprimirMensaje
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE(' HOLA ');
END;
/
 
Para ejecutar el procedimiento poner:

EXECUTE ImprimirMensaje; 
