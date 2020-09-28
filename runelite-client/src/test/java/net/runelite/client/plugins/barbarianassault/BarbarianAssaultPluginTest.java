package net.runelite.client.plugins.barbarianassault;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.Client;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BarbarianAssaultPluginTest
{

	@Mock
	@Bind
	private Client client;

	@Test
	public void testRegex()
	{
		String text = "(50) Defender";
		text = text.replaceAll("\\(.*\\) ", "");
		assertEquals("Defender", text);

		text = "(5) 00:00";
		text = text.replaceAll("\\(.*\\) ", "");
		assertEquals("00:00", text);
	}

	@Test
	public void testTimer()
	{
		final Timer timer = new Timer();

		final Round round = new Round(1, timer);
		assertTrue(round.getTimer().getRoundTime(false).toMillis() <= 1000);

		// 1st wave starts
		Wave wave = new Wave(client, 1, null, timer);
		assertTrue(wave.getTimeUntilCallChange() >= 29);
		assertTrue(wave.getTimer().getWaveTime().toMillis() <= 1000);

		sleep(5000);

		assertTrue(wave.getTimeUntilCallChange() <= 25);
		assertTrue(wave.getTimer().getWaveTime().toMillis() >= 5000);

		// 2nd wave starts
		timer.setWaveStartTime();
		wave = new Wave(client, 2, null, timer);
		assertTrue(wave.getTimeUntilCallChange() >= 29);
		assertTrue(wave.getTimer().getWaveTime().toMillis() <= 1000);
	}

	private void sleep(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch (InterruptedException ignored)
		{
		}
	}

}
