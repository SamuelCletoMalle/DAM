/*Realizar una función PLSQL llamado MAYOR(numero1,numero2,numero3) que calcule el
mayor de los tres números introducidos por parámetro. Hacer el programa principal que
pruebe la función anterior.*/
-- Crear o reemplazar la función MAYOR
CREATE OR REPLACE FUNCTION MAYOR(
    A  NUMBER,
    B  NUMBER,
    C  NUMBER
) RETURN NUMBER
IS
    mayornum NUMBER;  -- Variable para almacenar el número mayor
BEGIN
    -- Comparar los números para encontrar el mayor
    IF A > B THEN
        mayornum := A;
        IF A > C THEN
            mayornum := A;
        ELSE 
            mayornum := C;
        END IF;   
    ELSE 
        mayornum := B;
        IF B > C THEN
            mayornum := B;
        ELSE 
            mayornum := C;
        END IF; 
    END IF;

    RETURN mayornum;  -- Devolver el número mayor
END MAYOR;
/

-- Activar la salida del servidor para poder ver los resultados de DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- Bloque anónimo para llamar a la función MAYOR
DECLARE
    numero NUMBER;  -- Variable para almacenar el resultado
    A NUMBER;       -- Variable para el primer número
    B NUMBER;       -- Variable para el segundo número
    C NUMBER;       -- Variable para el tercer número
BEGIN
    A := &IntroduceNumero1;  -- Solicitar el primer número al usuario
    B := &IntroduceNumero2;  -- Solicitar el segundo número al usuario
    C := &IntroduceNumero3;  -- Solicitar el tercer número al usuario

    -- Llamar a la función MAYOR con los números ingresados
    numero := MAYOR(A, B, C);  

    -- Imprimir el resultado
    DBMS_OUTPUT.PUT_LINE('El mayor entre ' || A || ', ' || B || ' y ' || C || ' es: ' || numero);
END;
/

