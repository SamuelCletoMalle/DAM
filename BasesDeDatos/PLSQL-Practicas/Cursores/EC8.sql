/*Codificar un bloque pl/sql usando cursores que permita
actualizar la comisión de los empleados con arreglo a las
siguientes premisas:
A los empleados cuyo salario esté entre 0 y 1000 la
comisión será de 200.
A los empleados cuyo salario esté entre 1001 y 2500 la
comisión será 300.
A los empleados cuyo salario sea mayor que 2500 la
comisión será 400.*/
DECLARE
    CURSOR actualiz_cursor IS
        SELECT salario FROM emple
        FOR UPDATE;  -- Permitir la actualización de las filas seleccionadas
    v_salario NUMBER;
BEGIN
    OPEN actualiz_cursor;
    LOOP
        FETCH actualiz_cursor INTO v_salario;
        EXIT WHEN actualiz_cursor%NOTFOUND;  -- Salir del bucle si no hay más filas

        -- Actualizar el salario según el rango
        IF v_salario BETWEEN 0 AND 1000 THEN
            UPDATE emple
            SET salario = v_salario + 200  -- Actualizar el salario en la tabla
            WHERE CURRENT OF actualiz_cursor;  -- Actualizar la fila actual del cursor
        ELSIF v_salario BETWEEN 1001 AND 2500 THEN
            UPDATE emple
            SET salario = v_salario + 300
            WHERE CURRENT OF actualiz_cursor;  -- Actualizar la fila actual del cursor
        ELSE 
            UPDATE emple
            SET salario = v_salario + 400
            WHERE CURRENT OF actualiz_cursor;  -- Actualizar la fila actual del cursor
        END IF;  -- Cerrar la estructura IF
    END LOOP;
    CLOSE actualiz_cursor;  -- Cerrar el cursor
END;