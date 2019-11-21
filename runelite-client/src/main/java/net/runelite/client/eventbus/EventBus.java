package net.runelite.client.eventbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.sentry.Sentry;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.Event;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.OpenOSRSConfig;

@Slf4j
@Singleton
public class EventBus implements EventBusInterface
{
	private Map<Object, Object> subscriptionList = new HashMap<>();
	private Map<Class<?>, Relay<Object>> subjectList = new HashMap<>();
	private Map<Object, CompositeDisposable> subscriptionsMap = new HashMap<>();

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

	@Override
	// Subscribe on lifecycle (for example from plugin startUp -> shutdown)
	public <T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action)
	{
		if (subscriptionList.containsKey(lifecycle) && eventClass.equals(subscriptionList.get(lifecycle)))
		{
			return;
		}

		Disposable disposable = getSubject(eventClass)
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.cast(eventClass) // Cast it for easier usage
			.subscribe(action, error ->
			{
				log.error("Exception in eventbus", error);

				if (RuneLiteProperties.getLauncherVersion() != null && openOSRSConfig.shareLogs())
				{
					Sentry.capture(error);
				}
			});

		getCompositeDisposable(lifecycle).add(disposable);
		subscriptionList.put(lifecycle, eventClass);
	}

	@Override
	public <T extends Event> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action, int takeUntil)
	{
		if (subscriptionList.containsKey(lifecycle) && eventClass.equals(subscriptionList.get(lifecycle)))
		{
			return;
		}

		Disposable disposable = getSubject(eventClass)
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.cast(eventClass) // Cast it for easier usage
			.take(takeUntil)
			.doFinally(() -> unregister(lifecycle))
			.subscribe(action, error ->
			{
				log.error("Exception in eventbus", error);

				if (RuneLiteProperties.getLauncherVersion() != null && openOSRSConfig.shareLogs())
				{
					Sentry.capture(error);
				}
			});

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
