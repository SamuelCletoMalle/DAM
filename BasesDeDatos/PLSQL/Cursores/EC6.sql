/*Realizar un bloque pl/sql que reciba una cadena por teclado y visualice el apellido
y el número de empleado de todos los empleados cuyo apellido coincida con la cadena
especificada. Al finalizar visualizar el número de empleados mostrados.*/
-- Crear o reemplazar el procedimiento llamado ver_dept que recibe un parámetro de tipo varchar2
create or replace procedure ver_dept(ape varchar2)
is
  -- Declarar un cursor que selecciona el apellido y el número de empleado de la tabla 'emple'
  CURSOR cur1 IS 
   SELECT apellido, emp_no from emple 
   where apellido = ape;  -- Filtrar por el apellido proporcionado como parámetro

  -- Declarar variables para almacenar los resultados del cursor
  v_apellido VARCHAR2(14); 
  num number;
  cont number;  -- Contador para llevar el número de empleados encontrados

BEGIN  
  cont := 0;  -- Inicializar el contador a 0
  OPEN cur1;  -- Abrir el cursor para comenzar a recuperar datos
  FETCH cur1 INTO v_apellido, num;  -- Obtener la primera fila del cursor

  -- Bucle para procesar todas las filas del cursor mientras haya filas encontradas
  WHILE cur1%FOUND LOOP 
    -- Imprimir el apellido y el número de empleado en la salida
    DBMS_OUTPUT.PUT_LINE(v_apellido || ' ' || num);
    
    -- Obtener la siguiente fila del cursor
    FETCH cur1 INTO v_apellido, num; 
    cont := cont + 1;  -- Incrementar el contador por cada empleado encontrado
  END LOOP; 

  -- Imprimir el total de números de empleados encontrados
  DBMS_OUTPUT.PUT_LINE('números de empleado ' || cont);
  
  CLOSE cur1;  -- Cerrar el cursor después de haber terminado
END; 
/

-- Activar la salida del servidor para poder ver los resultados de DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- Declarar un bloque anónimo para ejecutar el procedimiento
declare
  apellido1 varchar2(10);  -- Variable para almacenar el apellido ingresado por el usuario
   
begin 
  -- Solicitar al usuario que introduzca un apellido
  DBMS_OUTPUT.PUT_LINE('introduce el apellido'); 
  apellido1 := '&introduce';  -- Asignar el valor ingresado por el usuario a la variable apellido1
  ver_dept(apellido1);  -- Llamar al procedimiento ver_dept con el apellido proporcionado
end;
