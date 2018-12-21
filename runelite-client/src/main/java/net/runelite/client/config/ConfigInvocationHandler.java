/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.config;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ConfigInvocationHandler implements InvocationHandler
{
	private final ConfigManager manager;

	public ConfigInvocationHandler(ConfigManager manager)
	{
		this.manager = manager;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Class<?> iface = proxy.getClass().getInterfaces()[0];

		ConfigGroup group = iface.getAnnotation(ConfigGroup.class);
		ConfigItem item = method.getAnnotation(ConfigItem.class);

		if (group == null)
		{
			log.warn("Configuration proxy class {} has no @ConfigGroup!", proxy.getClass());
			return null;
		}

		if (item == null)
		{
			log.warn("Configuration method {} has no @ConfigItem!", method);
			return null;
		}

		if (args == null)
		{
			// Getting configuration item
			String value = manager.getConfiguration(group.value(), item.keyName());

			if (value == null)
			{
				if (method.isDefault())
				{
					return callDefaultMethod(proxy, method, null);
				}

				return null;
			}

			// Convert value to return type
			Class<?> returnType = method.getReturnType();
			
			try
			{
				return ConfigManager.stringToObject(value, returnType);
			}
			catch (Exception e)
			{
				log.warn("Unable to unmarshal {}.{} ", group.value(), item.keyName(), e);
				if (method.isDefault())
				{
					return callDefaultMethod(proxy, method, null);
				}
				return null;
			}
		}
		else
		{
			// Setting a configuration value

			if (args.length != 1)
			{
				throw new RuntimeException("Invalid number of arguents to configuration method");
			}

			Object newValue = args[0];

			Class<?> type = method.getParameterTypes()[0];
			Object oldValue = manager.getConfiguration(group.value(), item.keyName(), type);

			if (Objects.equals(oldValue, newValue))
			{
				// nothing to do
				return null;
			}

			if (method.isDefault())
			{
				Object defaultValue = callDefaultMethod(proxy, method, args);

				if (Objects.equals(newValue, defaultValue))
				{
					// Just unset if it goes back to the default
					manager.unsetConfiguration(group.value(), item.keyName());
					return null;
				}
			}

			if (newValue == null)
			{
				manager.unsetConfiguration(group.value(), item.keyName());
			}
			else
			{
				String newValueStr = ConfigManager.objectToString(newValue);
				manager.setConfiguration(group.value(), item.keyName(), newValueStr);
			}
			return null;
		}
	}

	static Object callDefaultMethod(Object proxy, Method method, Object[] args) throws Throwable
	{
		// Call the default method implementation - https://rmannibucau.wordpress.com/2014/03/27/java-8-default-interface-methods-and-jdk-dynamic-proxies/
		Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
		constructor.setAccessible(true);

		Class<?> declaringClass = method.getDeclaringClass();
		return constructor.newInstance(declaringClass, MethodHandles.Lookup.PUBLIC | MethodHandles.Lookup.PRIVATE)
			.unreflectSpecial(method, declaringClass)
			.bindTo(proxy)
			.invokeWithArguments(args);
	}
}
