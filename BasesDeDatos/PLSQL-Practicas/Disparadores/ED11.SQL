-- Crear o reemplazar un trigger llamado BORRAREMPLEADOS
CREATE OR REPLACE TRIGGER BORRAREMPLEADOS
    BEFORE UPDATE OR INSERT ON EMPLE -- Se activa antes de una actualización o inserción en la tabla EMPLE
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
BEGIN
    -- Comprobar si el día actual es el 11
    IF TO_CHAR(SYSDATE, 'DD') = '11' THEN
        -- Si es el día 11, lanzar un error personalizado
        RAISE_APPLICATION_ERROR(-20003, 'ERROR, ES DIA 11');
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/

-- Eliminar todos los registros de la tabla EMPLE
DELETE FROM EMPLE;