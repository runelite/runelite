package net.runelite.client.plugins.chatcommands;

	import lombok.Getter;
	import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EraseChatSettings
{
	NEITHER("Neither"),
	SINGLE_WPRD("Single Word"),
	WHOLE_LINE("Whole Line");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
