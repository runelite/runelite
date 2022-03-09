/*
 * Copyright (c) 2020, Brandt Hill <https://github.com/BrandtHill>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup(KingdomConfig.CONFIG_GROUP_NAME)
public interface KingdomConfig extends Config
{
	String CONFIG_GROUP_NAME = "kingdomofmiscellania";
	int MAX_COFFER = 7_500_000;
	int MAX_APPROVAL_PERCENT = 100;

	@ConfigItem(
		position = 1,
		keyName = "sendNotifications",
		name = "Send Notifications",
		description = "Send chat notifications upon login showing current estimated coffer and approval"
	)
	default boolean shouldSendNotifications()
	{
		return false;
	}

	@Range(
		max = MAX_COFFER
	)
	@ConfigItem(
		position = 2,
		keyName = "cofferThreshold",
		name = "Coffer Threshold",
		description = "Send notifications if coffer is below this value"
	)
	default int getCofferThreshold()
	{
		return MAX_COFFER;
	}

	@Range(
		max = MAX_APPROVAL_PERCENT
	)
	@ConfigItem(
		position = 3,
		keyName = "approvalThreshold",
		name = "Approval Threshold",
		description = "Send notifications if approval percentage is below this value"
	)
	default int getApprovalThreshold()
	{
		return MAX_APPROVAL_PERCENT;
	}
}
