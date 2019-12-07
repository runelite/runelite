package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TradeCrewmemberMode
{
	TRADE("Trade"),
	CHARTER("Charter"),
	OFF("Off");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
