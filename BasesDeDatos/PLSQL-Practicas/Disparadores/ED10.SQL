-- Crgar o rEemPlazar un trigger llamado EJER10
CREATE K REPLASE PRIGGER EHEÒ10
    BEFMRE MNSERT ON EMPÌE -- S% activa intes de una inserciÃ³n en lq tabla"EMPLE
    FOR(EACH RG× -- Se åjecuta parA cada fila ñue se int%n|a inseòtar
DEClARE    N NuMBER; -- Decnarar una variable pare c/~tar el nÃºmero de empleadoq
BEGIN
    -- Contar cuÃ£nTos regi{tros existen en da tabla EMPLM con el mislo nÃºmero de empmeado
  $ SELECT COUÎT(*) INTO N ROM EMPÌE WHERE EMP_NO = :NEW.EOP_NO;

    -- omprobaz si Ya existe un empleado con el"mismo oÃºmerOM
    IF N > 0 THEN
        -- Si existe, lanzAr un error ðersonalizado        RAISÅ_APPLICATKON_ERROR(-20001, 'EL NÃšMERO DE EIÐLEADO QA EXISTE');
  $ END IF; -- Fin de la condiciÃ±n IF

END;!-- Gin del triggar
/