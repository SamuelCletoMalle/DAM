/*Crear un trigger que se disparará cada vez que se borre un empleado guardando
su número de empleado, apellido y el departamento en una fila de la tabla
AUDITAR_EMPLE.
Una vez hecho el disparador o trigger comprobarlo haciendo la correspondiente
consulta de borrado (DELETE).*/

-- Crear o reemplazar un trigger llamado borrado_empleado
CREATE OR REPLACE TRIGGER borrado_empleado
    after delete on emple -- Se activa después de una eliminación en la tabla emple
    FOR EACH ROW -- Se ejecuta para cada fila que se elimina
BEGIN
    -- Insertar un registro en auditar_emple para registrar la baja del empleado
    INSERT INTO auditar_emple
    VALUES (:old.emp_no, -- Número de empleado del registro eliminado
            'BAJA EMPLEADO: Nº EMPLEADO ' || :old.emp_no || -- Mensaje que indica el número de empleado
            ' APELLIDO ' || :OLD.apellido || -- Añadir el apellido del empleado eliminado
            ' DEPARTAMENTO ' || :OLD.dept_no); -- Añadir el número de departamento del empleado eliminado
END; -- Fin del trigger
/

-- Eliminar un empleado específico (con emp_no 7369) de la tabla emple
DELETE FROM emple WHERE emp_no = 7369;
