# khs-syntax-tree-transformer

## Cobol JSON Syntax Tree to Java Source Code

Transforms a Cobol JSON Syntax tree created using [Antlr](http://www.antlr.org/) parse application into a Java Program ... 
 

## Installation and Execution

1. Clone Repo
2. Import as Maven Project into Eclipse or Intellij 
3. mvn install
4. Execute main method with command line arguments for JSON input file and emitted 
Java package name (Maven taget classes must be on classpath)

e.g.

```
        java khs.transformer.CommandLine demo.json khs.example 
```
  
This produces an emitted `Program.java` program in the project directory and system.out:

``` java 

package khs.res.db2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import khs.cobol.transformer.runtime.Display;
import khs.cobol.transformer.runtime.Database;
import khs.cobol.transformer.runtime.InItem;
import khs.cobol.transformer.runtime.OutItem;

/**
 * Java source, file COBOLDB2.java generated from Cobol source, COBOLDB2.cbl
 *
 * @version 0.0.3
 * @author Keyhole Software LLC
 */
public class COBOLDB2   {
    private static Logger Log = LoggerFactory.getLogger("COBOLDB2");
 	// SQLCA
	private int sqlcode;

 	// Level 05
	private String v_ws_empno;

	// Level 05
	private String v_ws_last_name;

	// Level 05
	private String v_ws_first_name;

	// Level 01
	private InItem[] v_ws_employee_record = new InItem[]{ () -> v_ws_empno, () -> v_ws_last_name, () -> v_ws_first_name };
    // Procedure division entry:
    public static void main(String[] args) {
        try {
            COBOLDB2 instance = new COBOLDB2();
            instance.m_procdiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void m_procdiv () throws Exception {
        final String sql = "SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310";

		final OutItem[] into = new OutItem[]{
			s -> v_ws_empno = (String)s,
			s -> v_ws_last_name = (String)s,
			s -> v_ws_first_name = (String)s
		};

		sqlcode = Database.getInstance().selectInto( sql, into );

        if ( sqlcode == 0 ) {
			Display.display( v_ws_employee_record );
		} else {
			Display.display( "Error" );
		}
        // EXIT ...
		System.exit(0);
    }

}


```

Following is input `demo.json` created by an [Antlr](http://www.antlr.org/) parser for Cobol:

``` json

{
  "name" : "COBOLDB2",
  "typeName" : "CLASS",
  "variables" : [ {
    "name" : "sqlca",
    "typeName" : "sqlca",
    "value" : "sqlca",
    "isLocal" : true,
    "isWorking" : true,
    "isArray" : false,
    "varLevel" : "sqlca",
    "picture" : null,
    "variables" : [ ]
  }, {
    "name" : "ws-employee-record",
    "typeName" : "VARIABLE",
    "value" : null,
    "isLocal" : true,
    "isWorking" : false,
    "isArray" : true,
    "varLevel" : "01",
    "picture" : null,
    "variables" : [ {
      "name" : "ws-empno",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : true,
      "isWorking" : false,
      "isArray" : false,
      "varLevel" : "05",
      "picture" : "XXXXXX",
      "variables" : [ ]
    }, {
      "name" : "ws-last-name",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : true,
      "isWorking" : false,
      "isArray" : false,
      "varLevel" : "05",
      "picture" : "XXXXXXXXXXXXXXX",
      "variables" : [ ]
    }, {
      "name" : "ws-first-name",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : true,
      "isWorking" : false,
      "isArray" : false,
      "varLevel" : "05",
      "picture" : "XXXXXXXXXXXX",
      "variables" : [ ]
    } ]
  } ],
  "functions" : [ {
    "name" : "procDiv",
    "typeName" : "FUNCTION",
    "methods" : [ {
      "name" : "DB_METHOD",
      "typeName" : "DB_METHOD",
      "type" : null,
      "sql" : " SELECT EMPNO, LASTNAME, FIRSTNME FROM EMPLOYEE WHERE EMPNO=200310 ",
      "sqlArgs" : [ "ws_empno", "ws_last_name", "ws_first_name" ]
    }, {
      "name" : "IF",
      "typeName" : "IF",
      "type" : null,
      "expr" : "sqlcode == 0",
      "body" : [ {
        "name" : "DISPLAY",
        "typeName" : "DISPLAY",
        "type" : null,
        "value" : "ws_employee_record"
      } ],
      "stmElse" : {
        "name" : "ELSE",
        "typeName" : "ELSE",
        "type" : null,
        "body" : [ {
          "name" : "DISPLAY",
          "typeName" : "DISPLAY",
          "type" : null,
          "value" : "\"Error\""
        } ]
      }
    }, {
      "name" : null,
      "typeName" : "EXIT",
      "type" : null
    } ]
  } ],
  "sequence" : "1"
}

```

## DB2

The POC aims to translate Cobol programs or stored procedures that use DB2, to Java code that uses an ORM. As a first 
step in proof-of-concept persistence, we translate simple DB2 programs to demo Java code that uses DB2 Express.

There's an example COBOL application that accesses in the projects `cobol` folder

Transform JSON into java program with the following command. 

```
        java khs.transformer.CommandLine COBOLDB2.json khs.example 
```

A COBOLDB2.JAVA file will be created in your project directory

To execute the DB2 application follow these instructions to create a sample database using [Docker](https://docker.com)

The DB2 Express runs in a Docker container. There are no pooled connections. This is just a POC step.

-----------------------------------------------------------

### Docker DB2 Express Container


Ensure you have access to Docker. [https://www.docker.com/](https://www.docker.com/)

Use this Docker image for initial DB2 binding: 
[https://hub.docker.com/r/ibmcom/db2express-c/](https://hub.docker.com/r/ibmcom/db2express-c/)

```

docker run --name db2 -d -it -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept -v  $(pwd)/dbstore:/dbstore ibmcom/db2express-c:latest db2start
docker exec -it db2 bash

```

1. Create running Docker DB2 Express container daemon, and log into a bash session as shown above
2. Issue `su db2inst1`
3. Issue `db2sampl` (takes a while to create database "SAMPLE")

```

[db2inst1@6f44040637fc /]$ db2sampl

  Creating database "SAMPLE"...
  Connecting to database "SAMPLE"...
  Creating tables and data in schema "DB2INST1"...
  Creating tables with XML columns and XML data in schema "DB2INST1"...

  'db2sampl' processing complete.

```

4. At completion smoke-test the installation:

Run as Java: `khs.transformer.CheckDb2Connection`

Displays on console:

```

D#        DEPT NAME MGR        DIV        LOCATION
--        --------- ---        ---        --------
38   South Atlantic 030    Eastern         Atlanta
15      New England 050    Eastern          Boston
42      Great Lakes 100    Midwest         Chicago
51           Plains 140    Midwest          Dallas
84         Mountain 290    Western          Denver
10      Head Office 160  Corporate        New York
66          Pacific 270    Western   San Francisco
20     Mid Atlantic 010    Eastern      Washington

```

You may also try the db2 command from the bash session of the Docker container:

```

db2 start database manager
db2 connect to sample
db2 list tables
db2 describe table employee
db2 describe table org
db2 select firstnme, lastname, workdept from employee order by lastname, firstnme
db2 select deptnumb, deptname, manager, division, location from org order by location


```

Note that the database disappears if we delete the Docker DB2 container. To avoid this, one could script the image
toprovision itself from a mounted Docker volume.

-----------------------------------------------------------

## Run Generated Java Class

With the sample database created, transform COBOLDB2.json into Java application with the CoomandLine runnable class.
Pass the path to the JSON file as an argument. The Maven target files should be on the classpath. That execution 
creates a COBOLDB2.JAVA file in the project root directory. Drag it to package `khs.res.db2demo` (This could be 
incorporated into an ant script or a bash script).

Build-and-run the converted application after ensuring the DB2 DBMS is running 
(again, Maven target classes must be on the classpath).

```
        java khs.res.db2demo.COBOLDB2
```

The Cobol program carried out a DB2 SELECT .. INTO query of employee number 200310. If the result was good, it
displayed the employee record on the console. The Java translation maps this behavior accordingly:

```

2017-02-11 16:39:14 INFO  DB2DEMO:83 - jdbc:db2://0.0.0.0:50000/sample
200310 SPRINGER MICHELLE

```

-----------------------------------------------------------

