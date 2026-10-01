-- Insertar un libro en la tabla libros con un precio de 30.80
insert into libros values(250, 'El experto en laberintos', 'Gaskin', 'Emece', 30.80, 200);

-- Intentar insertar un libro en la tabla libros con un precio de 52.80
insert into libros values(250, 'El experto en laberintos', 'Gaskin', 'Emece', 52.80, 200);

-- Crear o reemplazar un trigger llamado auditor_libros_precio
CREATE OR REPLACE TRIGGER auditor_libros_precio
    BEFORE UPDATE OR INSERT ON libros -- Se activa antes de una actualización o inserción en la tabla libros
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
BEGIN
    -- Comprobar si el nuevo precio es mayor que 50
    IF :NEW.precio > 50 THEN
        -- Si es mayor, redondear el nuevo precio
        :NEW.PRECIO := ROUND(:NEW.PRECIO); -- Redondear el precio al entero más cercano
        DBMS_OUTPUT.PUT_LINE('EL PRECIO SE HA REDONDEADO'); -- Mensaje de salida
    ELSE
        DBMS_OUTPUT.PUT_LINE('EL PRECIO NO SE HA REDONDEADO'); -- Mensaje de salida
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/

-- Crear o reemplazar un trigger llamado auditor_libros_precio_raise
CREATE OR REPLACE TRIGGER auditor_libros_precio_raise
    BEFORE UPDATE OR INSERT ON libros -- Se activa antes de una actualización o inserción en la tabla libros
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
BEGIN
    -- Comprobar si el nuevo precio es mayor que 50
    IF :NEW.precio > 50 THEN
        -- Si es mayor, redondear el nuevo precio
        :NEW.PRECIO := ROUND(:NEW.PRECIO); -- Redondear el precio al entero más cercano
        DBMS_OUTPUT.PUT_LINE('EL PRECIO SE HA REDONDEADO'); -- Mensaje de salida
    ELSE
        -- Si no es mayor, lanzar un error personalizado
        RAISE_APPLICATION_ERROR(-20001, 'EL PRECIO NO SE HA REDONDEADO'); -- Lanzar un error
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/