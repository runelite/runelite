package net.runelite.client.plugins.wintertodt;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;

@PluginDescriptor(
		name = "Wintertodt Plugin"
)

@Slf4j
public class WintertodtPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private WintertodtOverlay overlay;

	@Inject
	private WintertodtConfig config;

	@Override
	public Overlay getOverlay()
    { return overlay; }

	@Override
	protected void shutDown() throws Exception
	{
		//Unhides Widgets
		Widget wtOverlay = client.getWidget(WidgetInfo.WINTERTODT_BASE);
		Widget wtOverlayBAR = client.getWidget(WidgetInfo.WINTERTODT_BASE_BAR);
		Widget wtOverlayUI = client.getWidget(WidgetInfo.WINTERTODT_BASE_UI);
		Widget wtReturn = client.getWidget(WidgetInfo.WINTERTODT_RETURN);
		wtOverlayBAR.setHidden(false);
		wtOverlayUI.setHidden(false);
		wtReturn.setRelativeX(0);
	}

	@Provides
	WintertodtConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WintertodtConfig.class);
	}

}
