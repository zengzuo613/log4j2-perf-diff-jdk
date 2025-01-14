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


### 1.2 Evaluation using JDK 1.8

Switch to the jdk1.8 branch

```bash
mvn clean
mvn install
{JAVA_HOME}/jdk-8/bin/java -jar target/benchmarks.jar "FileAppenderSyncBenchmark.*" -jvmArgs "-Xmx2g -Xms2g" -f 2 -t 16 -w 10 -wi 2 -r 30 -i 2 -to 300 -prof gc -rf json
```

## 2. result

1. Laptop configuration: I5-1350P CPU, 32GB DDR5 5200 RAM, and Samsung MZVL4512HBLU-00BLL 512GB SSD.
2. Log4j2 version is 2.24.3.
3. Perform three performance tests and calculate the average value.

| **JDK Version** | **Score**    | **gc.alloc.rate** | **gc.count** |
| --------------- | ------------ | ------------------------- | ------------ |
| JDK 21.05       | 33.08 ops/ms | 635.45 MB/sec             | 61.33        |
| JDK 1.8.171     | 47.65 ops/ms | 1,651.85 MB/sec           | 294          |

Please refer to the detailed configuration parameters and execution results：[jmh-result](jmh-result)