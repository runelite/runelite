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
package net.runelite.client.util;

import com.google.common.io.ByteStreams;
import com.google.inject.Injector;
import com.google.inject.Key;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReflectUtil
{
	private static Set<Class<?>> annotationClasses = Collections.newSetFromMap(new WeakHashMap<>());

	public static MethodHandles.Lookup privateLookupIn(Class<?> clazz)
	{
		try
		{
			MethodHandles.Lookup caller;
			if (clazz.getClassLoader() instanceof PrivateLookupableClassLoader)
			{
				caller = ((PrivateLookupableClassLoader) clazz.getClassLoader()).getLookup();
			}
			else
			{
				caller = MethodHandles.lookup();
			}
			return MethodHandles.privateLookupIn(clazz, caller);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
	}

	public interface PrivateLookupableClassLoader
	{
		// define class is protected final so this needs a different name to become public
		Class<?> defineClass0(String name, byte[] b, int off, int len) throws ClassFormatError;

		MethodHandles.Lookup getLookup();

		void setLookup(MethodHandles.Lookup lookup);
	}

	/**
	 * Allows private Lookups to be created for classes in this ClassLoader
	 * <p>
	 * Due to JDK-8173978 it is impossible to create get a lookup with module scoped permissions when teleporting
	 * between modules. Since external plugins are loaded in a separate classloader to us they are contained in unique
	 * unnamed modules. Since we (via LambdaMetafactory) are creating a hidden class in that module, we require module
	 * scoped access to it, and since the methods can be private, we also require private access. The only way to get
	 * MODULE|PRIVATE is to either 1) invokedynamic in that class, 2) call MethodHandles.lookup() from that class, or
	 * 3) call privateLookupIn with an existing lookup with PRIVATE|MODULE created from a class in the same module.
	 * Our solution is to make classloaders call this method which will define a class in the classloader's unnamed
	 * module that calls MethodHandles.lookup() and stores it in the classloader for later use.
	 */
	public static void installLookupHelper(PrivateLookupableClassLoader cl)
	{
		String name = PrivateLookupHelper.class.getName();
		try (InputStream in = ReflectUtil.class.getResourceAsStream("/" + name.replace('.', '/') + ".class"))
		{
			byte[] classData = ByteStreams.toByteArray(in);
			Class<?> clazz = cl.defineClass0(name, classData, 0, classData.length);

			// force <clinit> to run
			clazz.getConstructor().newInstance();
		}
		catch (IOException | ReflectiveOperationException e)
		{
			throw new RuntimeException("unable to install lookup helper", e);
		}
	}

	public static class PrivateLookupHelper
	{
		static
		{
			PrivateLookupableClassLoader pcl = (PrivateLookupableClassLoader) PrivateLookupHelper.class.getClassLoader();
			pcl.setLookup(MethodHandles.lookup());
		}
	}

	public synchronized static void queueInjectorAnnotationCacheInvalidation(Injector injector)
	{
		if (annotationClasses == null)
		{
			return;
		}

		for (Key<?> key : injector.getAllBindings().keySet())
		{
			for (Class<?> clazz = key.getTypeLiteral().getRawType(); clazz != null; clazz = clazz.getSuperclass())
			{
				annotationClasses.add(clazz);
			}
		}
	}

	public synchronized static void invalidateAnnotationCaches()
	{
		try
		{
			for (Class<?> clazz : annotationClasses)
			{
				for (Method method : clazz.getDeclaredMethods())
				{
					uncacheAnnotations(method, Executable.class);
				}
				for (Field field : clazz.getDeclaredFields())
				{
					uncacheAnnotations(field, Field.class);
				}
				for (Constructor<?> constructor : clazz.getDeclaredConstructors())
				{
					uncacheAnnotations(constructor, Executable.class);
				}
			}
		}
		catch (Exception ex)
		{
			// this fails on newer Java versions which don't allow reflect into java.base
			log.debug(null, ex);
		}
		finally
		{
			annotationClasses.clear();
			annotationClasses = null;
		}
	}

	/**
	 * Java caches parsed annotations on AccessibleObjects in a LinkedHashMap for performance reasons.
	 * Since we don't use annotations much after startup, we can invalidate these caches.
	 *
	 * @param object
	 * @param declaredAnnotationsClazz
	 * @throws Exception
	 */
	private static void uncacheAnnotations(final Object object, Class<?> declaredAnnotationsClazz) throws Exception
	{
		if (object == null)
		{
			return;
		}

		Field declaredAnnotations = declaredAnnotationsClazz.getDeclaredField("declaredAnnotations");
		declaredAnnotations.setAccessible(true);

		synchronized (object)
		{
			Map<Class<? extends Annotation>, Annotation> m = (Map) declaredAnnotations.get(object);
			// AnnotationParser returns the shared empty map for methods with no runtime annotations,
			// so we can avoid nulling it in that case.
			if (m != null && m != Collections.<Class<? extends Annotation>, Annotation>emptyMap())
			{
				declaredAnnotations.set(object, null);
			}
		}

		// JDK11 shares the annotation map between the object and its root, so clear both;
		// JDK8 just has the annotations on object.
		Field rootField = object.getClass().getDeclaredField("root");
		rootField.setAccessible(true);

		final Object root = rootField.get(object);
		uncacheAnnotations(root, declaredAnnotationsClazz);
	}
}
