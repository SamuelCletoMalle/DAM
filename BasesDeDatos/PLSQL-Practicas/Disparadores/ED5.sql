-- Crear una tabla llamada AUDITOR2_EMPLE para almacenar registros de auditoría
CREATE TABLE AUDITOR2_EMPLE (COL1 VARCHAR2(200));

-- Crear o reemplazar un trigger llamado insertar_auditar_emple
CREATE OR REPLACE TRIGGER insertar_auditar_emple
    after update of salario on emple -- Se activa después de una actualización en la columna salario de la tabla emple
    FOR EACH ROW -- Se ejecuta para cada fila afectada por la actualización
DECLARE
    MENSAJES VARCHAR2(200); -- Declarar una variable para almacenar el mensaje de auditoría
BEGIN
    -- Comprobar si el nuevo salario es mayor que el 5% del salario antiguo
    if :new.salario > (:old.salario * 0.05) then
        -- Si se cumple la condición, construir el mensaje de auditoría
        MENSAJES := ('CAMBIO SUPERA EL 5% ' || :old.emp_no || -- Mensaje que indica el número de empleado
                     ' SALARIO ANTERIOR: ' || :old.salario || -- Añadir el salario anterior
                     ' FECHA/DIA/HORA: ' || TO_CHAR(SYSDATE, 'DD/MM/YY HH24:MI')); -- Añadir la fecha y hora actual
        -- Insertar el mensaje en la tabla AUDITOR2_EMPLE
        INSERT INTO AUDITOR2_EMPLE(COL1)
        VALUES (MENSAJES);
    end if; -- Fin de la condición IF
END; -- Fin del trigger
/
