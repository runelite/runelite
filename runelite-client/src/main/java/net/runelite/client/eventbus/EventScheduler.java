package net.runelite.client.eventbus;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EventScheduler
{
	DEFAULT(() -> null),
	COMPUTATION(Schedulers::computation),
	IO(Schedulers::io),
	NEWTHREAD(Schedulers::newThread),
	SINGLE(Schedulers::single),
	TRAMPOLINE(Schedulers::trampoline),
	CLIENT(Schedulers::single);

	private Supplier<Scheduler> scheduler;

	@Nullable
	public Scheduler get()
	{
		try
		{
			return scheduler.get();
		}
		catch (Throwable ignored)
		{
		}

		return null;
	}
}
