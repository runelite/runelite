package net.runelite.client.util;

import java.util.concurrent.*;

public class Debouncer
{
	private final ConcurrentHashMap<Object, Future<?>> delayedMap = new ConcurrentHashMap<>();

	/**
	 * Debounces {@code callable} by {@code delay}, i.e., schedules it to be executed after {@code delay},
	 * or cancels its execution if the method is called with the same key within the {@code delay} again.
	 */
	public void debounce(final ScheduledExecutorService scheduler, final Object key, final Runnable runnable, long delay, TimeUnit unit)
	{
		final Future<?> prev = delayedMap.put(key, scheduler.schedule(() -> {
			try
			{
				runnable.run();
			}
			finally
			{
				delayedMap.remove(key);
			}
		}, delay, unit));
		if (prev != null)
		{
			prev.cancel(true);
		}
	}
}