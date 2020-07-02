# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# $Id$
# Universidad de los Andes (Bogota� - Colombia)
# Departamento de Ingenieri�a de Sistemas y Computacio�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2
# Ejercicio: n6_calabozo
# Autor: Rafael Munoz Lattion - 20-jun-2012
# Creacion de Script: Juan Sebasti�an Urrego
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# ---------------------------------------------------------
# Asegura la creacion de los directorios classes y lib
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd ../..
mkdir -p classes
mkdir -p lib
cd lib
cp -r ../data data
cd ..
# ---------------------------------------------------------
# Compila las clases del directorio source
# ---------------------------------------------------------
cd source
pwd
javac -encoding ISO-8859-1 -d ../classes/ uniandes/cupi2/calabozo/mundo/*.java
javac -encoding ISO-8859-1 -d ../classes/ uniandes/cupi2/calabozo/interfaz/*.java
# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------
cd ..
cd classes
echo Manifest-Version: 1.0 > MANIFEST.MF
echo Class-Path: 1.0 >> MANIFEST.MF
echo Main-Class: uniandes.cupi2.calabozo.interfaz.InterfazCalabozo >> MANIFEST.MF
jar cvfm ../lib/calabozo.jar MANIFEST.MF uniandes/* 
cd ../bin