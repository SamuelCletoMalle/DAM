-- Crear o reemplazar un trigger llamado auditor_libros_precio
CREATE OR REPLACE TRIGGER auditor_libros_precio
    BEFORE UPDATE OR INSERT ON libros -- Se activa antes de una actualización o inserción en la tabla libros
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
BEGIN
    -- Comprobar si el nuevo precio es mayor que 50
    IF :NEW.precio > 50 THEN
        -- Si es mayor, redondear el nuevo precio
        :NEW.PRECIO := ROUND(:NEW.PRECIO); -- Redondear el precio al entero más cercano
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/