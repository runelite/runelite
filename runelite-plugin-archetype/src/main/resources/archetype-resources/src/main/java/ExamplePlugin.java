#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
	name = "Example plugin"
)
public class ExamplePlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(ExamplePlugin.class);

	@Inject
	Client client;

	@Inject
	ExampleOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		logger.info("Example plugin started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		logger.info("Example plugin stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.sendGameMessage(ChatMessageType.GAME, "Example plugin is running!");
		}
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ExampleOverlay.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Provides
	ExamplePluginConfiguration provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExamplePluginConfiguration.class);
	}

}
