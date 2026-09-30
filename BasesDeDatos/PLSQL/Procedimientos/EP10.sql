/*Se trata de mejorar la versión 1 de modo que hay crear un bloque PL/SQL
que cambie el STOCK de todos los productos a 20, entre un valor mínimo
y un valor máximo aplicando el valor MINIMO y MAXIMO al precio por
unidad.*/
DECLARE
    v_minimo NUMBER;  -- Declaración de una variable para almacenar el precio mínimo
    v_maximo NUMBER;  -- Declaración de una variable para almacenar el precio máximo
BEGIN
    -- Selecciona el precio mínimo de la columna LINEA_PRECIO_UNI de la tabla productos
    SELECT MIN(LINEA_PRECIO_UNI) INTO v_minimo FROM productos;

    -- Selecciona el precio máximo de la columna LINEA_PRECIO_UNI de la tabla productos
    SELECT MAX(LINEA_PRECIO_UNI) INTO v_maximo FROM productos;

    -- Actualiza el stock de los productos cuyo precio está entre el mínimo y el máximo
    UPDATE productos
    SET stock = 20
    WHERE LINEA_PRECIO_UNI BETWEEN v_minimo AND v_maximo;

    -- Imprime un mensaje en la consola indicando que el stock ha sido actualizado
    DBMS_OUTPUT.PUT_LINE('El stock de los productos entre ' || v_minimo || ' y ' || v_maximo || ' ha sido actualizado a 20.');
END;
/
