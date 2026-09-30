/*Hacer un bloque PLSQl que nos diga cuantos
empleados de los departamentos no ganan ni el
máximo ni el mínimo salarial de la empresa, además
especificar cuantos de ellos son VENDEDORES,
cuántos ANALISTAS, cuantos DIRECTORES y
cuantos EMPLEADOS.
Se pide hacerlo de dos formas:
1 Sin usar tablas o arrays
2 Usando tablas o arrays de modo que habrá que
crear una tabla con los 4 oficios que tiene
actualmente la tabla. Esta forma es MUCHO
MAS EFICIENTE porque si en vez 4 oficios
tenemos 30 oficios pues el código es muy muy
largo.*/

DECLARE
    v_salario_min NUMBER;      -- Variable para almacenar el salario mínimo
    v_salario_max NUMBER;      -- Variable para almacenar el salario máximo
    v_total NUMBER;            -- Variable para almacenar el total de empleados que no ganan ni el salario mínimo ni el máximo
    v_vendedores NUMBER;       -- Variable para contar el número de vendedores
    v_analistas NUMBER;        -- Variable para contar el número de analistas
    v_directores NUMBER;       -- Variable para contar el número de directores
    v_empleados NUMBER;        -- Variable para contar el número de empleados
BEGIN
    -- Obtener el salario mínimo y máximo de la tabla EMPLE
    SELECT MIN(salario), MAX(salario)
    INTO v_salario_min, v_salario_max
    FROM EMPLE;

    -- Contar el total de empleados que no ganan ni el salario mínimo ni el máximo
    SELECT COUNT(*)
    INTO v_total
    FROM EMPLE
    WHERE salario NOT IN (v_salario_min, v_salario_max);

    -- Contar el número de vendedores que no ganan ni el salario mínimo ni el máximo
    SELECT COUNT(*)
    INTO v_vendedores
    FROM EMPLE
    WHERE salario NOT IN (v_salario_min, v_salario_max)
      AND oficio = 'VENDEDOR';

    -- Contar el número de analistas que no ganan ni el salario mínimo ni el máximo
    SELECT COUNT(*)
    INTO v_analistas
    FROM EMPLE
    WHERE salario NOT IN (v_salario_min, v_salario_max)
      AND oficio = 'ANALISTA';

    -- Contar el número de directores que no ganan ni el salario mínimo ni el máximo
    SELECT COUNT(*)
    INTO v_directores
    FROM EMPLE
    WHERE salario NOT IN (v_salario_min, v_salario_max)
      AND oficio = 'DIRECTOR';

    -- Contar el número de empleados que no ganan ni el salario mínimo ni el máximo
    SELECT COUNT(*)
    INTO v_empleados
    FROM EMPLE
    WHERE salario NOT IN (v_salario_min, v_salario_max)
      AND oficio = 'EMPLEADO';

    -- Imprimir los resultados
    DBMS_OUTPUT.PUT_LINE('Total de empleados que no ganan ni el salario mínimo ni el máximo: ' || v_total);
    DBMS_OUTPUT.PUT_LINE('VENDEDORES: ' || v_vendedores);
    DBMS_OUTPUT.PUT_LINE('ANALISTAS: ' || v_analistas);
    DBMS_OUTPUT.PUT_LINE('DIRECTORES: ' || v_directores);
    DBMS_OUTPUT.PUT_LINE('EMPLEADOS: ' || v_empleados);
END;
/
