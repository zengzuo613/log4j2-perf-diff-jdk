# Introduction

This repository uses JMH to evaluate the performance of Log4j2 synchronous logging across different JDK versions.

## 1. Usage

### 1.1 Evaluation using JDK 21

Use the main branch

```bash
mvn clean
mvn install
{JAVA_HOME}/jdk-21/bin/java -jar target/benchmarks.jar "FileAppenderSyncBenchmark.*" -jvmArgs "-Xmx2g -Xms2g" -f 2 -t 16 -w 10 -wi 2 -r 30 -i 2 -to 300 -prof gc -rf json
```


### 1.2 Evaluation using JDK 8

Switch to the jdk1.8 branch

```bash
mvn clean
mvn install
{JAVA_HOME}/jdk-8/bin/java -jar target/benchmarks.jar "FileAppenderSyncBenchmark.*" -jvmArgs "-Xmx2g -Xms2g" -f 2 -t 16 -w 10 -wi 2 -r 30 -i 2 -to 300 -prof gc -rf json
```