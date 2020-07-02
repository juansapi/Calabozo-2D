@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n6_calabozo
REM Autor: Rafael Muñoz Lattion - 28-feb-2013
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/calabozo.jar;test/lib/junit.jar;test/lib/calabozoTest.jar junit.swingui.TestRunner uniandes.cupi2.calabozo.test.CalabozoTest
	
java -ea -classpath lib/calabozo.jar;test/lib/junit.jar;test/lib/calabozoTest.jar junit.swingui.TestRunner uniandes.cupi2.calabozo.test.CasillaTest
cd bin/win