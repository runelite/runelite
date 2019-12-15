package net.runelite.client.eventbus;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.schedulers.Schedulers;
import java.util.function.Supplier;
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
		return scheduler.get();
	}
}
