# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# $Id$
# Universidad de los Andes (Bogota‡ - Colombia)
# Departamento de Ingenieri’a de Sistemas y Computacio—n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2
# Ejercicio: n6_calabozo
# Autor: Rafael Munoz Lattion - 20-jun-2012
# Creacion de Script: Juan Sebasti‡an Urrego
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# ---------------------------------------------------------
# Asegura la creaci—on de los directorios classes y lib
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
pwd
java -ea -classpath ../../lib/calabozo.jar:../../test/lib/calabozoTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.calabozo.test.CalabozoTest


