# khs-syntax-tree-transformer

## Cobol JSON Syntax Tree to Java Source Code

Transforms a Cobol JSON Syntax tree created using [Antlr](http://www.antlr.org/) parse application into a Java Program ... 
 

## Installation and Execution

1. Clone Repo
2. Import as Maven Project into Eclipse or Intellij 
3. Execute main method with command line arguments for JSON input file and emitted 
Java package name.

e.g.

```
        java khs.transformer.CommandLine demo.json khs.example 
```
  
> Produces an emitted `Program.java` program in the project directory and system.out:

``` java 

package khs.res.example.Program


public class Program   {

            private Double CONST-PI = null;  
            private Double WORK-1 = 0;  
            private Double WORK-2 = 0;  
            private Double PRINT-LINE = null;  
        
    public void static main(String[] args) {
         Program job = new Program ();
        job.A-PARA ();
    }   
    
      public void A-PARA () {
               	      WORK-1 = 123.46
               	      WORK-2 = WORK-2+2
               	      WORK-2 = WORK-3*3
               	      C-PARA()
              }
      public void B-PARA () {
               	      CONST-PI = Math.PI;
               	      EDT-ID = ZERO
              }
      public void C-PARA () {
               	      B-PARA()
              }
      
}

```

Following is input `demo.json` created by an [Antlr](http://www.antlr.org/) parser for Cobol:

``` json

 {
  "name" : "Program",
  "typeName" : "CLASS",
  "variables" : [ {
    "name" : "CONST-PI",
    "typeName" : "VARIABLE",
    "value" : null,
    "isLocal" : false,
    "isWorking" : true,
    "isArray" : false,
    "fileLevel" : null,
    "variables" : [ ]
  }, {
    "name" : "WORK-1",
    "typeName" : "VARIABLE",
    "value" : "ZERO",
    "isLocal" : false,
    "isWorking" : true,
    "isArray" : false,
    "fileLevel" : null,
    "variables" : [ ]
  }, {
    "name" : "WORK-2",
    "typeName" : "VARIABLE",
    "value" : "ZERO",
    "isLocal" : false,
    "isWorking" : true,
    "isArray" : false,
    "fileLevel" : null,
    "variables" : [ ]
  }, {
    "name" : "PRINT-LINE",
    "typeName" : "VARIABLE",
    "value" : null,
    "isLocal" : false,
    "isWorking" : true,
    "isArray" : true,
    "fileLevel" : null,
    "variables" : [ {
      "name" : "EDT-ID",
      "typeName" : "VARIABLE",
      "value" : "SPACES",
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "FILLER",
      "typeName" : "VARIABLE",
      "value" : "' Perimeter '",
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "EDT-3-15-CIR",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "FILLER",
      "typeName" : "VARIABLE",
      "value" : "' Radius '",
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "EDT-3-15-RAD",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "FILLER",
      "typeName" : "VARIABLE",
      "value" : "' Pi '",
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    }, {
      "name" : "EDT-1-15-PI",
      "typeName" : "VARIABLE",
      "value" : null,
      "isLocal" : false,
      "isWorking" : true,
      "isArray" : false,
      "fileLevel" : null,
      "variables" : [ ]
    } ]
  } ],
  "functions" : [ {
    "name" : "A-PARA",
    "typeName" : "FUNCTION",
    "methods" : [ {
      "name" : "123.46TOWORK-1",
      "typeName" : "METHOD",
      "type" : {
        "name" : null,
        "typeName" : "MOVE",
        "varName" : "WORK-1",
        "value" : "123.46"
      }
    }, {
      "name" : "2TOWORK-2",
      "typeName" : "METHOD",
      "type" : {
        "typeName" : "ADD",
        "value" : "2",
        "var1" : "WORK-2",
        "var2" : null
      }
    }, {
      "name" : "3GIVINGWORK-3",
      "typeName" : "METHOD",
      "type" : {
        "typeName" : "MULTI",
        "value" : "3",
        "var1" : "WORK-2",
        "var2" : "WORK-3"
      }
    }, {
      "name" : "C-PARA",
      "typeName" : "METHOD",
      "type" : {
        "name" : "C-PARA",
        "typeName" : "CALL"
      }
    } ]
  }, {
    "name" : "B-PARA",
    "typeName" : "FUNCTION",
    "methods" : [ {
      "name" : "PITOCONST-PI",
      "typeName" : "METHOD",
      "type" : {
        "name" : null,
        "typeName" : "MOVE",
        "varName" : "CONST-PI",
        "value" : "PI"
      }
    }, {
      "name" : "ZEROTOEDT-ID",
      "typeName" : "METHOD",
      "type" : {
        "name" : null,
        "typeName" : "MOVE",
        "varName" : "EDT-ID",
        "value" : "ZERO"
      }
    } ]
  }, {
    "name" : "C-PARA",
    "typeName" : "FUNCTION",
    "methods" : [ {
      "name" : "B-PARA",
      "typeName" : "METHOD",
      "type" : {
        "name" : "B-PARA",
        "typeName" : "CALL"
      }
    } ]
  } ]
}

```

## DB2

The POC aims to translate Cobol programs or stored procedures that use DB2, to Java code that uses an ORM. As a first 
step in proof-of-concept persistence, we translate simple DB2 programs to demo Java code that uses DB2 Express.

The DB2 Express runs in a Docker container. There are no pooled connections. This is just a POC step.

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

Note that the database disappears after we stop the Docker machine. To avoid this, use create the sample db
on the shared volume, `dbstore` in the local host directory where you invoked `docker run`. This is left as
an exercise for the reader. 

With the sample database created transform COBOLDB2.json into Java application with the following commands

```
        java khs.transformer.CommandLine COBOLDB2.json khs.example 
```

A COBOLDB2.JAVA file will be created in your project directory



-----------------------------------------------------------
