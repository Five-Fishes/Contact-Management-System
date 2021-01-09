package contactmanagementsoftware.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import static contactmanagementsoftware.singleton.LoggerSingleton.isDebugModeEnabled;

public class FileLogger implements Logger {

    @Override
    public void error(String msg) {
        try {
            FileWriter myWriter = new FileWriter("log.txt", true);
            myWriter.write("Contact Management System ["+ LocalDateTime.now() +"] [ERROR]: ");
            myWriter.write(msg);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Fail to log error with FileLogger");
        }
    }

    @Override
    public void warning(String msg) {
        try {
            FileWriter myWriter = new FileWriter("log.txt", true);
            myWriter.write("Contact Management System ["+ LocalDateTime.now() +"] [WARNING]: ");
            myWriter.write(msg);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Fail to log warning with FileLogger");
        }
    }

    @Override
    public void debug(String msg) {
        if (!isDebugModeEnabled()) return;
        try {
            FileWriter myWriter = new FileWriter("log.txt", true);
            myWriter.write("Contact Management System ["+ LocalDateTime.now() +"] [DEBUG]: ");
            myWriter.write(msg);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Fail to log debug with FileLogger");
        }
    }
}