package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSSoundEffect
{
	@Import("toRawAudioNode")
	RSRawAudioNode toRawAudioNode();
}
