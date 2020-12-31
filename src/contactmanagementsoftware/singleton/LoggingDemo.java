package contactmanagementsoftware.singleton;

import java.time.Instant;

public class LoggingDemo {
    public static void main(String[] args) {
        Logger logger = LoggerSingleton.getInstance();
        logger.debug("debug message");
        logger.warning("warning message");
        logger.error("error message");
    }
}
