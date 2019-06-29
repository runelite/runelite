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
package net.runelite.client.callback;

import com.google.inject.Inject;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BooleanSupplier;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;

@Singleton
@Slf4j
public class ClientThread
{
	private ConcurrentLinkedQueue<BooleanSupplier> invokes = new ConcurrentLinkedQueue<>();

	@Inject
	private Client client;

	public void invoke(Runnable r)
	{
		invoke(() ->
		{
			r.run();
			return true;
		});
	}

	/**
	 * Will run r on the game thread, at a unspecified point in the future.
	 * If r returns false, r will be ran again, at a later point
	 */
	public void invoke(BooleanSupplier r)
	{
		if (client.isClientThread())
		{
			if (r.getAsBoolean())
			{
				invokes.add(r);
			}
			return;
		}

		invokeLater(r);
	}

	/**
	 * Will run r on the game thread after this method returns
	 * If r returns false, r will be ran again, at a later point
	 */
	public void invokeLater(Runnable r)
	{
		invokeLater(() ->
		{
			r.run();
			return true;
		});
	}

	public void invokeLater(BooleanSupplier r)
	{
		invokes.add(r);
	}

	void invoke()
	{
		assert client.isClientThread();
		Iterator<BooleanSupplier> ir = invokes.iterator();
		for (; ir.hasNext(); )
		{
			BooleanSupplier r = ir.next();
			boolean remove = true;
			try
			{
				remove = r.getAsBoolean();
			}
			catch (ThreadDeath d)
			{
				throw d;
			}
			catch (Throwable e)
			{
				log.warn("Exception in invoke", e);
			}
			if (remove)
			{
				ir.remove();
			}
		}
	}
}
