package net.runelite.deob.deobfuscators.rename.graph;

public enum EdgeType
{
	INVOKE,
	GETFIELD,
	SETFIELD,
	
	INVOKED_FROM,
	GETFIELD_FROM,
	SETFIELD_FROM;
}
