-- Crear o reemplazar un trigger llamado AUDITAR
CREATE OR REPLACE TRIGGER AUDITAR
    BEFORE INSERT OR UPDATE OR DELETE ON EMPLE -- Se activa antes de una inserción, actualización o eliminación en la tabla EMPLE
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la operación
DECLARE
    FECHA VARCHAR2(20); -- Declarar una variable para almacenar la fecha y hora como cadena
    EMPLEADO NUMBER; -- Declarar una variable para almacenar el número de empleado
    APELLIDO VARCHAR2(50); -- Declarar una variable para almacenar el apellido del empleado
    OPERACION1 VARCHAR2(20); -- Declarar una variable para almacenar el tipo de operación
    OPERACION2 VARCHAR2(20); -- Declarar una variable para almacenar el tipo de operación
    OPERACION3 VARCHAR2(20); -- Declarar una variable para almacenar el tipo de operación
BEGIN
    -- Obtener la fecha y hora actual en formato deseado
    FECHA := TO_CHAR(SYSDATE, 'DD/MM/YY HH24:MI');
    EMPLEADO := :NEW.EMP_NO; -- Obtener el número de empleado de la fila nueva
    APELLIDO := :NEW.APELLIDO; -- Obtener el apellido de la fila nueva

    -- Definir los tipos de operación
    OPERACION1 := 'CREACION'; -- Mensaje para creación
    OPERACION2 := 'MODIFICACION'; -- Mensaje para modificación
    OPERACION3 := 'BORRADO'; -- Mensaje para borrado

    -- Comprobar si se está realizando una inserción
    IF INSERTING THEN
        -- Insertar un registro en AUDITOR2_EMPLE para la creación
        INSERT INTO AUDITOR2_EMPLE VALUES (FECHA || ' ' || EMPLEADO || ' ' || APELLIDO || ' ' || OPERACION1);
    END IF;

    -- Comprobar si se está realizando una actualización
    IF UPDATING THEN
        -- Insertar un registro en AUDITOR2_EMPLE para la modificación
        INSERT INTO AUDITOR2_EMPLE VALUES (FECHA || ' ' || EMPLEADO || ' ' || APELLIDO || ' ' || OPERACION2);
    END IF;

    -- Comprobar si se está realizando una eliminación
    IF DELETING THEN
        -- Insertar un registro en AUDITOR2_EMPLE para el borrado
        INSERT INTO AUDITOR2_EMPLE VALUES (FECHA || ' ' || EMPLEADO || ' ' || APELLIDO || ' ' || OPERACION3);
    END IF;
END; -- Fin del trigger
/
