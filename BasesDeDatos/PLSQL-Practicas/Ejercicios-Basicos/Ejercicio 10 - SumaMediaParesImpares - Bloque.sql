declare
      num integer:=&num;
    	suma integer;
      sumapares integer;
      sumaimpares integer;
      media real;
    	i integer;
 begin
    suma:=0;
    sumapares:=0;
    sumaimpares:=0;
    i:=1;
    while i<=num loop
      suma:=suma + i;
      if mod(i,2)=0
        then sumapares:=sumapares+i;
        else sumaimpares:=sumaimpares+1;
      end if;
      i:=i+1;
    end loop;
    media:=suma/i;
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros 	es ' ||suma);
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros PARES 	es ' ||sumapares);
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros IMPARES	es ' ||sumaimpares);
    DBMS_OUTPUT.PUT_LINE('la media de los ' ||num ||'  primeros enteros 	es ' ||media);
  end;
 
 create or replace procedure sumasmedia(num integer)
  as
      suma integer;
      sumapares integer;
      sumaimpares integer;
      media real;
    	i integer;
 begin
    suma:=0;
    sumapares:=0;
    sumaimpares:=0;
    i:=1;
    while i<=num loop
      suma:=suma + i;
      if mod(i,2)=0
        then sumapares:=sumapares+i;
        else sumaimpares:=sumaimpares+1;
      end if;
      i:=i+1;
    end loop;
    media:=suma/i;
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros 	es ' ||suma);
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros PARES 	es ' ||sumapares);
    DBMS_OUTPUT.PUT_LINE('la suma de los ' ||num ||'  primeros enteros IMPARES	es ' ||sumaimpares);
    DBMS_OUTPUT.PUT_LINE('la media de los ' ||num ||'  primeros enteros 	es ' ||media);
  end;
 
 declare
     numero integer;
 begin
     numero:=&IntroduceNumero
	 
	 
	 
	 
	 
	 
	 ; 
     sumasmedia(num);
 end;
 
 