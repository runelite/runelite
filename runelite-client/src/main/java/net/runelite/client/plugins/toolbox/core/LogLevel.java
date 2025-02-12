package net.runelite.client.plugins.toolbox.core;

import ch.qos.logback.classic.Level;

public enum LogLevel {
    TRACE(Level.TRACE),
    DEBUG(Level.DEBUG),
    INFO(Level.INFO),
    WARN(Level.WARN),
    ERROR(Level.ERROR),
    FATAL(Level.ERROR), // Logback does not have a FATAL level, so we map it to ERROR
    OFF(Level.OFF);

    private final Level level;

    LogLevel(Level level) {
        this.level = level;
    }

    public Level toLogbackLevel() {
        return level;
    }

    public static LogLevel fromString(String level) {
        try {
            return LogLevel.valueOf(level.toUpperCase());
        } catch (IllegalArgumentException e) {
            return INFO; // Default log level
        }
    }
}