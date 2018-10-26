/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.twitch.irc;

import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MessageTest
{
	@Test
	public void testParse()
	{
		Message message = Message.parse("@badges=subscriber/0;color=;display-name=kappa_kid_;emotes=;id=6539b42a-e945-4a83-a5b7-018149ca9fa7;mod=0;room-id=27107346;subscriber=1;tmi-sent-ts=1535926830652;turbo=0;user-id=33390095;user-type= :kappa_kid_!kappa_kid_@kappa_kid_.tmi.twitch.tv PRIVMSG #b0aty :how do u add charges to that zeah book?");
		Map<String, String> messageTags = message.getTags();
		assertEquals("subscriber/0", messageTags.get("badges"));
		assertEquals("kappa_kid_!kappa_kid_@kappa_kid_.tmi.twitch.tv", message.getSource());
		assertEquals("PRIVMSG", message.getCommand());
		assertEquals("#b0aty", message.getArguments()[0]);
		assertEquals("how do u add charges to that zeah book?", message.getArguments()[1]);

		message = Message.parse("@badges=moderator/1,subscriber/12,bits/10000;color=#008000;display-name=Am_Sephiroth;emotes=;id=7d516b7c-de7a-4c8b-ad23-d8880b55d46b;login=am_sephiroth;mod=1;msg-id=subgift;msg-param-months=8;msg-param-recipient-display-name=IntRS;msg-param-recipient-id=189672346;msg-param-recipient-user-name=intrs;msg-param-sender-count=215;msg-param-sub-plan-name=Sick\\sNerd\\sSubscription\\s;msg-param-sub-plan=1000;room-id=49408183;subscriber=1;system-msg=Am_Sephiroth\\sgifted\\sa\\sTier\\s1\\ssub\\sto\\sIntRS!\\sThey\\shave\\sgiven\\s215\\sGift\\sSubs\\sin\\sthe\\schannel!;tmi-sent-ts=1535980032939;turbo=0;user-id=69539403;user-type=mod :tmi.twitch.tv USERNOTICE #sick_nerd");
		messageTags = message.getTags();
		assertEquals("Am_Sephiroth gifted a Tier 1 sub to IntRS! They have given 215 Gift Subs in the channel!", messageTags.get("system-msg"));
	}
}