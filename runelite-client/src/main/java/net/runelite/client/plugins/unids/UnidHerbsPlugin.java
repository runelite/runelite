package net.runelite.client.plugins.unids;

import java.lang.reflect.Field;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.PostItemComposition;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Unidentified Herbs",
	description = "Replaces grimy herbs with unidentified herbs",
	enabledByDefault = false
)
@Slf4j
public class UnidHerbsPlugin extends Plugin
{

	private static final int[] GRIMY_HERBS = {199, 201, 203, 205, 207, 209, 211, 213, 215, 217, 219, 2485, 3049, 3051};
	private static final int ORIGINAL_UNID_MODEL = 2364;
	private static final String CLEAN_MESSAGE_PATTERN = "You need level \\d{1,2} Herblore to clean the .+";
	private static final String CLEAN_MESSAGE_REPLACEMENT = "Your Herblore level is not high enough to identify this herb.";

	@Inject
	private Client client;

	private Field itemNameField;
	private Field itemModelField;
	private Field itemInventoryActionsField;
	private Field itemSourceColorsField;
	private Field itemReplacementColorsField;
	private int encodedModelId;

	@Override
	protected void startUp() throws Exception
	{
		client.getItemCompositionCache().reset();
		ClassLoader classLoader = client.getClass().getClassLoader();
		Class<?> itemComposition = classLoader.loadClass("jz");

		itemNameField = getFieldAndSetAccessible(itemComposition, "r");
		itemModelField = getFieldAndSetAccessible(itemComposition, "v");
		itemInventoryActionsField = getFieldAndSetAccessible(itemComposition, "ad");
		itemSourceColorsField = getFieldAndSetAccessible(itemComposition, "x");
		itemReplacementColorsField = getFieldAndSetAccessible(itemComposition, "y");

		encodedModelId = 1310457931 * ORIGINAL_UNID_MODEL;
	}

	@Override
	protected void shutDown() throws Exception
	{
		client.getItemCompositionCache().reset();
	}

	@Subscribe
	public void onPostItemComposition(PostItemComposition event)
	{
		ItemComposition itemComposition = event.getItemComposition();
		int itemId = itemComposition.getId();

		if (isGrimyHerb(itemId))
		{
			try
			{
				itemNameField.set(itemComposition, "Herb");
				itemModelField.set(itemComposition, encodedModelId);
				itemSourceColorsField.set(itemComposition, null);
				itemReplacementColorsField.set(itemComposition, null);
				itemInventoryActionsField.set(itemComposition, new String[]{"Identify", null, null, null, null});
			}
			catch (Exception e)
			{
				log.error("Could not modify the item composition", e);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getMessage().matches(CLEAN_MESSAGE_PATTERN))
		{
			chatMessage.getMessageNode().setValue(CLEAN_MESSAGE_REPLACEMENT);
		}
	}

	private Field getFieldAndSetAccessible(Class clazz, String fieldName) throws Exception
	{
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		return field;
	}

	private boolean isGrimyHerb(int itemId)
	{
		return Arrays.binarySearch(GRIMY_HERBS, itemId) >= 0;
	}
}
