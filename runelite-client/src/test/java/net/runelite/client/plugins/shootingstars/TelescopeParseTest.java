package net.runelite.client.plugins.shootingstars;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TelescopeParseTest
{

	private static final String[] MESSAGES = {
		"You see a shooting star! The star looks like it will land in Asgarnia in<br>the next 49 to 51 minutes.",
		"You see a shooting star! The star looks like it will land on Crandor<br>or Karamja in the next 9 to 11 minutes.",
		"You see a shooting star! The star looks like it will land in the Feldip<br>Hills or on the Isle of Souls in the next 1 hour 50 minutes to 1 hour<br>52 minutes.",
		"You see a shooting star! The star looks like it will land on Fossil<br>Island or on Mos Le'Harmless in the next 24 to 26 minutes.",
		"You see a shooting star! The star looks like it will land in the<br>Fremennik Lands or on Lunar Isle in the next 18 to 20 minutes.",
		"You see a shooting star! The star looks like it will land in Great<br>Kourend in the next 30 to 32 minutes.",
		"You see a shooting star! The star looks like it will land in Kandarin<br>in the next 1 to 3 minutes.",
		"You see a shooting star! The star looks like it will land in the Kebos<br>Lowlands in the next 1 hour 30 minutes to 1 hour 32 minutes.",
		"You see a shooting star! The star looks like it will land in the<br>Kharidian Desert in the next 57 to 59 minutes.",
		"You see a shooting star! The star looks like it will land in Misthalin in<br>the next 53 to 55 minutes.",
		"You see a shooting star! The star looks like it will land in Morytania<br>in the next 1 hour 27 minutes to 1 hour 29 minutes.",
		"You see a shooting star! The star looks like it will land in Piscatoris<br>or the Gnome Stronghold in the next 1 hour 37 minutes to 1 hour<br>39 minutes.",
		"You see a shooting star! The star looks like it will land in Tirannwn<br>in the next 1 hour 54 minutes to 1 hour 56 minutes.",
		"You see a shooting star! The star looks like it will land in the<br>Wilderness in the next 1 hour 48 minutes to 1 hour 50 minutes."
	};

	@Test
	public void testExtractRegion()
	{
		String locationStartBound = "You see a shooting star! The star looks like it will land";
		String timeStartBound = "in the next";

		for (String message : MESSAGES)
		{
			String cleanMessage = message.replaceAll("<br>", " ");
			int idx = cleanMessage.indexOf(locationStartBound);

			if (idx > -1)
			{
				int timeIdx = cleanMessage.indexOf(timeStartBound);
				String location = cleanMessage.substring(idx + locationStartBound.length() + 4, timeIdx).trim();
				String time = cleanMessage.substring(timeIdx + timeStartBound.length() + 1).trim();
				log.info("location={}, time={}", location, time);
			}
		}
	}
}
