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

DECLARE
    TYPE t_oficio_tabla IS TABLE OF VARCHAR2(50) INDEX BY PLS_INTEGER;  -- Tipo de tabla asociativa para oficios
    TYPE t_conteo_tabla IS TABLE OF NUMBER INDEX BY PLS_INTEGER;         -- Tipo de tabla asociativa para conteos

    v_oficios t_oficio_tabla;      -- Variable para almacenar los oficios
    v_conteos t_conteo_tabla;      -- Variable para almacenar los conteos de empleados por oficio

    v_salario_min NUMBER;          -- Variable para almacenar el salario mínimo
    v_salario_max NUMBER;          -- Variable para almacenar el salario máximo
    v_total NUMBER;                -- Variable para almacenar el total de empleados que no ganan ni el salario mínimo ni el máximo
    i PLS_INTEGER;                 -- Variable para iterar sobre los oficios
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

    -- Imprimir el total de empleados
    DBMS_OUTPUT.PUT_LINE('Total de empleados que no ganan ni el salario mínimo ni el máximo: ' || v_total);

    -- Inicializar la tabla con los oficios
    v_oficios(1) := 'VENDEDOR';
    v_oficios(2) := 'ANALISTA';
    v_oficios(3) := 'DIRECTOR';
    v_oficios(4) := 'EMPLEADO';

    -- Iterar sobre los oficios y contar los empleados para cada uno
    i := v_of