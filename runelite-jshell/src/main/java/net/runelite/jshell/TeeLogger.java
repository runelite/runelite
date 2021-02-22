/*
 * Copyright (c) 2021 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.jshell;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

@SuppressWarnings("PlaceholderCountMatchesArgumentCount")
@RequiredArgsConstructor
public class TeeLogger implements Logger
{
	private static final String TRACE = "[TRACE] ";
	private static final String DEBUG = "[DEBUG] ";
	private static final String INFO = "[INFO] ";
	private static final String WARN = "[WARN] ";
	private static final String ERROR = "[ERROR] ";

	private final Logger delegate;
	private final Consumer<String> messageConsumer;

	@Override
	public String getName()
	{
		return "RLShell";
	}

	@Override
	public boolean isTraceEnabled()
	{
		return true;
	}

	private void log(String level, String message, Object... format)
	{
		FormattingTuple fmt = MessageFormatter.arrayFormat(message, format);
		StringBuilder msg = new StringBuilder();
		msg.append(level).append(fmt.getMessage());
		Throwable throwable = fmt.getThrowable();
		if (throwable != null)
		{
			msg.append("\n");
			var caw = new CharArrayWriter();
			try (PrintWriter pw = new PrintWriter(caw))
			{
				throwable.printStackTrace(pw);
			}
			msg.append(caw.toString());
		}
		messageConsumer.accept(msg.toString());
	}

	@Override
	public void trace(String msg)
	{
		delegate.trace(msg);
		log(TRACE, msg);
	}

	@Override
	public void trace(String format, Object arg)
	{
		delegate.trace(format, arg);
		log(TRACE, format, arg);
	}

	@Override
	public void trace(String format, Object arg1, Object arg2)
	{
		delegate.trace(format, arg1, arg2);
		log(TRACE, format, arg1, arg2);
	}

	@Override
	public void trace(String format, Object... arguments)
	{
		delegate.trace(format, arguments);
		log(TRACE, format, arguments);
	}

	@Override
	public void trace(String msg, Throwable t)
	{
		delegate.trace(msg, t);
		log(TRACE, msg, t);
	}

	@Override
	public boolean isTraceEnabled(Marker marker)
	{
		return true;
	}

	@Override
	public void trace(Marker marker, String msg)
	{
		delegate.trace(marker, msg);
		log(TRACE, msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg)
	{
		delegate.trace(marker, format, arg);
		log(TRACE, format, arg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2)
	{
		delegate.trace(marker, format, arg1, arg2);
		log(TRACE, format, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray)
	{
		delegate.trace(marker, format, argArray);
		log(TRACE, format, argArray);
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t)
	{
		delegate.trace(marker, msg, t);
		log(TRACE, msg, t);
	}

	@Override
	public boolean isDebugEnabled()
	{
		return true;
	}

	@Override
	public void debug(String msg)
	{
		delegate.debug(msg);
		log(DEBUG, msg);
	}

	@Override
	public void debug(String format, Object arg)
	{
		delegate.debug(format, arg);
		log(DEBUG, format, arg);
	}

	@Override
	public void debug(String format, Object arg1, Object arg2)
	{
		delegate.debug(format, arg1, arg2);
		log(DEBUG, format, arg1, arg2);
	}

	@Override
	public void debug(String format, Object... arguments)
	{
		delegate.debug(format, arguments);
		log(DEBUG, format, arguments);
	}

	@Override
	public void debug(String msg, Throwable t)
	{
		delegate.debug(msg, t);
		log(DEBUG, msg, t);
	}

	@Override
	public boolean isDebugEnabled(Marker marker)
	{
		return true;
	}

	@Override
	public void debug(Marker marker, String msg)
	{
		delegate.debug(marker, msg);
		log(DEBUG, msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg)
	{
		delegate.debug(marker, format, arg);
		log(DEBUG, format, arg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2)
	{
		delegate.debug(marker, format, arg1, arg2);
		log(DEBUG, format, arg1, arg2);
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments)
	{
		delegate.debug(marker, format, arguments);
		log(DEBUG, format, arguments);
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t)
	{
		delegate.debug(marker, msg, t);
		log(DEBUG, msg, t);
	}

	@Override
	public boolean isInfoEnabled()
	{
		return true;
	}

	@Override
	public void info(String msg)
	{
		delegate.info(msg);
		log(INFO, msg);
	}

	@Override
	public void info(String format, Object arg)
	{
		delegate.info(format, arg);
		log(INFO, format, arg);
	}

	@Override
	public void info(String format, Object arg1, Object arg2)
	{
		delegate.info(format, arg1, arg2);
		log(INFO, format, arg1, arg2);
	}

	@Override
	public void info(String format, Object... arguments)
	{
		delegate.info(format, arguments);
		log(INFO, format, arguments);
	}

	@Override
	public void info(String msg, Throwable t)
	{
		delegate.info(msg, t);
		log(INFO, msg, t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker)
	{
		return true;
	}

	@Override
	public void info(Marker marker, String msg)
	{
		delegate.info(marker, msg);
		log(INFO, msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg)
	{
		delegate.info(marker, format, arg);
		log(INFO, format, arg);
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2)
	{
		delegate.info(marker, format, arg1, arg2);
		log(INFO, format, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String format, Object... arguments)
	{
		delegate.info(marker, format, arguments);
		log(INFO, format, arguments);
	}

	@Override
	public void info(Marker marker, String msg, Throwable t)
	{
		delegate.info(marker, msg, t);
		log(INFO, msg, t);
	}

	@Override
	public boolean isWarnEnabled()
	{
		return true;
	}

	@Override
	public void warn(String msg)
	{
		delegate.warn(msg);
		log(WARN, msg);
	}

	@Override
	public void warn(String format, Object arg)
	{
		delegate.warn(format, arg);
		log(WARN, format, arg);
	}

	@Override
	public void warn(String format, Object... arguments)
	{
		delegate.warn(format, arguments);
		log(WARN, format, arguments);
	}

	@Override
	public void warn(String format, Object arg1, Object arg2)
	{
		delegate.warn(format, arg1, arg2);
		log(WARN, format, arg1, arg2);
	}

	@Override
	public void warn(String msg, Throwable t)
	{
		delegate.warn(msg, t);
		log(WARN, msg, t);
	}

	@Override
	public boolean isWarnEnabled(Marker marker)
	{
		return true;
	}

	@Override
	public void warn(Marker marker, String msg)
	{
		delegate.warn(marker, msg);
		log(WARN, msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg)
	{
		delegate.warn(marker, format, arg);
		log(WARN, format, arg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2)
	{
		delegate.warn(marker, format, arg1, arg2);
		log(WARN, format, arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments)
	{
		delegate.warn(marker, format, arguments);
		log(WARN, format, arguments);
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t)
	{
		delegate.warn(marker, msg, t);
		log(WARN, msg, t);
	}

	@Override
	public boolean isErrorEnabled()
	{
		return true;
	}

	@Override
	public void error(String msg)
	{
		delegate.error(msg);
		log(ERROR, msg);
	}

	@Override
	public void error(String format, Object arg)
	{
		delegate.error(format, arg);
		log(ERROR, format, arg);
	}

	@Override
	public void error(String format, Object arg1, Object arg2)
	{
		delegate.error(format, arg1, arg2);
		log(ERROR, format, arg1, arg2);
	}

	@Override
	public void error(String format, Object... arguments)
	{
		delegate.error(format, arguments);
		log(ERROR, format, arguments);
	}

	@Override
	public void error(String msg, Throwable t)
	{
		delegate.error(msg, t);
		log(ERROR, msg, t);
	}

	@Override
	public boolean isErrorEnabled(Marker marker)
	{
		return true;
	}

	@Override
	public void error(Marker marker, String msg)
	{
		delegate.error(marker, msg);
		log(ERROR, msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg)
	{
		delegate.error(marker, format, arg);
		log(ERROR, format, arg);
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2)
	{
		delegate.error(marker, format, arg1, arg2);
		log(ERROR, format, arg1, arg2);
	}

	@Override
	public void error(Marker marker, String format, Object... arguments)
	{
		delegate.error(marker, format, arguments);
		log(ERROR, format, arguments);
	}

	@Override
	public void error(Marker marker, String msg, Throwable t)
	{
		delegate.error(marker, msg, t);
		log(ERROR, msg, t);
	}
}
