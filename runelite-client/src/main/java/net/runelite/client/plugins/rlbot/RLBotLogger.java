package net.runelite.client.plugins.rlbot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles logging for the RLBot plugin.
 * Provides methods for logging at different levels and writing to a log file.
 */
@Slf4j
public class RLBotLogger {
    
    /**
     * The path to the log file.
     */
    private final Path logPath;
    
    /**
     * Whether debug logging is enabled.
     */
    private final boolean debugEnabled;
    
    /**
     * Creates a new RLBotLogger.
     * 
     * @param debugEnabled Whether debug logging is enabled
     */
    public RLBotLogger(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
        this.logPath = Paths.get(RLBotConstants.LOG_FILE);
        
        // Create log directory if it doesn't exist
        try {
            Files.createDirectories(logPath.getParent());
        } catch (IOException e) {
            log.error("Failed to create log directory", e);
        }
    }
    
    /**
     * Logs an info message.
     * 
     * @param message The message to log
     */
    public void info(String message) {
        log.info(message);
        writeToLogFile("INFO", message);
    }
    
    /**
     * Logs an error message.
     * 
     * @param message The message to log
     */
    public void error(String message) {
        log.error(message);
        writeToLogFile("ERROR", message);
    }
    
    /**
     * Logs a warning message.
     * 
     * @param message The message to log
     */
    public void warn(String message) {
        log.warn(message);
        writeToLogFile("WARN", message);
    }
    
    /**
     * Logs a debug message if debug logging is enabled.
     * 
     * @param message The message to log
     */
    public void debug(String message) {
        if (debugEnabled) {
            log.debug(message);
            writeToLogFile("DEBUG", message);
        }
    }
    
    /**
     * Writes a message to the log file.
     * 
     * @param level The log level
     * @param message The message to log
     */
    private void writeToLogFile(String level, String message) {
        try {
            // Format: [TIMESTAMP] [LEVEL] MESSAGE
            String formattedMessage = String.format("[%s] [%s] %s%n",
                LocalDateTime.now().format(RLBotConstants.DATE_FORMAT),
                level,
                message);
            
            // Write to log file
            Files.write(
                logPath,
                formattedMessage.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            // Don't use the logger here to avoid infinite recursion
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
} 