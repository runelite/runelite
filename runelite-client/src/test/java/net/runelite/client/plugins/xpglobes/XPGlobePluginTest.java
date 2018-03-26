package net.runelite.client.plugins.xpglobes;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class XPGlobePluginTest
{
	@Inject
	private XpGlobesPlugin plugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private XpGlobesConfig config;


	private XpGlobe globe;
	private XpGlobe globeTwo;
	private XpGlobe globeThree;
	private List<XpGlobe> list;
	private Skill skill;

	private int MAX_LENGTH = 5;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		skill = Skill.MINING;
		when(config.disable99s()).thenReturn(true);
		globe = new XpGlobe(skill,13034431,99,14000000 );
		globeTwo = new XpGlobe(skill,5346332,90,13034431);
		globeThree = new XpGlobe(skill,0,1,13034431);
	}

	@Test
	public void testAddXpGlobe99()
	{
		plugin.addXpGlobe(globe ,MAX_LENGTH);
		list = plugin.getXpGlobes();
		Assert.assertFalse(list.contains(globe));
	}

	@Test
	public void testAddXpGlobeNot99()
	{
		plugin.addXpGlobe(globeTwo ,MAX_LENGTH);
		plugin.addXpGlobe(globeThree ,MAX_LENGTH);
		list = plugin.getXpGlobes();
		Assert.assertTrue(list.contains(globeTwo));
		Assert.assertTrue(list.contains(globeThree));
	}

}
