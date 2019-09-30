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
package net.runelite.api;

import java.util.function.Predicate;

/**
 * A query to search the game for objects that match.
 *
 * @param <EntityType> the returned object type
 * @param <QueryType>  the query type
 */
public abstract class Query<EntityType, QueryType, QR extends QueryResults>
{
	protected Predicate<EntityType> predicate = x -> true;

	protected Query()
	{
	}

	/**
	 * Executes the query and filters through possible objects, returning only
	 * those who evaluate true using {@link #predicate}.
	 *
	 * @param client the game client
	 * @return the matching objects
	 */
	public abstract QR result(Client client);

	/**
	 * Constructs and returns a predicate that will evaluate {@link #predicate}
	 * and the passed value.
	 *
	 * @param other the passed predicate
	 * @return the combined predicate
	 */
	protected Predicate<EntityType> and(Predicate<EntityType> other)
	{
		if (predicate == null)
		{
			return other;
		}
		return predicate.and(other);
	}
}
