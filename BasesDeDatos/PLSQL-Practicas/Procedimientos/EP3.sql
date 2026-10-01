/*Crear un bloque PL/SQL que nos muestre el número más alto de la tabla DEPART
de modo que si ese número de departamento es menor de 20 indicar un mensaje
diciendo DEPARTAMENTO BAJO, si está entre 20 y 30 indicar un mensaje
diciendo DEPARTAMENTO MEDIO y si es mayor o igual a 40 indicar.*/
-- Activar la salida del servidor para poder ver los resultados de DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- Bloque anónimo para encontrar el número máximo de departamento y clasificarlo
DECLARE
    MAXIMODEPARTAMENTO NUMBER;  -- Variable para almacenar el número máximo de departamento
BEGIN
    -- Seleccionar el número máximo de departamento de la tabla DEPART
    SELECT MAX(DEPT_NO) INTO MAXIMODEPARTAMENTO FROM DEPART;

    -- Imprimir el número máximo de departamento
    DBMS_OUTPUT.PUT_LINE('Mayor Número de departamento: ' || MAXIMODEPARTAMENTO);

    -- Clasificar el número máximo de departamento
    IF (MAXIMODEPARTAMENTO < 20) THEN
        DBMS_OUTPUT.PUT_LINE('DEPARTAMENTO BAJO');
    ELSIF (MAXIMODEPARTAMENTO >= 20 AND MAXIMODEPARTAMENTO < 30) THEN
        DBMS_OUTPUT.PUT_LINE('DEPARTAMENTO MEDIO');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('DEPARTAMENTO ALTO');
    END IF;
END;
/