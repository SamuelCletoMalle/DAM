declare
	palabra varchar(30):='&Frase';
	letra varchar2(30);
	longitud number(3);
    i number;
	contador number;
begin
	i:=1;
	contador:=0;
	longitud:=length(palabra);
  dbms_output.put_line(' la palabra repetida letra a letra es ');
	while i<=longitud loop
		letra:=substr(palabra,i,1);
		i:=i+1;
 		dbms_output.put_line(letra || letra);
	end loop;
end;
/

/* solo las aes y cuantas */
SET SERVEROUTPUT ON;
declare
	palabra varchar(30):='&Frase';
	letra varchar2(30);
	longitud number(3);
    i number;
	contador number;
begin
	i:=1;
	contador:=0;
	longitud:=length(palabra);
  dbms_output.put_line(' la palabra repetida letra a letra es ');
	while i<=longitud loop
		letra:=substr(palabra,i,1);
		if letra='A' or letra='a' 
       then dbms_output.put_line(letra || letra);
    end if;
    
    i:=i+1;
	end loop;
end;
/