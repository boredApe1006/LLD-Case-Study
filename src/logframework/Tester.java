package logframework;

import logframework.data.LogLevel;
import logframework.logger.Logger;
import logframework.logger.LoggerFactory;

public class Tester {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger();
        logger.log(LogLevel.ERROR, "DB QUERY FAILED");
    }
}
