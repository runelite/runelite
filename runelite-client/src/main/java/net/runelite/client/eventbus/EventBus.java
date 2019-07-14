package net.runelite.client.eventbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class EventBus implements EventBusInterface
{
	private Map<Class<?>, Relay<Object>> subjectList = new HashMap<>();
	private Map<Object, CompositeDisposable> subscriptionsMap = new HashMap<>();

	@NonNull
	private <T> Relay<Object> getSubject(Class<T> eventClass)
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
	public <T> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<T> action)
	{
		Disposable disposable = getSubject(eventClass)
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.cast(eventClass) // Cast it for easier usage
			.subscribe(action, error ->
			{
				log.error("Error in eventbus: {}", error.getMessage());
			});

		getCompositeDisposable(lifecycle).add(disposable);
	}

	@Override
	public void unregister(@NonNull Object lifecycle)
	{
		//We have to remove the composition from the map, because once you dispose it can't be used anymore
		CompositeDisposable compositeDisposable = subscriptionsMap.remove(lifecycle);
		if (compositeDisposable != null)
		{
			compositeDisposable.dispose();
		}
	}

	@Override
	public <T> void post(Class<T> eventClass, @NonNull Object event)
	{
		getSubject(eventClass).accept(event);
	}
}
