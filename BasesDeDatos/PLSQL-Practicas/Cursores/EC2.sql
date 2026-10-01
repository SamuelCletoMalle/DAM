/*Usando obligatoriamente cursores, hacer un bloque PLSQL que visualice el
nombre y localidad de todos los departamentos de la tabla DEPART.*/

DECLARE
    -- Definir un cursor para seleccionar el nombre y la localidad de los departamentos
    CURSOR dept_cursor IS
        SELECT dnombre, loc FROM depart;
    
    v_dnombre VARCHAR2(50); -- Variable para almacenar el nombre del departamento
    v_loc VARCHAR2(50);     -- Variable para almacenar la localidad del departamento
BEGIN
    OPEN dept_cursor; -- Abrir el cursor

    LOOP
        FETCH dept_cursor INTO v_dnombre, v_loc; -- Obtener el siguiente registro del cursor
        EXIT WHEN dept_cursor%NOTFOUND; -- Salir del bucle si no hay más registros

        -- Imprimir el nombre y la localidad del departamento
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_dnombre || ', Localidad: ' || v_loc);
    END LOOP;

    CLOSE dept_cursor; -- Cerrar el cursor
END;
/