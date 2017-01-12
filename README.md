# khs-syntax-tree-transformer

## Cobol JSON Syntax Tree to Java Source Code

Transforms a Cobol JSON Syntax tree into a Java Program ... 
eventually it will procuce a Spring Boot program. 

## Installation and Execution

1. Clone Repo
2. Import as Maven Project into Eclipse or Intellij 
3. Execute main method with command line arguments for JSON input file and emitted 
Java package name.

e.g.

```
        java khs.transformer.CommandLine demo.json khs.example 
```
  
> Produces an emitted `Program.java` program in the project directory:

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

Following is input `demo.json` created elswhwere by a parser of Cobol:

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

The POC aims to translate Cobol programs or stored proceudres that use DB2, to Java code that uses an ORM. As a first 
step in proof-of-concdpt persistence, we translate simple DB2 programs to demo Java code that uses DB2 Express.

The DB2 Express runs in a Docker container. There are no pooled connections. This is just a POC step.

### Docker DB2 Express Container


Ensure you have access to Docker. [https://www.docker.com/](https://www.docker.com/)

Use this Docker image for initial DB2 binding: 
[https://hub.docker.com/r/ibmcom/db2express-c/](https://hub.docker.com/r/ibmcom/db2express-c/)

1. `docker run --name db2 -it -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept ibmcom/db2express-c:latest bash`
2. You are logged into the the docker machine command window at complettion of the run command
3. Issue `su db2inst1`
4. Issue `db2sampl` (takes a while to create database "SAMPLE")

```

[db2inst1@6f44040637fc /]$ db2sampl

  Creating database "SAMPLE"...
  Connecting to database "SAMPLE"...
  Creating tables and data in schema "DB2INST1"...
  Creating tables with XML columns and XML data in schema "DB2INST1"...

  'db2sampl' processing complete.

```

5. At completion test, the installation:

```

db2 start database manager
db2 connect to sample
db2 list tables
db2 describe table employee
db2 describe table org
db2 select firstnme, lastname, workdept from employee order by lastname, firstnme
db2 select deptnumb, deptname, manager, division, location from org order by location


```

Note that the database disappears after we stop the Docker machine. To avoid this, mount an external drive, and
start the Docker image created by `run` as a daemon.

```

docker run --name db2 -d -it -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept -v  $(pwd)/dbstore:/dbstore ibmcom/db2express-c:latest db2start



```

`Default DB2 database path                       (DFTDBPATH) = /home/db2inst1`

Container `/dbstore` maps to host `$(pwd)/dbstore`


Switch db volume to container `/dbstore` 


`docker exec -it db2 bash` to log into container shell

`chown db2inst1 /dbstore`
`su db2inst1`
`chmod u+rw,g+rw,o+rw /dbstore`
`db2 start dbm`
        `db2 update dbm cfg using  DFTDBPATH /dbstore`
        `db2 get dbm cfg |less`  (Visually verify "Default database path" path item)
`db2sampl -dbpath /dbstore`

`tar cvf /dbspace/sample.tar db2inst1` (Backup installed sample db to shared volume)

`tar xvf /dbspace/sample.tar` (Restore sample db to new container that has the shared volume)


At this point the container can be stopped and restarted without losing the smaple database. It sits in your
/dbspace directory.



-----------------------------------------------------------
