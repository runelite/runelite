package net.runelite.client.plugins.rlbot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import javax.inject.Inject;

/**
 * Handles logging for the RLBot plugin.
 * Provides methods for logging at different levels and writing to a log file.
 */
@Slf4j
@Singleton
public class RLBotLogger {
    
    // Log level constants
    private static final String LEVEL_INFO = "INFO";
    private static final String LEVEL_ERROR = "ERROR";
    private static final String LEVEL_WARN = "WARN";
    private static final String LEVEL_DEBUG = "DEBUG";
    
    /**
     * The path to the log file.
     */
    private final Path logPath;
    
    /**
     * The plugin configuration.
     */
    private final RLBotConfig config;
    
    /**
     * Creates a new RLBotLogger with dependency injection.
     * 
     * @param config The plugin configuration
     */
    @Inject
    public RLBotLogger(RLBotConfig config) {
        this.config = config;
        this.logPath = Paths.get(RLBotConstants.LOG_FILE);
        
        // Create log directory if it doesn't exist and ensure we can write to the log file
        try {
            Path logDir = logPath.getParent();
            
            // Make sure the log directory exists
            if (Files.notExists(logDir)) {
                Files.createDirectories(logDir);
                System.out.println("Created log directory: " + logDir);
            }
            
            // Log startup message to both file and console
            String startupMessage = "[STARTUP] RLBot logger initialized at: " + LocalDateTime.now().format(RLBotConstants.DATE_FORMAT);
            String logFilePathMessage = "[STARTUP] Log file location: " + logPath.toAbsolutePath();
            
            // Try to write directly to the log file to verify permissions
            try {
                if (!Files.exists(logPath)) {
                    Files.createFile(logPath);
                    System.out.println("Created new log file: " + logPath);
                }
                
                Files.write(
                    logPath,
                    (startupMessage + "\n" + logFilePathMessage + "\n").getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
                );
                
                System.out.println("Successfully wrote to log file: " + logPath);
            } catch (IOException e) {
                System.err.println("ERROR: Could not write to log file: " + e.getMessage());
                e.printStackTrace();
            }
            
            // Now use the SLF4J logging for the startup message
            log.info(startupMessage);
            log.info(logFilePathMessage);
            
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Failed to initialize logger: " + e.getMessage());
            e.printStackTrace();
            log.error("Failed to initialize logger", e);
        }
    }
    
    /**
     * Logs an info message.
     * 
     * @param message The message to log
     */
    public void info(String message) {
        log.info(message);
        writeToLogFile(LEVEL_INFO, message);
    }
    
    /**
     * Logs an error message.
     * 
     * @param message The message to log
     */
    public void error(String message) {
        log.error(message);
        writeToLogFile(LEVEL_ERROR, message);
    }
    
    /**
     * Logs a warning message.
     * 
     * @param message The message to log
     */
    public void warn(String message) {
        log.warn(message);
        writeToLogFile(LEVEL_WARN, message);
    }
    
    /**
     * Logs a debug message if debug logging is enabled.
     * 
     * @param message The message to log
     */
    public void debug(String message) {
        if (config.debugLogging()) {
            log.debug(message);
            writeToLogFile(LEVEL_DEBUG, message);
        }
    }
    
    /**
     * Writes a message to the log file.
     * 
     * @param level The log level
     * @param message The message to log
     */
    private void writeToLogFile(String level, String message) {
        // Format: [TIMESTAMP] [LEVEL] MESSAGE
        String formattedMessage = String.format("[%s] [%s] %s%n",
            LocalDateTime.now().format(RLBotConstants.DATE_FORMAT),
            level,
            message);
        
        // Write to log file - handle exception internally without try-catch
        writeToFile(formattedMessage);
    }
    
    /**
     * Writes content to the log file, handling exceptions internally.
     * 
     * @param content The content to write
     */
    private void writeToFile(String content) {
        try {
            Files.write(
                logPath,
                content.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            // Don't use the logger here to avoid infinite recursion
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
} 