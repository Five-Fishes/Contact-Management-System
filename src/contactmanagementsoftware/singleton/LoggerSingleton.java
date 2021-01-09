package contactmanagementsoftware.singleton;

import java.io.IOException;
import java.util.Properties;

public class LoggerSingleton {

    private static final ConsoleLogger consoleLogger = new ConsoleLogger();
    private static final FileLogger fileLogger = new FileLogger();

    public static Logger getInstance() {
        if (isFileLoggingEnabled()) return fileLogger;
        return consoleLogger;
    }

    public static boolean isDebugModeEnabled() {
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream("logger.properties"));
            String fileLoggingValue = p.getProperty("debug");
            return fileLoggingValue.equalsIgnoreCase("ON");
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isFileLoggingEnabled() {
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream("logger.properties"));
            String fileLoggingValue = p.getProperty("FileLogging");
            return fileLoggingValue.equalsIgnoreCase("ON");
        } catch (IOException e) {
            return false;
        }
    }
}