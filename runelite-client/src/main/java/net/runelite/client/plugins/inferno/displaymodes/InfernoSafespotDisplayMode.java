package net.runelite.client.plugins.inferno.displaymodes;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public enum InfernoSafespotDisplayMode
{
	OFF("Off"),
	INDIVIDUAL_TILES("Individual tiles"),
	AREA("Area (lower fps)");

	final private String name;

	InfernoSafespotDisplayMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
