/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.api.queries;

import net.runelite.api.Actor;
import net.runelite.api.Point;
import net.runelite.api.Query;

public abstract class ActorQuery<T extends Actor> extends Query<T>
{
	public ActorQuery names(String... names)
	{
		predicate = and(actor ->
		{
			for (String name : names)
			{
				String actorName = actor.getName();
				if (actorName != null && actorName.equals(name))
				{
					return true;
				}
			}
			return false;
		});
		return this;
	}

	public ActorQuery location(Point location)
	{
		predicate = and(actor -> actor.getLocalLocation().equals(location));
		return this;
	}

	public ActorQuery level(int level)
	{
		predicate = and(actor -> actor.getCombatLevel() == level);
		return this;
	}

	public ActorQuery animation(int animation)
	{
		predicate = and(actor -> actor.getAnimation() == animation);
		return this;
	}

	public ActorQuery interacting(Actor actor)
	{
		predicate = and(a -> a.getInteracting().equals(a));
		return this;
	}
}
