-- Crear o reemplazar un trigger llamado impedir_apellidos_minusculas
CREATE OR REPLACE TRIGGER impedir_apellidos_minusculas
    BEFORE INSERT OR UPDATE ON emple -- Se activa antes de una inserción o actualización en la tabla emple
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
BEGIN
    -- Comprobar si el apellido nuevo está en minúsculas
    IF LOWER(:new.apellido) = :new.apellido THEN
        -- Si está en minúsculas, lanzar un error personalizado
        RAISE_APPLICATION_ERROR(-20005, 'APELLIDO EN MINÚSCULA');
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/