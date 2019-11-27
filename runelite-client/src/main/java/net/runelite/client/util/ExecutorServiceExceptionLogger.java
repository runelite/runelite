/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.util;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Wrapper for ${@link ScheduledExecutorService} that will log all uncaught exceptions as warning to console
 */
@RequiredArgsConstructor
public class ExecutorServiceExceptionLogger implements ScheduledExecutorService
{
	private final ScheduledExecutorService service;

	private static Runnable monitor(final Runnable command)
	{
		return RunnableExceptionLogger.wrap(command);
	}

	private static <V> Callable<V> monitor(final Callable<V> command)
	{
		return CallableExceptionLogger.wrap(command);
	}

	@NotNull
	@Override
	public <T> Future<T> submit(@NotNull Callable<T> task)
	{
		return service.submit(monitor(task));
	}

	@NotNull
	@Override
	public <T> Future<T> submit(@NotNull Runnable task, T result)
	{
		return service.submit(monitor(task), result);
	}

	@NotNull
	@Override
	public Future<?> submit(@NotNull Runnable task)
	{
		return service.submit(monitor(task));
	}

	@Override
	public void execute(@NotNull Runnable command)
	{
		service.execute(monitor(command));
	}

	// Everything below is direct proxy to provided executor service

	@Override
	public void shutdown()
	{
		service.shutdown();
	}

	@NotNull
	@Override
	public List<Runnable> shutdownNow()
	{
		return service.shutdownNow();
	}

	@Override
	public boolean isShutdown()
	{
		return service.isShutdown();
	}

	@Override
	public boolean isTerminated()
	{
		return service.isTerminated();
	}

	@Override
	public boolean awaitTermination(long timeout, @NotNull TimeUnit unit) throws InterruptedException
	{
		return service.awaitTermination(timeout, unit);
	}

	@NotNull
	@Override
	public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks) throws InterruptedException
	{
		return service.invokeAll(tasks);
	}

	@NotNull
	@Override
	public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) throws InterruptedException
	{
		return service.invokeAll(tasks, timeout, unit);
	}

	@NotNull
	@Override
	public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException
	{
		return service.invokeAny(tasks);
	}

	@Override
	public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		return service.invokeAny(tasks, timeout, unit);
	}

	@NotNull
	@Override
	public ScheduledFuture<?> schedule(@NotNull Runnable command, long delay, @NotNull TimeUnit unit)
	{
		return service.schedule(command, delay, unit);
	}

	@NotNull
	@Override
	public <V> ScheduledFuture<V> schedule(@NotNull Callable<V> callable, long delay, @NotNull TimeUnit unit)
	{
		return service.schedule(callable, delay, unit);
	}

	@NotNull
	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(@NotNull Runnable command, long initialDelay, long period, @NotNull TimeUnit unit)
	{
		return service.scheduleAtFixedRate(command, initialDelay, period, unit);
	}

	@NotNull
	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(@NotNull Runnable command, long initialDelay, long delay, @NotNull TimeUnit unit)
	{
		return service.scheduleWithFixedDelay(command, initialDelay, delay, unit);
	}
}
