package net.runelite.client.eventbus;

import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.Event;
import net.runelite.client.config.OpenOSRSConfig;

@Slf4j
@Singleton
public class EventBus implements EventBusInterface
{
	private final Map<Object, Object> subscriptionList = new HashMap<>();
	private final Map<Class<?>, Relay<Object>> subjectList = new HashMap<>();
	private final Map<Object, CompositeDisposable> subscriptionsMap = new HashMap<>();

	@Inject
	private OpenOSRSConfig openOSRSConfig;

	@NonNull
	private <T extends Event> Relay<Object> getSubject(Class<T> eventClass)
	{
		return subjectList.computeIfAbsent(eventClass, k -> PublishRelay.create().toSerialized());
	}

	@NonNull
	private CompositeDisposable getCompositeDisposable(@NonNull Object object)
	{
		CompositeDisposable compositeDisposable = subscriptionsMap.get(object);
		if (compositeDisposable == null)
		{
			compositeDisposable = new CompositeDisposable();
			subscriptionsMap.put(object, compositeDisposable);
		}

		return compositeDisposable;
	}

	private <T> ObservableTransformer<T, T> applyTake(int until)
	{
		return observable -> until > 0 ? observable.take(until) : observable;
	}

	private <T> ObservableTransformer<T, T> applyScheduler(EventScheduler eventScheduler, boolean subscribe)
	{
		Scheduler scheduler = eventScheduler.get();

		return observable -> scheduler == null ? observable : subscribe ? observable.subscribeOn(scheduler) : observable.observeOn(scheduler);
	}

	@Override
	public <T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action)
	{
		subscribe(eventClass, lifecycle, action, -1, EventScheduler.DEFAULT, EventScheduler.DEFAULT);
	}

	@Override
	public <T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUtil)
	{
		subscribe(eventClass, lifecycle, action, takeUtil, EventScheduler.DEFAULT, EventScheduler.DEFAULT);
	}

	@Override
	// Subscribe on lifecycle (for example from plugin startUp -> shutdown)
	public <T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUntil, @Nullable EventScheduler subscribe, @Nullable EventScheduler observe)
	{
		assert Event.class.isAssignableFrom(eventClass) : "Parameters of methods annotated with @Subscribe should implement net.runelite.api.events.Event";

		if (subscriptionList.containsKey(lifecycle) && eventClass.equals(subscriptionList.get(lifecycle)))
		{
			return;
		}

		Disposable disposable = getSubject(eventClass)
			.compose(applyTake(takeUntil))
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.cast(eventClass) // Cast it for easier usage
			.doFinally(() -> unregister(lifecycle))
			.compose(applyScheduler(subscribe, true))
			.compose(applyScheduler(observe, false))
			.subscribe(action, error ->
				log.error("Exception in eventbus", error));

		getCompositeDisposable(lifecycle).add(disposable);
		subscriptionList.put(lifecycle, eventClass);
	}

	@Override
	public void unregister(@NonNull Object lifecycle)
	{
		//We have to remove the composition from the map, because once you dispose it can't be used anymore
		CompositeDisposable compositeDisposable = subscriptionsMap.remove(lifecycle);
		subscriptionList.remove(lifecycle);
		if (compositeDisposable != null)
		{
			compositeDisposable.dispose();
		}
	}

	@Override
	public <T extends Event> void post(Class<? extends T> eventClass, @NonNull T event)
	{
		getSubject(eventClass).accept(event);
	}
}
