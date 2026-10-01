declare
	num number(3):=1;
	palabra varchar(30):='&palabra';
	letra varchar2(30);
	longitud number(3);
begin
	longitud:=length(palabra);
	while num<=longitud loop
		letra:=substr(palabra,num,1);
		dbms_output.put_line('  ' || letra);
		num:=num+1;
	end loop;
end;
/

DECLARE 
  resultado1 varchar2(30);
  resultado2 varchar2(30);
  resultado3 varchar2(30);
  resultado4 varchar2(30);
BEGIN
  resultado1:=substr('APRENDIENDO PLSQL',1,11);
  DBMS_OUTPUT.PUT_LINE(' Resultado 1 ' || resultado1);
  resultado2:=substr('APRENDIENDO PLSQL',3,2);
  DBMS_OUTPUT.PUT_LINE(' Resultado 2 ' || resultado2);
  resultado3:=substr('APRENDIENDO PLSQL',13,2);
  DBMS_OUTPUT.PUT_LINE(' Resultado 3 ' || resultado3);
  resultado4:=substr('APRENDIENDO PLSQL',15,3);
  DBMS_OUTPUT.PUT_LINE(' Resultado 4 ' || resultado4);
END;

 Resultado 1 APRENDIENDO
 Resultado 2 RE
 Resultado 3 PL
 Resultado 4 SQL

 