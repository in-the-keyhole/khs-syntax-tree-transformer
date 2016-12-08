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
-----------------------------------------------------------
