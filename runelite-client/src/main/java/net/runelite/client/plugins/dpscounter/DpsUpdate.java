package net.runelite.client.plugins.dpscounter;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.runelite.http.api.ws.messages.party.PartyMemberMessage;

@Value
@EqualsAndHashCode(callSuper = true)
public class DpsUpdate extends PartyMemberMessage
{
	private int npcId;
	private int hit;
}
