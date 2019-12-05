package net.runelite.client.eventbus;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import net.runelite.api.events.Event;

public interface EventBusInterface
{
	<T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action);

	<T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUntil);

	<T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUntil, EventScheduler subscribe, EventScheduler observe);

	void unregister(@NonNull Object lifecycle);

	<T extends Event> void post(Class<? extends T> eventClass, @NonNull T event);
}
