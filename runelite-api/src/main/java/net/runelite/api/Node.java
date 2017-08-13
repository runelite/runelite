/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

public class Node
{
	private final net.runelite.rs.api.Node node;

	public Node(net.runelite.rs.api.Node node)
	{
		this.node = node;
	}

	@Override
	public String toString()
	{
		return "Node{" + "node=" + node + '}';
	}

	public Node getNext()
	{
		return of(node.getNext());
	}

	public Node getPrev()
	{
		return of(node.getPrevious());
	}

	public long getHash()
	{
		return node.getHash();
	}

	public static final Node of(net.runelite.rs.api.Node node)
	{
		if (node == null)
		{
			return null;
		}

		if (node instanceof net.runelite.rs.api.Item)
		{
			return new Item((net.runelite.rs.api.Item) node);
		}

		if (node instanceof net.runelite.rs.api.Renderable)
		{
			return Renderable.of((net.runelite.rs.api.Renderable) node);
		}

		if (node instanceof net.runelite.rs.api.WidgetNode)
		{
			return new WidgetNode((net.runelite.rs.api.WidgetNode) node);
		}

		return new Node(node);
	}
}
