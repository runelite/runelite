package net.runelite.client.eventbus;

import io.reactivex.functions.Consumer;
import lombok.Value;

@Value
public class Subscription
{
	private final Class type;
	private final Consumer method;
	private final int takeUntil;
	private final EventScheduler subscribe;
	private final EventScheduler observe;

	@SuppressWarnings("unchecked")
	public void subscribe(EventBus eventBus, Object lifecycle)
	{
		eventBus.subscribe(type, lifecycle, method, takeUntil, subscribe, observe);
	}
}