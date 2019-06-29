package net.runelite.mixins;

import net.runelite.api.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSNodeHashTable;

@Mixin(RSNodeHashTable.class)
public abstract class RSNodeHashTableMixin implements RSNodeHashTable
{
	@Inject
	@Override
	public Collection<Node> getNodes()
	{
		// Copied in RSWidgetMixin.getParentId to reduce allocations
		List<Node> nodes = new ArrayList<Node>();

		Node[] buckets = getBuckets();
		for (int i = 0; i < buckets.length; ++i)
		{
			Node node = buckets[i];

			// It looks like the first node in the bucket is always
			// a sentinel
			Node cur = node.getNext();
			while (cur != node)
			{
				nodes.add(cur);
				cur = cur.getNext();
			}
		}

		return nodes;
	}
}
