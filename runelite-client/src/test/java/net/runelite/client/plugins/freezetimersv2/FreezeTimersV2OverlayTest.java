package net.runelite.client.plugins.freezetimersv2;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.client.config.OpenOSRSConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import javax.inject.Inject;
import java.util.concurrent.ScheduledExecutorService;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FreezeTimersV2OverlayTest
{
	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private FreezeTimersV2Config config;

	@Inject
	private FreezeTimersV2Overlay timersOverlay;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testTimeHandler()
	{
		assertEquals("6.0", timersOverlay.formatTime(6000));
		assertEquals("0.7", timersOverlay.formatTime(744));
		assertEquals("14", timersOverlay.formatTime(14265));
		assertEquals("5:00", timersOverlay.formatTime(300000));
		assertEquals("37", timersOverlay.formatTime(37845));
		assertEquals("1.3", timersOverlay.formatTime(1345));
	}

}
