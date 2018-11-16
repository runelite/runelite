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
package net.runelite.http.service.updatecheck;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update-check")
@Slf4j
public class UpdateCheckService
{
	private boolean updateAvailable;

	@RequestMapping
	public boolean check()
	{
		return updateAvailable;
	}

	@Scheduled(fixedDelay = 60_000)
	public void scheduledCheck()
	{
		updateAvailable = checkUpdate();
	}

	private int getRevision() throws IOException
	{
		RSConfig config = ClientConfigLoader.fetch();

		for (String value : config.getAppletProperties().values())
		{
			// http://www.runescape.com/g=oldscape/slr.ws?order=LPWM&ep=176
			if (value.contains("slr.ws"))
			{
				HttpUrl url = HttpUrl.parse(value);
				String revstr = url.queryParameter("ep");
				int rev = Integer.parseInt(revstr);
				return rev;
			}
		}

		return -1;
	}

	private boolean checkUpdate()
	{
		int rev;
		try
		{
			rev = getRevision();
		}
		catch (IOException e)
		{
			log.warn("error checking revision", e);
			return false;
		}

		if (rev == -1)
		{
			log.warn("Unable to parse revision from config!");
			return false;
		}

		int thisRevision = RuneLiteAPI.getRsVersion();
		return rev != thisRevision;
	}
}
