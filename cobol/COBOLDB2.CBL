* --------------------------------------------------------------
* Selects a single employee into a record's detail fields, and
* then displays them by displaying the record.
*
* Demonstrates Cobol-to-Java translation of a DB2 SELECT INTO
* the detail fields of a parent record.
*
* Java has no native notion of a record aggregate. A SQL
* SELECT INTO similarly lacks a record construct.
*
* Lou Mauget, January 31, 2017
* --------------------------------------------------------------

 IDENTIFICATION DIVISION.
 PROGRAM-ID. COBOLDB2.
 DATA DIVISION.
   WORKING-STORAGE SECTION.
   EXEC SQL
      INCLUDE SQLCA
   END-EXEC.

   EXEC SQL
      INCLUDE EMPLOYEE
   END-EXEC.

   EXEC SQL BEGIN DECLARE SECTION
   END-EXEC.
      01 WS-EMPLOYEE-RECORD.
         05 WS-EMPNO PIC XXXXXX.
         05 WS-LAST-NAME PIC XXXXXXXXXXXXXXX.
         05 WS-FIRST-NAME PIC XXXXXXXXXXXX.
   EXEC SQL END DECLARE SECTION
   END-EXEC.

 PROCEDURE DIVISION.
   EXEC SQL
      SELECT EMPNO, LASTNAME, FIRSTNME
      INTO :WS-EMPNO, :WS-LAST-NAME, :WS-FIRST-NAME FROM EMPLOYEE
      WHERE EMPNO=200310
   END-EXEC.

   IF SQLCODE = 0
      DISPLAY WS-EMPLOYEE-RECORD
   ELSE
      DISPLAY 'Error'
   END-IF.
 STOP RUN.
