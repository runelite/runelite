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
package net.runelite.http.service.chat;

import java.util.regex.Pattern;
import com.google.common.base.Strings;
import net.runelite.http.api.chat.House;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController
{
	private static final Pattern STRING_VALIDATION = Pattern.compile("[^a-zA-Z0-9' -]");
	private static final int STRING_MAX_LENGTH = 50;

	@Autowired
	private ChatService chatService;

	@PostMapping("/layout")
	public void submitLayout(@RequestParam String name, @RequestParam String layout)
	{
		if (Strings.isNullOrEmpty(layout))
		{
			return;
		}

		chatService.setLayout(name, layout);
	}

	@GetMapping("/layout")
	public String getLayout(@RequestParam String name)
	{
		String layout = chatService.getLayout(name);
		if (layout == null)
		{
			throw new NotFoundException();
		}
		return layout;
	}

	@PostMapping("/hosts")
	public void submitHost(@RequestParam int world, @RequestParam String location, @RequestParam String owner, @RequestParam boolean guildedAltar, @RequestParam boolean occultAltar, @RequestParam boolean spiritTree, @RequestParam boolean fairyRing, @RequestParam boolean wildernessObelisk, @RequestParam boolean repairStand, @RequestParam boolean combatDummy, @RequestParam(required = false, defaultValue = "false") boolean remove)
	{
		if (!location.equals("Rimmington") && !location.equals("Yanille"))
		{
			return;
		}

		House house = new House();
		house.setOwner(owner);
		house.setGuildedAltarPresent(guildedAltar);
		house.setOccultAltarPresent(occultAltar);
		house.setSpiritTreePresent(spiritTree);
		house.setFairyRingPresent(fairyRing);
		house.setWildernessObeliskPresent(wildernessObelisk);
		house.setRepairStandPresent(repairStand);
		house.setCombatDummyPresent(combatDummy);

		if (remove)
		{
			chatService.removeHost(world, location, house);
		}
		else
		{
			chatService.addHost(world, location, house);
		}
	}

	@GetMapping("/hosts")
	public House[] getHosts(@RequestParam int world, @RequestParam String location)
	{
		return chatService.getHosts(world, location);
	}
}