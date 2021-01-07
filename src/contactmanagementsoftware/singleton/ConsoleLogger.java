package contactmanagementsoftware.singleton;

import java.time.LocalDateTime;

import static contactmanagementsoftware.singleton.LoggerSingleton.isDebugModeEnabled;

public class ConsoleLogger implements Logger {

    @Override
    public void error(String msg) {
        System.out.print("Contact Management System [" + LocalDateTime.now() + "] [ERROR]: ");
        System.out.println(msg);
    }

    @Override
    public void warning(String msg) {
        System.out.print("Contact Management System [" + LocalDateTime.now() + "] [WARNING]: ");
        System.out.println(msg);
    }

    @Override
    public void debug(String msg) {
        if (!isDebugModeEnabled()) return;
        System.out.print("Contact Management System [" + LocalDateTime.now() + "] [DEBUG]: ");
        System.out.println(msg);
    }
}