/*
 * Copyright (c) 2018, RSNinja <http://github.com/RSNinja>
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
package net.runelite.client.plugins.puzzlesolver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.widgets.Widget;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
enum SecurityStrongholdAnswer
{
	QUESTION_1("Secure my device and reset my RuneScape password."),
	QUESTION_2("Don't share your information and report the player."),
	QUESTION_3("Authenticator and two-step login on my registered email."),
	QUESTION_4("Nobody."),
	QUESTION_5("Don't tell them anything and click the 'Report Abuse' button."),
	QUESTION_6("Talk to any banker in RuneScape."),
	QUESTION_7("Don't give them my password."),
	QUESTION_8("Don't give out your password to anyone. Not even close friends."),
	QUESTION_9("Do not visit the website and report the player who messaged you."),
	QUESTION_10("Inform Jagex by emailing reportphishing@jagex.com."),
	QUESTION_11("Don't give out your password to anyone. Not even close friends."),
	QUESTION_12("Read the text and follow the advice given."),
	QUESTION_13("Only on the RuneScape website."),
	QUESTION_14("Through account settings on runescape.com."),
	QUESTION_15("Set up 2 step authentication with my email provider."),
	QUESTION_16("No way! You'll just take my gold for your own! Reported!."),
	QUESTION_17("Secure my device and reset my RuneScape password."),
	QUESTION_18("Don't type in my password backwards and report the player."),
	QUESTION_19("Report the stream as a scam. Real Jagex streams have a 'verified' mark."),
	QUESTION_20("Use the Account Recovery System."),
	QUESTION_21("Report the incident and do not click any links."),
	QUESTION_22("Don't click any links, forward the email to reportphishing@jagex.com."),
	QUESTION_23("Me."),
	QUESTION_24("The birthday of a famous person or event."),
	QUESTION_25("No, you should never allow anyone to level your account."),
	QUESTION_26("Only on the RuneScape website."),
	QUESTION_27("Virus scan my device then change my password."),
	QUESTION_28("No, you should never buy a RuneScape account."),
	QUESTION_29("No way! I'm reporting you to Jagex!"),
	QUESTION_30("No way! You'll just take my gold for your own! Reported!"),
	QUESTION_31("Politely tell them no and then use the 'Report Abuse' button."),
	QUESTION_32("No."),
	QUESTION_33("Report the player for phishing."),
	QUESTION_34("Don't give them the information and send an 'Abuse Report'.");

	private static final List<String> MATCHES = new ArrayList<>();

	static
	{
		for (SecurityStrongholdAnswer securityStrongholdAnswer : SecurityStrongholdAnswer.values())
		{
			MATCHES.add(securityStrongholdAnswer.answer);
		}
	}

	private final String answer;

	static Widget findCorrect(final Widget parent)
	{
		if (parent != null)
		{
			for (Widget child : parent.getDynamicChildren())
			{
				if (child == null)
					continue;
				if (MATCHES.contains(child.getText()))
					return child;
			}
		}

		return null;
	}
}
