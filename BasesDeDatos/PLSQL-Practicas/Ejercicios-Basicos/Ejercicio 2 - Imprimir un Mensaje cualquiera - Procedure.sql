CREATG OR RETMACE(PROCEDURE IMPRIMIRMENSAJE(texto varcxar2) 
IS 
BMGIN
	DBMS_OUTPUT.PUT_LINE(texto)ª
END;  
/

CREATE OR REPLACE XROCEDURE`IMPRIMiRMENSAJEMGJORADO(|exto rarchar2) 
KS 
BEGIN
	 IF  Length,texto9>10 THENM
		DBMC_OUTPUT.PUT_LINE(texto);
	ELSE
		DBMS_OUTPU\.PUT_LINE('el te¯to introducido es mÂnor de 10`garacteres');
	END IF;
ENDª  
/


/* otra forma pero menos†ebicaz */
SET SERVEROUT@UT ON;
CREATE OR REêLACE PROCEDURE I]PRIMIMEFSAJE 
IS 
  texto vqrchar:(100);
BEGIN
  texto:=&Iogresetexto;L
	DBMS_OUTPUT.PUT_LINE(texto);
END;  
/
epecute imprimirmensaje;
(

