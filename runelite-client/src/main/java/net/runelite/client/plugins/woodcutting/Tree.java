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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import static net.runelite.api.ObjectID.*;

@Getter
enum Tree
{
	NORMAL_TREE_SPAWN (TREE, TREE_1277, TREE_1278, TREE_1279, TREE_1280, DEAD_TREE, DEAD_TREE_1283, DEAD_TREE_1284, DEAD_TREE_1285, DEAD_TREE_1286, DEAD_TREE_1287, DEAD_TREE_1288, DEAD_TREE_1289, DEAD_TREE_1290,
	DEAD_TREE_1291, DEAD_TREE_1333, DEAD_TREE_1365, DEAD_TREE_1383, DEAD_TREE_1384, EVERGREEN_2091, EVERGREEN_2092),
	ACHEY_TREE_SPAWN (ACHEY_TREE),
	OAK_TREE_SPAWN (OAK),
	WILLOW_TREE_SPAWN (WILLOW, WILLOW_1756, WILLOW_1758, WILLOW_1760),
	TEAK_TREE_SPAWN (TEAK),
	JUNIPER_TREE_SPAWN (MATURE_JUNIPER_TREE),
	MAPLE_TREE_SPAWN (MAPLE_TREE),
	HALLOW_TREE_SPAWN (HOLLOW_TREE_1752, HOLLOW_TREE_1757),
	MAHOGANY_TREE_SPAWN (MAHOGANY),
	ARCTIC_PINE_TREE_SPAWN (ARCTIC_PINE),
	YEW_TREE_SPAWN (YEW, NULL_1754),
	MAGIC_TREE_SPAWN (MAGIC_TREE),
	REDWOOD_TREE_SPAWN (REDWOOD, REDWOOD_29669, REDWOOD_29670, REDWOOD_29671);

	private static final List<Integer> TREES = new ArrayList<>();
	private final List<Integer> treeIds;

	Tree(Integer... treeIds)
	{
		this.treeIds = Arrays.asList(treeIds);
	}

	static
	{
		for (Tree tree : values())
		{
			TREES.addAll(tree.getTreeIds());
		}
	}

	public static List<Integer> getTrees ()
	{
		return TREES;
	}
}