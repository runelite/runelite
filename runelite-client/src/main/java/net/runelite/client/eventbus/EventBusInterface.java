package net.runelite.client.eventbus;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import net.runelite.api.events.Event;

public interface EventBusInterface
{
	<T> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action);

	<T> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUntil);

	void unregister(@NonNull Object lifecycle);

	<T> void post(Class<T> eventClass, @NonNull Event event);
}
