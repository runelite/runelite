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
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import static net.runelite.api.NullObjectID.NULL_10835;
import static net.runelite.api.NullObjectID.NULL_10823;
import static net.runelite.api.ObjectID.*;
import static net.runelite.client.util.RSTimeUnit.GAME_TICKS;

@Getter
@SuppressWarnings("PMD.UnnecessaryFullyQualifiedName")
enum Tree
{
	REGULAR_TREE(null, TREE, TREE_1277, TREE_1278, TREE_1279, TREE_1280, TREE_40750, TREE_40752),
	OAK_TREE(Duration.of(14, GAME_TICKS), OAK_TREE_4540, OAK_TREE_10820),
	WILLOW_TREE(Duration.of(14, GAME_TICKS), WILLOW_TREE_10819, WILLOW_TREE_10829, WILLOW_TREE_10831, WILLOW_TREE_10833),
	MAPLE_TREE(Duration.of(59, GAME_TICKS), MAPLE_TREE_10832, MAPLE_TREE_36681, MAPLE_TREE_40754)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MISCELLANIA_REGION ? Duration.of(14, GAME_TICKS) : super.respawnTime;
			}
		},
	TEAK_TREE(Duration.of(15, GAME_TICKS), ObjectID.TEAK_TREE, TEAK_TREE_36686, TEAK_TREE_40758),
	MAHOGANY_TREE(Duration.of(14, GAME_TICKS), ObjectID.MAHOGANY_TREE, MAHOGANY, MAHOGANY_TREE_40760),
	YEW_TREE(Duration.of(99, GAME_TICKS), YEW_TREE_10822, NULL_10823, YEW_TREE_36683, YEW_TREE_40756),
	MAGIC_TREE(Duration.of(199, GAME_TICKS), MAGIC_TREE_10834, NULL_10835),
	REDWOOD(Duration.of(199, GAME_TICKS), REDWOOD_TREE, REDWOOD_TREE_29670, NullObjectID.NULL_34633, NullObjectID.NULL_34635, NullObjectID.NULL_34637, NullObjectID.NULL_34639, ObjectID.REDWOOD_TREE_34284, ObjectID.REDWOOD_TREE_34286, ObjectID.REDWOOD_TREE_34288, ObjectID.REDWOOD_TREE_34290);

	@Nullable
	private final Duration respawnTime;
	private final int[] treeIds;

	Tree(Duration respawnTime, int... treeIds)
	{
		this.respawnTime = respawnTime;
		this.treeIds = treeIds;
	}

	private static final int MISCELLANIA_REGION = 10044;
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

	Duration getRespawnTime(int region)
	{
		return respawnTime;
	}

	static Tree findTree(int objectId)
	{
		return TREES.get(objectId);
	}
}