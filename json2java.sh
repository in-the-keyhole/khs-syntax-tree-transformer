#!/usr/bin/env bash

NAME="COBOLDB2"
PACKAGE="khs.res.db2demo"
DESTDIR="./src/main/java/khs/res/db2demo"
XFORMER="khs.transformer.CommandLine"

echo Translating $NAME.json to $NAME.java

# exec:java -Dexec.mainClass=$XFORMER -Dexec.args=./$NAME.json $PACKAGE
mvn exec:java

cp ./$NAME.java $DESTDIR/$NAME.java
echo copyied ./$NAME.java to $DESTDIR/$NAME.java

mvn compile


