/*
 * Copyright (c) 2018, Mantautas Jurksa <https://github.com/Juzzed>
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
package net.runelite.client.plugins.woodcutting;

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Map;
import lombok.Getter;
import static net.runelite.api.ObjectID.TREE;
import static net.runelite.api.ObjectID.TREE_1277;
import static net.runelite.api.ObjectID.TREE_1278;
import static net.runelite.api.ObjectID.TREE_1279;
import static net.runelite.api.ObjectID.TREE_1280;
import static net.runelite.api.ObjectID.OAK_TREE;
import static net.runelite.api.ObjectID.OAK_TREE_4540;
import static net.runelite.api.ObjectID.OAK_10820;
import static net.runelite.api.ObjectID.WILLOW;
import static net.runelite.api.ObjectID.WILLOW_10833;
import static net.runelite.api.ObjectID.WILLOW_10831;
import static net.runelite.api.ObjectID.MAPLE_TREE;
import static net.runelite.api.ObjectID.MAPLE_TREE_10832;
import static net.runelite.api.ObjectID.TEAK;
import static net.runelite.api.ObjectID.MAHOGANY;
import static net.runelite.api.ObjectID.YEW;
import static net.runelite.api.ObjectID.MAGIC_TREE_10834;
import static net.runelite.api.ObjectID.REDWOOD;
import static net.runelite.api.ObjectID.REDWOOD_29669;
import static net.runelite.api.ObjectID.REDWOOD_29671;
import static net.runelite.api.ObjectID.REDWOOD_29670;

@Getter
enum Tree
{
	REGULAR_TREES(Duration.ofSeconds(WoodcuttingTimersOverlay.TREE_MAX_RESPAWN_TIME), TREE, TREE_1277, TREE_1278, TREE_1279, TREE_1280),
	OAK_TREES(Duration.ofMillis(8500), OAK_TREE, OAK_TREE_4540, OAK_10820),
	WILLOW_TREES(Duration.ofMillis(8500), WILLOW, WILLOW_10833, WILLOW_10831),
	MAPLE_TREES(Duration.ofSeconds(35), MAPLE_TREE, MAPLE_TREE_10832),
	TEAK_TREES(Duration.ofMillis(8500), TEAK),
	MAHOGANY_TREES(Duration.ofMillis(8500), MAHOGANY),
	YEW_TREES(Duration.ofMinutes(1), YEW),
	MAGIC_TREES(Duration.ofMinutes(2), MAGIC_TREE_10834),
	REDWOODS(Duration.ofMinutes(2), REDWOOD, REDWOOD_29669, REDWOOD_29670, REDWOOD_29671);

	private final Duration respawnTime;
	private final int[] treeIds;

	Tree(Duration respawnTime, int... treeIds)
	{
		this.respawnTime = respawnTime;
		this.treeIds = treeIds;
	}

	private static final Map<Integer, Tree> TREES;

	static
	{
		ImmutableMap.Builder<Integer, Tree> builder = new ImmutableMap.Builder<>();

		for (Tree tree : values())
		{
			for (int treeId : tree.treeIds)
			{
				builder.put(treeId, tree);
			}
		}

		TREES = builder.build();
	}

	static Tree findTree(int objectId)
	{
		return TREES.get(objectId);
	}
}