package net.runelite.http.api.ws.messages.party;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PartyMemberMessage extends PartyMessage
{
	private UUID memberId;
}
