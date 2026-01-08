package net.runelite.client.party.messages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PartyMemberMessage extends PartyMessage
{
	private transient long memberId;
}
