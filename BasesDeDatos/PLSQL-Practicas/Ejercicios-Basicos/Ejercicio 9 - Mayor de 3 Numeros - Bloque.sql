Declare
			num1 integer;
        	num2 integer;
        	num3 integer; 
begin
		num1:='&num1';
		num2:='&num2';
		num3:='&num3';
    	if num1>num2
            	then
               		 if num1>num3
                   			 then
                       			DBMS_OUTPUT.PUT_LINE('El numero mayor es: ' || num1);
                    			else
                        			DBMS_OUTPUT.PUT_LINE('El numero mayor es: ' || num3);
               		 end if;
           	else
                		if num2>num3
                    			then
                       			 DBMS_OUTPUT.PUT_LINE('El numero mayor es: ' || num2); 
                    			else
                     				DBMS_OUTPUT.PUT_LINE('El numero mayor es: ' || num3); 
                		end if;
    	end if;
end;
/

