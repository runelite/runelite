package net.runelite.client.plugins.hideattack;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttackMode
{
	SWAP_ATTACK("Swap"),
	REMOVE_ATTACK("Remove"),
	OFF("Off");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
