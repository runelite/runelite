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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles logging for the RLBot plugin.
 * Provides methods for logging at different levels and writing to a log file.
 */
@Slf4j
@Singleton
public class RLBotLogger {
    
    private final RLBotConfig config;
    private final Logger logger;
    
    /**
     * Creates a new RLBotLogger with dependency injection.
     * 
     * @param config The plugin configuration
     */
    @Inject
    public RLBotLogger(RLBotConfig config) {
        this.config = config;
        this.logger = LoggerFactory.getLogger(RLBotLogger.class);
        logger.info("RLBot logger initialized at: {}", LocalDateTime.now());
    }
    
    /**
     * Logs an info message.
     * 
     * @param message The message to log
     */
    public void info(String message) {
        logger.info(message);
    }
    
    /**
     * Logs an error message.
     * 
     * @param message The message to log
     */
    public void error(String message) {
        logger.error(message);
    }
    
    /**
     * Logs a warning message.
     * 
     * @param message The message to log
     */
    public void warn(String message) {
        logger.warn(message);
    }
    
    /**
     * Logs a debug message if debug logging is enabled.
     * 
     * @param message The message to log
     */
    public void debug(String message) {
        if (config.debugLogging()) {
            logger.debug(message);
        }
    }
    
    /**
     * Logs an error message with an exception.
     * 
     * @param message The message to log
     * @param throwable The exception to log
     */
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
} 