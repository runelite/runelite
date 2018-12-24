/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ThreadSafe
public class EventBus
{
	@FunctionalInterface
	public interface SubscriberMethod
	{
		void invoke(Object event);
	}

	@Value
	private static class Subscriber
	{
		private final Object object;
		private final Method method;
		@EqualsAndHashCode.Exclude
		private final SubscriberMethod lamda;

		void invoke(final Object arg) throws Exception
		{
			if (lamda != null)
			{
				lamda.invoke(arg);
			}
			else
			{
				method.invoke(object, arg);
			}
		}
	}

	private final Consumer<Throwable> exceptionHandler;
	private ImmutableMultimap<Class, Subscriber> subscribers = ImmutableMultimap.of();

	/**
	 * Instantiates EventBus with default exception handler
	 */
	public EventBus()
	{
		this((e) -> log.warn("Uncaught exception in event subscriber", e));
	}

	/**
	 * Registers subscriber to EventBus. All methods in subscriber and it's parent classes are checked for
	 * {@link Subscribe} annotation and then added to map of subscriptions.
	 *
	 * @param object subscriber to register
	 * @throws IllegalArgumentException in case subscriber method name is wrong (correct format is 'on' + EventName
	 */
	public synchronized void register(@Nonnull final Object object)
	{
		final ImmutableMultimap.Builder<Class, Subscriber> builder = ImmutableMultimap.builder();

		if (subscribers != null)
		{
			builder.putAll(subscribers);
		}

		for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass())
		{
			for (final Method method : clazz.getDeclaredMethods())
			{
				final Subscribe sub = method.getAnnotation(Subscribe.class);

				if (sub == null)
				{
					continue;
				}

				Preconditions.checkArgument(method.getReturnType() == Void.TYPE, "@Subscribed method \"" + method + "\" cannot return a value");
				Preconditions.checkArgument(method.getParameterCount() == 1, "@Subscribed method \"" + method + "\" must take exactly 1 argument");
				Preconditions.checkArgument(!Modifier.isStatic(method.getModifiers()), "@Subscribed method \"" + method + "\" cannot be static");

				final Class<?> parameterClazz = method.getParameterTypes()[0];

				Preconditions.checkArgument(!parameterClazz.isPrimitive(), "@Subscribed method \"" + method + "\" cannot subscribe to primitives");
				Preconditions.checkArgument((parameterClazz.getModifiers() & (Modifier.ABSTRACT | Modifier.INTERFACE)) == 0, "@Subscribed method \"" + method + "\" cannot subscribe to polymorphic classes");

				for (Class<?> psc = parameterClazz.getSuperclass(); psc != null; psc = psc.getSuperclass())
				{
					if (subscribers.containsKey(psc))
					{
						throw new IllegalArgumentException("@Subscribed method \"" + method + "\" cannot subscribe to class which inherits from subscribed class \"" + psc + "\"");
					}
				}

				final String preferredName = "on" + parameterClazz.getSimpleName();
				Preconditions.checkArgument(method.getName().equals(preferredName), "Subscribed method " + method + " should be named " + preferredName);

				method.setAccessible(true);
				SubscriberMethod lambda = null;

				try
				{
					final MethodHandles.Lookup caller = privateLookupIn(clazz);
					final MethodType subscription = MethodType.methodType(void.class, parameterClazz);
					final MethodHandle target = caller.findVirtual(clazz, method.getName(), subscription);
					final CallSite site = LambdaMetafactory.metafactory(
						caller,
						"invoke",
						MethodType.methodType(SubscriberMethod.class, clazz),
						subscription.changeParameterType(0, Object.class),
						target,
						subscription);

					final MethodHandle factory = site.getTarget();
					lambda = (SubscriberMethod) factory.bindTo(object).invokeExact();
				}
				catch (Throwable e)
				{
					log.warn("Unable to create lambda for method {}", method, e);
				}

				final Subscriber subscriber = new Subscriber(object, method, lambda);
				builder.put(parameterClazz, subscriber);
				log.debug("Registering {} - {}", parameterClazz, subscriber);
			}
		}

		subscribers = builder.build();
	}

	/**
	 * Unregisters all subscribed methods from provided subscriber object.
	 *
	 * @param object object to unsubscribe from
	 */
	public synchronized void unregister(@Nonnull final Object object)
	{
		if (subscribers == null)
		{
			return;
		}

		final Multimap<Class, Subscriber> map = HashMultimap.create();
		map.putAll(subscribers);

		for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass())
		{
			for (final Method method : clazz.getDeclaredMethods())
			{
				final Subscribe sub = method.getAnnotation(Subscribe.class);

				if (sub == null)
				{
					continue;
				}

				final Class<?> parameterClazz = method.getParameterTypes()[0];
				map.remove(parameterClazz, new Subscriber(object, method, null));
			}
		}

		subscribers = ImmutableMultimap.copyOf(map);
	}

	/**
	 * Posts provided event to all registered subscribers. Subscriber calls are invoked immediately and in order
	 * in which subscribers were registered.
	 *
	 * @param event event to post
	 */
	public void post(@Nonnull final Object event)
	{
		for (final Subscriber subscriber : subscribers.get(event.getClass()))
		{
			try
			{
				subscriber.invoke(event);
			}
			catch (Exception e)
			{
				exceptionHandler.accept(e);
			}
		}
	}

	private static MethodHandles.Lookup privateLookupIn(Class clazz) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException
	{
		try
		{
			// Java 9+ has privateLookupIn method on MethodHandles, but since we are shipping and using Java 8
			// we need to access it via reflection. This is preferred way because it's Java 9+ public api and is
			// likely to not change
			final Method privateLookupIn = MethodHandles.class.getMethod("privateLookupIn", Class.class, MethodHandles.Lookup.class);
			return (MethodHandles.Lookup) privateLookupIn.invoke(null, clazz, MethodHandles.lookup());
		}
		catch (NoSuchMethodException e)
		{
			// In Java 8 we first do standard lookupIn class
			final MethodHandles.Lookup lookupIn = MethodHandles.lookup().in(clazz);

			// and then we mark it as trusted for private lookup via reflection on private field
			final Field modes = MethodHandles.Lookup.class.getDeclaredField("allowedModes");
			modes.setAccessible(true);
			modes.setInt(lookupIn, -1); // -1 == TRUSTED
			return lookupIn;
		}
	}
}
