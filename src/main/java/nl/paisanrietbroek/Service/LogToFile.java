package nl.paisanrietbroek.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */
@Service
public class LogToFile {

    private Logger logger;
    private FileHandler fileHandler;

    public LogToFile() throws IOException {

        this.fileHandler = new FileHandler("logFile.log");

        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);

        this.logger = Logger.getLogger(getClass().getName());
        this.logger.addHandler(fileHandler);

    }

    public void logWarningToFile(String message) throws IOException {
        this.logger.warning(message);
    }
}
