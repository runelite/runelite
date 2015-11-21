package net.runelite.rs.api;

public interface Node
{
	Node getNext();

	long getHash();

	Node getPrevious();
}
