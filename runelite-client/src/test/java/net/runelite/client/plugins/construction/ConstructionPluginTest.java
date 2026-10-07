package net.runelite.client.plugins.construction;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConstructionPluginTest
{
	@Inject
	ConstructionPlugin constructionPlugin;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	ServantOverlay overlay;

	@Mock
	@Bind
	Client client;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testRickManyItems()
	{
		testNpcText("Here you go, mate. Oop, I see your hands are full. I'll just hold these 7 items till you're ready.", NpcID.RICK, 7);
	}

	@Test
	public void testRickLastItem()
	{
		testNpcText("Here you go, mate. Oop, I see your hands are full. I'll just hold this last thing till you're ready.", NpcID.RICK, 1);
	}

	@Test
	public void testRickNoItems()
	{
		testNpcText("Here you go, mate. Got a bit lost on the way back, sorry 'bout that.", NpcID.RICK, 0);
	}

	@Test
	public void testMaidManyItems()
	{
		testNpcText("I, er, I see your hands are full. I'll just hold these 10 items for you till you're ready. Yes, I'll hold them.", NpcID.MAID, 10);
	}

	@Test
	public void testMaidLastItem()
	{
		testNpcText("I see your hands are full. I'll hold the last one for you till you're ready.", NpcID.MAID, 1);
	}

	@Test
	public void testMaidNoItems()
	{
		testNpcText("Phew! I got back from the bank okay! Here you are, sir.", NpcID.MAID, 0);
	}

	@Test
	public void testCookManyItems()
	{
		testNpcText("I go all the way to the bank for you and then you can't even take these 5 items because your hands are full!", NpcID.COOK, 5);
	}

	@Test
	public void testCookLastItem()
	{
		testNpcText("I go all the way to the bank for you and then you can't even take the last item because your hands are full!", NpcID.COOK, 1);
	}

	@Test
	public void testCookNoItems()
	{
		testNpcText("Here you are.", NpcID.COOK, 0);
	}

	@Test
	public void testButlerManyItems()
	{
		testNpcText("I will hold these 3 items until sir has space to take them.", NpcID.BUTLER, 3);
	}

	@Test
	public void testButlerLastItem()
	{
		testNpcText("I will hold this one until sir has space to take it.", NpcID.BUTLER, 1);
	}

	@Test
	public void testButlerNoItems()
	{
		testNpcText("Your goods, sir.", NpcID.BUTLER, 0);
	}

	@Test
	public void testDemonButlerManyItems()
	{
		testNpcText("Master, I have returned with what thou asked me to retrieve. As I see thy inventory is full, I shall wait with these 2 items until thou art ready.", NpcID.DEMON_BUTLER, 2);
	}

	@Test
	public void testDemonButlerLastItem()
	{
		testNpcText("Master, I have returned with what thou asked me to retrieve. As I see thy inventory is full, I shall wait with the last item until thou art ready.", NpcID.DEMON_BUTLER, 1);
	}

	@Test
	public void testDemonButlerNoItems()
	{
		testNpcText("Master, I have returned with what you asked me to retrieve.", NpcID.DEMON_BUTLER, 0);
	}

	@Test
	public void testNonServant()
	{
		setNpcText("You've spent here 1 days, 2 hours, 35 minutes in the world since you arrived 14 days ago.");
		setNpcHead(NpcID.HANS);

		constructionPlugin.onNpcSpawned(mockNpcSpawned(NpcID.HANS));
		constructionPlugin.onGameTick(new GameTick());

		assertNull(constructionPlugin.getServant());
		assertEquals(0, constructionPlugin.getItemsCount());
	}

	private void testNpcText(String npcText, int servantId, int itemsCount)
	{
		setNpcText(npcText);
		setNpcHead(servantId);

		constructionPlugin.onNpcSpawned(mockNpcSpawned(servantId));
		constructionPlugin.onGameTick(new GameTick());

		assertEquals(servantId, constructionPlugin.getServant().getId());
		assertEquals(itemsCount, constructionPlugin.getItemsCount());
	}

	private NpcSpawned mockNpcSpawned(int npcId)
	{
		NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(npcId);
		return new NpcSpawned(npc);
	}

	private void setNpcText(String npcText)
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(npcText);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
	}

	private void setNpcHead(int servantId)
	{
		Widget npcHead = mock(Widget.class);
		when(npcHead.getModelId()).thenReturn(servantId);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_HEAD_MODEL)).thenReturn(npcHead);
	}
}
