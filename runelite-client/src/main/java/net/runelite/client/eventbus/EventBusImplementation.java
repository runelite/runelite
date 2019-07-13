package net.runelite.client.eventbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import javax.inject.Singleton;

@Singleton
public class EventBusImplementation implements EventBus
{
	private final Relay<Object> bus = PublishRelay.create().toSerialized();

	@Override
	public void post(Object event)
	{
		if (this.bus.hasObservers())
		{
			this.bus.accept(event);
		}
	}

	@Override
	public <T> Observable<T> observableOfType(Class<T> eventClass)
	{
		return this.bus
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.filter(eventClass::isInstance) // We're only interested in a specific event class
			.cast(eventClass); // Cast it for easier usage
	}

	@Override
	public <T> Observable<Object> observableOfTypes(List<Class<T>> eventClasses)
	{
		return this.bus
			.filter(Objects::nonNull) // Filter out null objects, better safe than sorry
			.filter(event -> {
				for (Class eventClass : eventClasses)
				{
					if (eventClass.isInstance(event))
					{
						return true;
					}
				}

				return false;
			}); // We're only interested in a specific event classes
	}
}
