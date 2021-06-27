package net.runelite.client.plugins.corp;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.runelite.http.api.ws.messages.party.PartyMemberMessage;

@Value
@EqualsAndHashCode(callSuper = true)
public class CorpDamageUpdate extends PartyMemberMessage {
    private final int hit;
    private final int totalDamageSync;
}
