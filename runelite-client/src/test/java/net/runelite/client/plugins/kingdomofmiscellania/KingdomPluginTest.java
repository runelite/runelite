package net.runelite.client.plugins.kingdomofmiscellania;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.HashMap;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Item;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import net.runelite.http.api.item.ItemPrice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KingdomPluginTest {

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Inject
	KingdomPlugin kingdomPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testSalaries()
	{
		Kingdom basic = new Kingdom(10);
		Kingdom expansion = new Kingdom(15);

		basic.getSalary(475000,95);
		expansion.getSalary(1250000, 50);

		assertEquals(45125, basic.getEffectiveSalary());
		assertEquals(37500, expansion.getEffectiveSalary());
	}

	@Test
	public void testCalculateRewards()
	{
		Kingdom basic = new Kingdom(10);
		basic.getSalary(500000,100);
		basic.resourceDistribution = new HashMap<>();
		basic.resourceDistribution.put(ResourceType.FLAX, 10);

		Item flax = mock(Item.class);
		ItemPrice itemPrice = mock(ItemPrice.class);

		when(flax.getId()).thenReturn(ItemID.FLAX);
		when(itemManager.getItemPrice(flax.getId())).thenReturn(50000);
		kingdomPlugin.calculateRewards(basic);

		assertEquals(ResourceType.FLAX, basic.getPrimaryResource());
		assertEquals(1250*50000,basic.getPrimaryAmount());

	}

}
