package net.runelite.api.queries;

import net.runelite.api.Actor;
import net.runelite.api.Query;

public abstract class ActorQuery<T extends Actor> extends Query<T>
{
	public ActorQuery name(String... names)
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
}
