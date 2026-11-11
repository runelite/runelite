package net.runelite.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.FileSize;
import net.runelite.client.util.DeduplicationFilter;

public class LogbackConfig extends ContextAwareBase implements Configurator
{
	@Override
	public void configure(LoggerContext loggerContext)
	{
		DeduplicationFilter deduplicationFilter = new DeduplicationFilter();
		deduplicationFilter.start();
		loggerContext.addTurboFilter(deduplicationFilter);

		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
		encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss zzz} [%thread] %-5level %logger{36} - %msg%n");
		encoder.setContext(loggerContext);
		encoder.start();

		ConsoleAppender<ILoggingEvent> stdout = new ConsoleAppender<>();
		stdout.setContext(loggerContext);
		stdout.setName("STDOUT");
		stdout.setEncoder(encoder);
		stdout.start();

		String userHome = System.getProperty("user.home");
		RollingFileAppender<ILoggingEvent> file = new RollingFileAppender<>();
		file.setName("FILE");
		file.setFile(userHome + "/.runelite/logs/client.log");
		file.setEncoder(encoder);
		file.setContext(loggerContext);

		SizeAndTimeBasedRollingPolicy<Object> policy = new SizeAndTimeBasedRollingPolicy<>();
		policy.setContext(loggerContext);
		policy.setParent(file);
		// daily rollover
		policy.setFileNamePattern(userHome + "/.runelite/logs/client_%d{yyyy-MM-dd}.%i.log");
		policy.setMaxFileSize(new FileSize(10 * FileSize.MB_COEFFICIENT));
		// keep 30 days' worth of history
		policy.setMaxHistory(30);
		policy.start();

		file.setRollingPolicy(policy);
		file.start();

		Logger root = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.INFO);
		root.addAppender(stdout);
		root.addAppender(file);
	}

}
