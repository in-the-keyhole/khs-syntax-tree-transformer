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

```

docker run --name db2 -d -it -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept -v  $(pwd)/dbstore:/dbstore ibmcom/db2express-c:latest db2start
docker exet -it db2 bash

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

/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/bin/java -Didea.launcher.port=7536 "-Didea.launcher.bin.path=/Users/mauget/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/163.10154.41/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/lib/tools.jar:/Users/mauget/IdeaProjects/khs-syntax-tree-transformer/target/classes:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-starter-eureka/1.1.0.M4/spring-cloud-starter-eureka-1.1.0.M4.jar:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-starter/1.1.0.M4/spring-cloud-starter-1.1.0.M4.jar:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-context/1.1.0.M4/spring-cloud-context-1.1.0.M4.jar:/Users/mauget/.m2/repository/org/springframework/security/spring-security-crypto/4.0.3.RELEASE/spring-security-crypto-4.0.3.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-commons/1.1.0.M4/spring-cloud-commons-1.1.0.M4.jar:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-netflix-core/1.1.0.M4/spring-cloud-netflix-core-1.1.0.M4.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot/1.3.1.RELEASE/spring-boot-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.3.1.RELEASE/spring-boot-autoconfigure-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/com/netflix/eureka/eureka-client/1.3.4/eureka-client-1.3.4.jar:/Users/mauget/.m2/repository/org/codehaus/jettison/jettison/1.3.7/jettison-1.3.7.jar:/Users/mauget/.m2/repository/stax/stax-api/1.0.1/stax-api-1.0.1.jar:/Users/mauget/.m2/repository/com/netflix/netflix-commons/netflix-eventbus/0.1.2/netflix-eventbus-0.1.2.jar:/Users/mauget/.m2/repository/com/netflix/archaius/archaius-core/0.7.1/archaius-core-0.7.1.jar:/Users/mauget/.m2/repository/commons-configuration/commons-configuration/1.8/commons-configuration-1.8.jar:/Users/mauget/.m2/repository/javax/ws/rs/jsr311-api/1.1.1/jsr311-api-1.1.1.jar:/Users/mauget/.m2/repository/com/netflix/servo/servo-core/0.10.0/servo-core-0.10.0.jar:/Users/mauget/.m2/repository/com/netflix/servo/servo-internal/0.10.0/servo-internal-0.10.0.jar:/Users/mauget/.m2/repository/com/sun/jersey/jersey-core/1.19/jersey-core-1.19.jar:/Users/mauget/.m2/repository/com/sun/jersey/jersey-client/1.19/jersey-client-1.19.jar:/Users/mauget/.m2/repository/com/sun/jersey/contribs/jersey-apache-client4/1.19/jersey-apache-client4-1.19.jar:/Users/mauget/.m2/repository/org/apache/httpcomponents/httpclient/4.5.1/httpclient-4.5.1.jar:/Users/mauget/.m2/repository/org/apache/httpcomponents/httpcore/4.4.4/httpcore-4.4.4.jar:/Users/mauget/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/mauget/.m2/repository/com/google/inject/guice/4.0/guice-4.0.jar:/Users/mauget/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/Users/mauget/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/Users/mauget/.m2/repository/com/netflix/governator/governator-annotations/1.10.4/governator-annotations-1.10.4.jar:/Users/mauget/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.4/jackson-annotations-2.6.4.jar:/Users/mauget/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.4/jackson-core-2.6.4.jar:/Users/mauget/.m2/repository/org/springframework/cloud/spring-cloud-starter-ribbon/1.1.0.M4/spring-cloud-starter-ribbon-1.1.0.M4.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon/2.1.0/ribbon-2.1.0.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon-transport/2.1.0/ribbon-transport-2.1.0.jar:/Users/mauget/.m2/repository/io/reactivex/rxnetty-contexts/0.4.9/rxnetty-contexts-0.4.9.jar:/Users/mauget/.m2/repository/io/reactivex/rxnetty-servo/0.4.9/rxnetty-servo-0.4.9.jar:/Users/mauget/.m2/repository/com/netflix/hystrix/hystrix-core/1.4.21/hystrix-core-1.4.21.jar:/Users/mauget/.m2/repository/io/reactivex/rxnetty/0.4.9/rxnetty-0.4.9.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon-core/2.1.0/ribbon-core-2.1.0.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon-httpclient/2.1.0/ribbon-httpclient-2.1.0.jar:/Users/mauget/.m2/repository/com/netflix/netflix-commons/netflix-commons-util/0.1.1/netflix-commons-util-0.1.1.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon-loadbalancer/2.1.0/ribbon-loadbalancer-2.1.0.jar:/Users/mauget/.m2/repository/com/netflix/netflix-commons/netflix-statistics/0.1.1/netflix-statistics-0.1.1.jar:/Users/mauget/.m2/repository/io/reactivex/rxjava/1.0.14/rxjava-1.0.14.jar:/Users/mauget/.m2/repository/com/netflix/ribbon/ribbon-eureka/2.1.0/ribbon-eureka-2.1.0.jar:/Users/mauget/.m2/repository/com/netflix/eureka/eureka2-client-shaded/2.0.0-rc.2/eureka2-client-shaded-2.0.0-rc.2.jar:/Users/mauget/.m2/repository/io/netty/netty-codec-http/4.0.25.Final/netty-codec-http-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-codec/4.0.25.Final/netty-codec-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-handler/4.0.25.Final/netty-handler-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-transport-native-epoll/4.0.25.Final/netty-transport-native-epoll-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-common/4.0.25.Final/netty-common-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-buffer/4.0.25.Final/netty-buffer-4.0.25.Final.jar:/Users/mauget/.m2/repository/io/netty/netty-transport/4.0.25.Final/netty-transport-4.0.25.Final.jar:/Users/mauget/.m2/repository/com/thoughtworks/xstream/xstream/1.4.2/xstream-1.4.2.jar:/Users/mauget/.m2/repository/xmlpull/xmlpull/1.1.3.1/xmlpull-1.1.3.1.jar:/Users/mauget/.m2/repository/xpp3/xpp3_min/1.1.4c/xpp3_min-1.1.4c.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-data-jpa/1.3.1.RELEASE/spring-boot-starter-data-jpa-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter/1.3.1.RELEASE/spring-boot-starter-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.3.1.RELEASE/spring-boot-starter-logging-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar:/Users/mauget/.m2/repository/ch/qos/logback/logback-core/1.1.3/logback-core-1.1.3.jar:/Users/mauget/.m2/repository/org/slf4j/jul-to-slf4j/1.7.13/jul-to-slf4j-1.7.13.jar:/Users/mauget/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.13/log4j-over-slf4j-1.7.13.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-aop/1.3.1.RELEASE/spring-boot-starter-aop-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-aop/4.2.4.RELEASE/spring-aop-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/aspectj/aspectjweaver/1.8.7/aspectjweaver-1.8.7.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/1.3.1.RELEASE/spring-boot-starter-jdbc-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/apache/tomcat/tomcat-jdbc/8.0.30/tomcat-jdbc-8.0.30.jar:/Users/mauget/.m2/repository/org/apache/tomcat/tomcat-juli/8.0.30/tomcat-juli-8.0.30.jar:/Users/mauget/.m2/repository/org/springframework/spring-jdbc/4.2.4.RELEASE/spring-jdbc-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/hibernate/hibernate-entitymanager/4.3.11.Final/hibernate-entitymanager-4.3.11.Final.jar:/Users/mauget/.m2/repository/org/jboss/logging/jboss-logging/3.3.0.Final/jboss-logging-3.3.0.Final.jar:/Users/mauget/.m2/repository/org/jboss/logging/jboss-logging-annotations/1.2.0.Beta1/jboss-logging-annotations-1.2.0.Beta1.jar:/Users/mauget/.m2/repository/org/hibernate/hibernate-core/4.3.11.Final/hibernate-core-4.3.11.Final.jar:/Users/mauget/.m2/repository/antlr/antlr/2.7.7/antlr-2.7.7.jar:/Users/mauget/.m2/repository/org/jboss/jandex/1.1.0.Final/jandex-1.1.0.Final.jar:/Users/mauget/.m2/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar:/Users/mauget/.m2/repository/xml-apis/xml-apis/1.0.b2/xml-apis-1.0.b2.jar:/Users/mauget/.m2/repository/org/hibernate/common/hibernate-commons-annotations/4.0.5.Final/hibernate-commons-annotations-4.0.5.Final.jar:/Users/mauget/.m2/repository/org/hibernate/javax/persistence/hibernate-jpa-2.1-api/1.0.0.Final/hibernate-jpa-2.1-api-1.0.0.Final.jar:/Users/mauget/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/Users/mauget/.m2/repository/javax/transaction/javax.transaction-api/1.2/javax.transaction-api-1.2.jar:/Users/mauget/.m2/repository/org/springframework/data/spring-data-jpa/1.9.2.RELEASE/spring-data-jpa-1.9.2.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/data/spring-data-commons/1.11.2.RELEASE/spring-data-commons-1.11.2.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-orm/4.2.4.RELEASE/spring-orm-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-context/4.2.4.RELEASE/spring-context-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-tx/4.2.4.RELEASE/spring-tx-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-beans/4.2.4.RELEASE/spring-beans-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.13/jcl-over-slf4j-1.7.13.jar:/Users/mauget/.m2/repository/org/springframework/spring-aspects/4.2.4.RELEASE/spring-aspects-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-web/1.3.1.RELEASE/spring-boot-starter-web-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/1.3.1.RELEASE/spring-boot-starter-tomcat-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/8.0.30/tomcat-embed-core-8.0.30.jar:/Users/mauget/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/8.0.30/tomcat-embed-el-8.0.30.jar:/Users/mauget/.m2/repository/org/apache/tomcat/embed/tomcat-embed-logging-juli/8.0.30/tomcat-embed-logging-juli-8.0.30.jar:/Users/mauget/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/8.0.30/tomcat-embed-websocket-8.0.30.jar:/Users/mauget/.m2/repository/org/springframework/boot/spring-boot-starter-validation/1.3.1.RELEASE/spring-boot-starter-validation-1.3.1.RELEASE.jar:/Users/mauget/.m2/repository/org/hibernate/hibernate-validator/5.2.2.Final/hibernate-validator-5.2.2.Final.jar:/Users/mauget/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/Users/mauget/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.4/jackson-databind-2.6.4.jar:/Users/mauget/.m2/repository/org/springframework/spring-web/4.2.4.RELEASE/spring-web-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-webmvc/4.2.4.RELEASE/spring-webmvc-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-expression/4.2.4.RELEASE/spring-expression-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/spring-core/4.2.4.RELEASE/spring-core-4.2.4.RELEASE.jar:/Users/mauget/.m2/repository/org/yaml/snakeyaml/1.16/snakeyaml-1.16.jar:/Users/mauget/.m2/repository/com/h2database/h2/1.4.190/h2-1.4.190.jar:/Users/mauget/.m2/repository/org/apache/velocity/velocity/1.7/velocity-1.7.jar:/Users/mauget/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/Users/mauget/.m2/repository/commons-lang/commons-lang/2.4/commons-lang-2.4.jar:/Users/mauget/.m2/repository/io/springfox/springfox-swagger2/2.5.0/springfox-swagger2-2.5.0.jar:/Users/mauget/.m2/repository/io/swagger/swagger-annotations/1.5.9/swagger-annotations-1.5.9.jar:/Users/mauget/.m2/repository/io/swagger/swagger-models/1.5.9/swagger-models-1.5.9.jar:/Users/mauget/.m2/repository/io/springfox/springfox-spi/2.5.0/springfox-spi-2.5.0.jar:/Users/mauget/.m2/repository/io/springfox/springfox-core/2.5.0/springfox-core-2.5.0.jar:/Users/mauget/.m2/repository/io/springfox/springfox-schema/2.5.0/springfox-schema-2.5.0.jar:/Users/mauget/.m2/repository/io/springfox/springfox-swagger-common/2.5.0/springfox-swagger-common-2.5.0.jar:/Users/mauget/.m2/repository/io/springfox/springfox-spring-web/2.5.0/springfox-spring-web-2.5.0.jar:/Users/mauget/.m2/repository/com/google/guava/guava/18.0/guava-18.0.jar:/Users/mauget/.m2/repository/com/fasterxml/classmate/1.3.1/classmate-1.3.1.jar:/Users/mauget/.m2/repository/org/slf4j/slf4j-api/1.7.13/slf4j-api-1.7.13.jar:/Users/mauget/.m2/repository/org/springframework/plugin/spring-plugin-core/1.2.0.RELEASE/spring-plugin-core-1.2.0.RELEASE.jar:/Users/mauget/.m2/repository/org/springframework/plugin/spring-plugin-metadata/1.2.0.RELEASE/spring-plugin-metadata-1.2.0.RELEASE.jar:/Users/mauget/.m2/repository/org/mapstruct/mapstruct/1.0.0.Final/mapstruct-1.0.0.Final.jar:/Users/mauget/.m2/repository/com/google/code/gson/gson/2.7/gson-2.7.jar:/Users/mauget/IdeaProjects/khs-syntax-tree-transformer/lib/db2jcc4.jar:/Users/mauget/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/163.10154.41/IntelliJ IDEA.app/Contents/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain khs.transformer.util.CheckDb2Connection
21:53:41.895 [main] INFO  k.t.util.CheckDb2Connection - jdbc:db2://0.0.0.0:50000/sample
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

```




```




-----------------------------------------------------------
