package org.zengzuo613.log4j2.jdk;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class FileAppenderSyncBenchmark {

    static Logger fileLogger;
    static final Random RANDOM= new Random();
    static final double OUTPUT_EXCEPTION_PROBABILITY = 0.2;

    @Setup
    public void setUp() throws Exception {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
        fileLogger = LogManager.getLogger("FileLogger");
    }

    @TearDown
    public void tearDown() {
        System.clearProperty("log4j.configurationFile");
    }

    public void outputLog(Logger logger){
        if (RANDOM.nextDouble() < OUTPUT_EXCEPTION_PROBABILITY) {
            logger.debug(Const.MSG_HAVE_100_CHARS, Const.THROWABLE_HAVE_100_STACK);
        } else {
            logger.debug(Const.MSG_HAVE_100_CHARS);
        }
    }

    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Benchmark
    public void syncFileLogger() {
        outputLog(fileLogger);
    }

    // JDK-21 -jar target/benchmarks.jar "FileAppenderSyncBenchmark.*" -jvmArgs "-Xmx2g -Xms2g" -f 2 -t 16 -w 10 -wi 2 -r 30 -i 2 -to 300 -prof gc -rf json

}
