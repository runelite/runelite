package net.runelite.http.api.ws.messages.party;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.events.Event;

@Getter
@Setter
public abstract class PartyMemberMessage extends PartyMessage implements Event
{
	private UUID memberId;
}
