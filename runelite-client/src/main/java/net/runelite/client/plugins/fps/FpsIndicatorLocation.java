package net.runelite.client.plugins.fps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FpsIndicatorLocation
{
	TOPRIGHT("Top right"),
	TOPLEFT("Top left");

	private final String location;

	@Override
	public String toString() { return location; }

}
