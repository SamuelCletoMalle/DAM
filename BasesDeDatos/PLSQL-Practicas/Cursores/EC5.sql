/*Usando obligatoriamente un cursor, escribir un bloque PLSQL que visualice el apellido y la
fecha de alta de todos los empleados ordenados por fecha de alta */
DECLARE
    CURSOR fechas_cursor IS
        SELECT apellido, fecha_alt
        FROM emple
        ORDER BY fecha_alt DESC; -- Seleccionar apellidos y fechas de alta, ordenados por fecha de alta de forma descendente
    
    v_apellido VARCHAR2(50); -- Variable para almacenar el apellido
    v_fecha DATE;            -- Variable para almacenar la fecha de alta
BEGIN
    OPEN fechas_cursor; -- Abrir el cursor

    LOOP
        FETCH fechas_cursor INTO v_apellido, v_fecha; -- Obtener el siguiente registro del cursor
        EXIT WHEN fechas_cursor%NOTFOUND; -- Salir del bucle si no hay más registros

        -- Imprimir el apellido y la fecha de alta
        DBMS_OUTPUT.PUT_LINE('Apellido: ' || v_apellido || ', Fecha: ' || TO_CHAR(v_fecha, 'DD-MON-YYYY')); 
        -- Convertir la fecha a un formato legible
    END LOOP;

    CLOSE fechas_cursor; -- Cerrar el cursor
END;
/