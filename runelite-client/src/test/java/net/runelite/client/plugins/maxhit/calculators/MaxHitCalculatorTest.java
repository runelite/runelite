package net.runelite.client.plugins.maxhit.calculators;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.client.plugins.maxhit.calculators.testconfig.MagicMaxHitConfig;
import net.runelite.client.plugins.maxhit.calculators.testconfig.MaxHitConfig;
import net.runelite.client.plugins.maxhit.calculators.testconfig.MeleeMaxHitConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxHitCalculatorTest
{
	@Mock
	@Bind
	protected Client client;

	@Before
	public void setUp() throws Exception
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void calculate()
	{
		testMaxHitConfig(MagicMaxHitConfig.values());
		testMaxHitConfig(MeleeMaxHitConfig.values());
	}

	private void testMaxHitConfig(MaxHitConfig[] maxHitConfigs)
	{
		for (MaxHitConfig maxHitConfig : maxHitConfigs)
		{
			maxHitConfig.test(client);
		}
	}
}
