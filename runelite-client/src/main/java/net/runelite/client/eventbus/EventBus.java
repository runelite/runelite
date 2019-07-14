package net.runelite.client.eventbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
public class EventBus
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

	public <T> void subscribe(Class<T> eventClass, @NonNull Object lifecycle, @NonNull Consumer<Object> action)
	{
		Disposable disposable = getSubject(eventClass).subscribe(action);
		getCompositeDisposable(lifecycle).add(disposable);
	}

	public void unregister(@NonNull Object lifecycle)
	{
		//We have to remove the composition from the map, because once you dispose it can't be used anymore
		CompositeDisposable compositeDisposable = subscriptionsMap.remove(lifecycle);
		if (compositeDisposable != null)
		{
			compositeDisposable.dispose();
		}
	}

	public <T> void post(Class<T> eventClass, @NonNull Object event)
	{
		getSubject(eventClass).accept(event);
	}
}
