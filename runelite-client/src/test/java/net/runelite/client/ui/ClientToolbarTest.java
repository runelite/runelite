package net.runelite.client.ui;

import com.google.common.collect.ImmutableMap;
import net.runelite.client.plugins.Plugin;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientToolbarTest
{

	@InjectMocks
	private ClientToolbar clientToolbar;

	@Test
	public void testAddDefaultOptionsWithCustomOptions()
	{
		Runnable pluginDefinedRunnable = () ->
		{

		};
		NavigationButton navigationButton = NavigationButton.builder()
			.popup(ImmutableMap
				.<String, Runnable>builder()
				.put("Immutable Map", pluginDefinedRunnable)
				.build())
			.plugin(new Plugin()
			{
				@Override
				public String getName()
				{
					return "Test Plugin Name";
				}
			})
			.build();

		clientToolbar.addDefaultOptions(navigationButton);

		assertTrue("Doesn't contain plugin defined popup", navigationButton.getPopup().containsKey("Immutable Map"));
		assertEquals("Plugin defined popup isn't mapped to plugin defined runnable", navigationButton.getPopup().get("Immutable Map"), pluginDefinedRunnable);
		assertTrue("Doesn't contain Configuration", navigationButton.getPopup().containsKey(ClientToolbar.CONFIGURATION));
		assertTrue("Doesn't contain Wiki", navigationButton.getPopup().containsKey(ClientToolbar.WIKI));
	}

	@Test
	public void testAddDefaultOptionsWithNoCustomOptions()
	{
		NavigationButton navigationButton = NavigationButton.builder()
			.plugin(new Plugin()
			{
				@Override
				public String getName()
				{
					return "Test Plugin Name";
				}
			})
			.build();

		clientToolbar.addDefaultOptions(navigationButton);

		assertTrue("Doesn't contain Configuration", navigationButton.getPopup().containsKey(ClientToolbar.CONFIGURATION));
		assertTrue("Doesn't contain Wiki", navigationButton.getPopup().containsKey(ClientToolbar.WIKI));
		assertEquals("Expected only two options defined", 2, navigationButton.getPopup().size());
	}

}