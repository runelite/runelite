/*
 * Copyright (c) 2018, UniquePassive <https://github.com/uniquepassive>
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
package net.runelite.mixins;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class PlayerIsFriendMixin implements RSClient
{
	@Shadow("friendCount")
	private static int friendCount;

	@Inject
	private static int oldFriendCount;

	@Inject
	private static Cache<String, Boolean> cachedFriends;

	@Inject
	private static Cache<String, Boolean> cachedOnlineFriends;

	@Copy("isFriended")
	private static boolean rs$isFriended(String name, boolean mustBeLoggedIn)
	{
		throw new IllegalStateException();
	}

	@Replace("isFriended")
	private static boolean rl$isFriended(String name, boolean mustBeLoggedIn)
	{
		if (name == null)
		{
			return false;
		}

		if (cachedFriends == null)
		{
			cachedFriends = CacheBuilder
				.newBuilder()
				.expireAfterAccess(1, TimeUnit.MINUTES)
				.build();

			cachedOnlineFriends = CacheBuilder
				.newBuilder()
				.expireAfterAccess(1, TimeUnit.MINUTES)
				.build();
		}

		if (oldFriendCount != friendCount)
		{
			cachedFriends.invalidateAll();
			cachedOnlineFriends.invalidateAll();

			oldFriendCount = friendCount;
		}

		Cache<String, Boolean> cache = mustBeLoggedIn ? cachedOnlineFriends : cachedFriends;
		Boolean isFriended = cache.getIfPresent(name);

		if (isFriended == null)
		{
			isFriended = rs$isFriended(name, mustBeLoggedIn);
			cache.put(name, isFriended);
		}

		return isFriended;
	}
}
