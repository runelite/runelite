package net.runelite.client.ui.tweenengine;

import java.util.ArrayList;

/**
 * A light pool of objects that can be resused to avoid allocation.
 * Based on Nathan Sweet pool implementation
 */
abstract class Pool<T>
{
	private final ArrayList<T> objects;
	private final Callback<T> callback;

	protected abstract T create();

	public Pool(int initCapacity, Callback<T> callback)
	{
		this.objects = new ArrayList<T>(initCapacity);
		this.callback = callback;
	}

	public T get()
	{
		T obj = objects.isEmpty() ? create() : objects.remove(objects.size() - 1);
		if (callback != null) callback.onUnPool(obj);
		return obj;
	}

	public void free(T obj)
	{
		if (!objects.contains(obj))
		{
			if (callback != null) callback.onPool(obj);
			objects.add(obj);
		}
	}

	public void clear()
	{
		objects.clear();
	}

	public int size()
	{
		return objects.size();
	}

	public void ensureCapacity(int minCapacity)
	{
		objects.ensureCapacity(minCapacity);
	}

	public interface Callback<T>
	{
		public void onPool(T obj);

		public void onUnPool(T obj);
	}
}