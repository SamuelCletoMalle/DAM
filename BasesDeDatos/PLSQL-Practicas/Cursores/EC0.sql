 DECLARE
CURSOR cur1 IS
SELECT dnombre, loc FROM depart WHERE loc='MADRID';
v_nombre VARCHAR2 (14);
v_localidad VARCHAR2 (14);
 BEGIN
OPEN cur1;
FETCH cur1 INTO v_nombre, v_localidad;
WHILE cur1%FOUND LOOP
DBMS_OUTPUT.PUT_LINE (' Nombre ');
DBMS_OUTPUT.PUT_LINE (v_nombre);
DBMS_OUTPUT.PUT_LINE (' ');
DBMS_OUTPUT.PUT_LINE (' Localidad ');
DBMS_OUTPUT.PUT_LINE (v_localidad);
FETCH cur1 INTO v_nombre, v_localidad;
END LOOP;
CLOSE cur1;
END;

