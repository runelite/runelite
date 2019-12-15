package net.runelite.client.eventbus;

import com.google.common.collect.ImmutableSet;
import io.reactivex.functions.Consumer;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import static java.lang.invoke.MethodType.methodType;
import java.lang.reflect.Method;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.Event;

@Slf4j
public class AccessorGenerator
{
	public static Set<Subscription> scanSubscribes(Lookup caller, Object ref)
	{
		ImmutableSet.Builder<Subscription> builder = ImmutableSet.builder();

		final Class<?> refClass = ref.getClass();
		caller = getPrivateAccess(refClass, caller).in(refClass);

		for (Method method : refClass.getDeclaredMethods())
		{
			Subscribe sub = method.getAnnotation(Subscribe.class);
			if (sub != null)
			{
				final Consumer accessor;
				final Class paramType = method.getParameterTypes()[0];

				try
				{
					accessor = getConsumerFor(caller, ref, method);
				}
				catch (Throwable t)
				{
					log.warn("Creating consumer lambda for {} failed!", method, t);
					continue;
				}

				builder.add(new Subscription(paramType, accessor, sub.takeUntil(), sub.subscribe(), sub.observe()));
			}
		}
		return builder.build();
	}

	@SuppressWarnings("unchecked")
	private static <EVENT extends Event> Consumer<EVENT> getConsumerFor(Lookup caller, Object ref, Method method) throws Throwable
	{
		final MethodHandle methodHandle = caller.unreflect(method);

		final MethodType actualConsumer  = methodHandle.type().dropParameterTypes(0, 1);
		final MethodType eventsConsumer = actualConsumer.erase();
		final MethodType factoryType = methodType(Consumer.class, ref.getClass());

		final CallSite callsite = LambdaMetafactory.metafactory(
			caller,                 // To get past security checks
			"accept",  // The name of the method to implement inside the lambda type
			factoryType,            // Signature of the factory method
			eventsConsumer,         // Signature of function implementation
			methodHandle,           // Target method
			actualConsumer          // Target method signature
		);

		final MethodHandle factory = callsite.getTarget();
		return (Consumer<EVENT>) factory.invoke(ref);
	}

	private static Lookup getPrivateAccess(Class<?> into, Lookup from)
	{
		try
		{
			return MethodHandles.privateLookupIn(into, from);
		}
		catch (IllegalAccessException a)
		{
			log.warn("Failed to get private access in {} from {}", into, from, a);
			return from;
		}
	}
}
