package net.runelite.client.eventbus;

import io.reactivex.annotations.Nullable;

public enum EventScheduler
{
	DEFAULT(null),
	COMPUTATION("computation"),
	IO("io"),
	NEWTHREAD("newThread"),
	SINGLE("single"),
	TRAMPOLINE("trampoline"),
	CLIENT("client");

	public final String scheduler;

	EventScheduler(@Nullable String scheduler)
	{
		this.scheduler = scheduler;
	}
}
