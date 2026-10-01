declare
	num number(3):=1;
	palabra varchar(30):='&palabra';
	letra varchar2(30);
	longitud number(3);
  contadoraes number;
begin
	longitud:=length(palabra);
        contadoraes:=0;
	while num<=longitud loop
		letra:=substr(palabra,num,1);
		if letra='a' or letra='A'
            then contadoraes:=contadoraes+1;
    end if;
		num:=num+1;
	end loop;
  dbms_output.put_line(' contador de aes  ' || contadoraes);
end;
/


 