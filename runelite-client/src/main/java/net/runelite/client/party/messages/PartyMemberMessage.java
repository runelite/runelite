package net.runelite.client.party.messages;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PartyMemberMessage extends PartyMessage
{
	private UUID memberId;
}
