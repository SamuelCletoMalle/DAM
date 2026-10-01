/*Usando obligatoriamente cursores, hacer un bloque PLSQL que
visualice el apellido, oficio y comisión de los empleados cuya
comisión es superior a 500 euros.*/
DECLARE
    -- Definir un cursor para seleccionar apellido, oficio y comisión de la tabla emple
    CURSOR datos_cursor IS
        SELECT apellido, oficio, comision FROM emple WHERE comision > 500; -- Filtrar por comisiones mayores a 500
    
    v_apellido VARCHAR2(50); -- Variable para almacenar el apellido
    v_oficio VARCHAR2(50);   -- Variable para almacenar el oficio
    v_comision NUMBER;       -- Variable para almacenar la comisión
BEGIN
    OPEN datos_cursor; -- Abrir el cursor

    LOOP
        FETCH datos_cursor INTO v_apellido, v_oficio, v_comision; -- Obtener el siguiente registro del cursor
        EXIT WHEN datos_cursor%NOTFOUND; -- Salir del bucle si no hay más registros

        -- Imprimir el apellido, oficio y comisión
        DBMS_OUTPUT.PUT_LINE('Apellido: ' || v_apellido || ', Oficio: ' || v_oficio || ', Comisión: ' || v_comision);
    END LOOP;

    CLOSE datos_cursor; -- Cerrar el cursor
END;
/