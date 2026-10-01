-- Crear una tabla llamada auditar_emple para almacenar registros de auditoría
create table auditar_emple(
    num number, -- Columna para almacenar el número de empleado
    mensaje varchar2(50) -- Columna para almacenar el mensaje de auditoría
);

-- Crear o reemplazar un trigger llamado auditor_subida_salario
CREATE OR REPLACE TRIGGER auditor_subida_salario
    after update of salario on emple -- Se activa después de una actualización en la columna salario de la tabla emple
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la actualización
BEGIN
    -- Comprobar si el nuevo salario es mayor que el salario antiguo
    IF :NEW.SALARIO > :OLD.SALARIO THEN
        -- Si hay un aumento de salario, insertar un registro en auditar_emple
        INSERT INTO auditar_emple(num, mensaje)
        VALUES (:OLD.emp_no, 'SUBIDA SALARIO EMPLEADO ' || :OLD.emp_no);
    else
        -- Si hay una disminución de salario, insertar un registro en auditar_emple
        INSERT INTO auditar_emple(num, mensaje)
        VALUES (:OLD.emp_no, 'BAJADA SALARIO EMPLEADO ' || :OLD.emp_no);
    END IF; -- Fin de la condición IF
END; -- Fin del trigger
/

-- Actualizar el salario de un empleado específico (con emp_no 7900) a 20
UPDATE EMPLE SET SALARIO = 20 WHERE EMP_NO LIKE 7900;

-- Seleccionar todos los registros de la tabla auditar_emple para ver los cambios auditados
SELECT * FROM auditar_emple;

-- Seleccionar todos los registros de la tabla emple para ver el estado actual de los empleados
SELECT * FROM emple;