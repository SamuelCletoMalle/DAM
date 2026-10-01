CREATE OR REPLACE PROCEDURE MAYOR(num1 NUMBER, num2 NUMBER, num3 NUMBER )
IS 
begin
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

