#!/usr/bin/env bash

NAME="COBOLDB2"
PACKAGE="khs.res.db2demo"
JAVACODE="khs.res.db2demo.COBOLDB2"

mvn exec:java -Dexec.mainClass=$JAVACODE
