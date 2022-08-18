package net.runelite.client.util;

import java.nio.file.Paths;
import java.nio.file.Path;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.util.FileSize;

import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.RollingPolicy;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

import org.slf4j.ILoggerFactory;

public class LoggerFactory {
	static String LOG_DIRECTORY = Paths.get(System.getProperty("user.home"), ".runelite", "logs").toString();
	static String threshold = "INFO";
	static String messageFormat = "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n";

	public static Logger getLogger(String loggerName)
	{
		ILoggerFactory loggerFactory = org.slf4j.LoggerFactory.getILoggerFactory();
		LoggerContext loggerContext = (LoggerContext) loggerFactory;
		loggerContext.reset();
		// ContextInitializer ci = new ContextInitializer(loggerContext);

		ThresholdFilter levelFilter = new ThresholdFilter();
		levelFilter.setLevel(threshold);
		levelFilter.start();
		
		PatternLayoutEncoder patternEncoder = new PatternLayoutEncoder();
		patternEncoder.setContext(loggerContext);
		patternEncoder.setPattern(messageFormat);
		patternEncoder.start();

		/* file output */
		RollingFileAppender file = new RollingFileAppender<ILoggingEvent>();
		file.setName("FILE");
		file.setFile(Paths.get(LOG_DIRECTORY, "client.log").toString());

		SizeAndTimeBasedRollingPolicy policy = new SizeAndTimeBasedRollingPolicy();
		policy.setMaxFileSize(new FileSize(10*1024*1024));  // 10 MiB
		policy.setMaxHistory(30);  // 30 days
		policy.setFileNamePattern(Paths.get(LOG_DIRECTORY, "client_%d{yyyy-MM-dd}.%i.log").toString());
		policy.start();

		file.setContext(loggerContext);
		file.setRollingPolicy(policy);
		file.addFilter(levelFilter);
		file.setEncoder(patternEncoder);
		
		file.start();

		/* stdout */
		ConsoleAppender stdout = new ConsoleAppender<ILoggingEvent>();
		stdout.setName("STDOUT");
		stdout.setContext(loggerContext);
		stdout.addFilter(levelFilter);
		stdout.setEncoder(patternEncoder);
		
		stdout.start();

		
		Logger logger = loggerContext.getLogger(loggerName);
		logger.setLevel(Level.DEBUG);

		logger.addAppender(file);
		logger.addAppender(stdout);

		return logger;
	}

	public static void setLogDirectory(Path path)
	{
		LOG_DIRECTORY = path.toString();
	}

	public static void setLogDirectory(String filename)
	{
		LOG_DIRECTORY = filename;
	}

	public static void setThreshold(String level)
	{
		threshold = level;
	}
}
