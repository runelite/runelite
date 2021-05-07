package net.runelite.client.plugins.shootingstars;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@Slf4j
@AllArgsConstructor
@RunWith(Parameterized.class)
public class TelescopeParserTest
{

	@Parameters
	public static List<Object[]> testTable()
	{
		return Arrays.asList(new Object[][]{

				{
					"You see a shooting star! The star looks like it will land in Asgarnia in<br>the next 49 to 51 minutes.",
					StarRegion.ASGARNIA,
					Duration.parse("PT49M")
				},
				{
					"You see a shooting star! The star looks like it will land on Crandor<br>or Karamja in the next 9 to 11 minutes.",
					StarRegion.CRANDOR_KARAMJA,
					Duration.parse("PT9M")
				},
				{
					"You see a shooting star! The star looks like it will land in the Feldip<br>Hills or on the Isle of Souls in the next 1 hour 50 minutes to 1 hour<br>52 minutes.",
					StarRegion.FELDIP_HILLS,
					Duration.parse("PT1H50M")
				},
				{
					"You see a shooting star! The star looks like it will land on Fossil<br>Island or on Mos Le'Harmless in the next 24 to 26 minutes.",
					StarRegion.FOSSIL_ISLAND,
					Duration.parse("PT24M")
				},
				{
					"You see a shooting star! The star looks like it will land in the<br>Fremennik Lands or on Lunar Isle in the next 18 to 20 minutes.",
					StarRegion.FREMENNIK_LANDS,
					Duration.parse("PT18M")
				},
				{
					"You see a shooting star! The star looks like it will land in Great<br>Kourend in the next 30 to 32 minutes.",
					StarRegion.GREAT_KOUREND,
					Duration.parse("PT30M")
				},
				{
					"You see a shooting star! The star looks like it will land in Kandarin<br>in the next 1 to 3 minutes.",
					StarRegion.KANDARIN,
					Duration.parse("PT1M")
				},
				{
					"You see a shooting star! The star looks like it will land in the Kebos<br>Lowlands in the next 1 hour 30 minutes to 1 hour 32 minutes.",
					StarRegion.KEBOS_LOWLANDS,
					Duration.parse("PT1H30M")
				},
				{
					"You see a shooting star! The star looks like it will land in the<br>Kharidian Desert in the next 57 to 59 minutes.",
					StarRegion.KHARIDIAN_DESERT,
					Duration.parse("PT57M")
				},
				{
					"You see a shooting star! The star looks like it will land in Misthalin in<br>the next 53 to 55 minutes.",
					StarRegion.MISTHALIN,
					Duration.parse("PT53M")
				},
				{
					"You see a shooting star! The star looks like it will land in Morytania<br>in the next 1 hour 27 minutes to 1 hour 29 minutes.",
					StarRegion.MORYTANIA,
					Duration.parse("PT1H27M")
				},
				{
					"You see a shooting star! The star looks like it will land in Piscatoris<br>or the Gnome Stronghold in the next 1 hour 37 minutes to 1 hour<br>39 minutes.",
					StarRegion.PISCATORIS_GNOME_STRONGHOLD,
					Duration.parse("PT1H37M")
				},
				{
					"You see a shooting star! The star looks like it will land in Tirannwn<br>in the next 1 hour 54 minutes to 1 hour 56 minutes.",
					StarRegion.TIRANNWN,
					Duration.parse("PT1H54M")
				},
				{
					"You see a shooting star! The star looks like it will land in the<br>Wilderness in the next 1 hour 48 minutes to 1 hour 50 minutes.",
					StarRegion.WILDERNESS,
					Duration.parse("PT1H48M")
				}
			}
		);
	}

	private final String message;
	private final StarRegion expectedRegion;
	private final Duration expectedDuration;

	@Test
	public void testExtractRegion()
	{
		StarRegion region = TelescopeParser.extractStarRegion(message);
		assertEquals(expectedRegion, region);
	}

	@Test
	public void testExtractDuration()
	{
		Duration duration = TelescopeParser.extractDuration(message);
		assertEquals(expectedDuration, duration);
	}
}
