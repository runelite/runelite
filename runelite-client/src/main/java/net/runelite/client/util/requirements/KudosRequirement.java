package net.runelite.client.util.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Varbits;

@RequiredArgsConstructor
@Getter
public class KudosRequirement implements Requirement
{
	private final int kudos;

	@Override
	public String toString()
	{
		return kudos + " " + "Kudos";
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		int realKudos = client.getVar(Varbits.KUDOS);
		return realKudos >= kudos;
	}
}