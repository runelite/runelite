/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.input;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * PrioritizedListenerList is a thread-safe ordered set with fast iteration.
 */
public class PrioritizedListenerList<T extends PrioritizedListener> implements Set<T>
{
	// All access to this should be synchronized(this)
	private TreeSet<T> set;

	// Mutable reference to an immutable list
	private volatile List<T> list = null;

	public PrioritizedListenerList()
	{
		set = new TreeSet<>(Comparator
			.comparingInt(PrioritizedListener::getPriority)
			.thenComparingLong(Object::hashCode) // Compare hashCode to allow two things with the same priority
		);
	}

	private List<T> getList()
	{
		// Thread safe lazy init of list
		List<T> llist = list;
		if (llist == null)
		{
			synchronized (this)
			{
				llist = list;
				if (llist == null)
				{
					list = llist = Collections.unmodifiableList(new ArrayList<>(set));
				}
			}
		}
		return llist;
	}

	@Override
	public int size()
	{
		return getList().size();
	}

	@Override
	public boolean isEmpty()
	{
		return getList().isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return getList().contains(o);
	}

	@Override
	public Iterator<T> iterator()
	{
		return getList().iterator();
	}

	@Override
	public Object[] toArray()
	{
		return getList().toArray();
	}

	@Override
	public <T1> T1[] toArray(T1[] a)
	{
		return getList().toArray(a);
	}

	@Override
	public synchronized boolean add(T t)
	{
		boolean b = set.add(t);
		if (b)
		{
			list = null;
		}
		return b;
	}

	@Override
	public synchronized boolean remove(Object o)
	{
		boolean b = set.remove(o);
		if (b)
		{
			list = null;
		}
		return b;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return getList().containsAll(c);
	}

	@Override
	public synchronized boolean addAll(Collection<? extends T> c)
	{
		boolean b = set.addAll(c);
		if (b)
		{
			list = null;
		}
		return b;
	}

	@Override
	public synchronized boolean retainAll(Collection<?> c)
	{
		boolean b = set.retainAll(c);
		if (b)
		{
			list = null;
		}
		return b;
	}

	@Override
	public synchronized boolean removeAll(Collection<?> c)
	{
		boolean b = set.removeAll(c);
		if (b)
		{
			list = null;
		}
		return b;
	}

	@Override
	public synchronized void clear()
	{
		set.clear();
		list = null;
	}
}
