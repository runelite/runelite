package net.runelite.client.plugins.multilines;

import com.google.gson.*;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.opponentinfo.OpponentInfoPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "Multi lines"
)
public class MultiLinesPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private MultiLinesOverlay multiLinesOverlay;

    private List<MultiLineBorder> multiLineBorders = loadMultiLineBorders();

    @Provides
    MultiLinesConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(MultiLinesConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(multiLinesOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(multiLinesOverlay);
    }

    private List<MultiLineBorder> loadMultiLineBorders() {
        Gson gson = new Gson();
        InputStream multiBordersFile = OpponentInfoPlugin.class.getResourceAsStream("/multi_borders.json");
        JsonArray items = gson.fromJson(new InputStreamReader(multiBordersFile), JsonArray.class);

        List<MultiLineBorder> output = new ArrayList<>(items.size());

        for (JsonElement element : items) {
            JsonObject item = (JsonObject) element;
            for (String key : item.keySet()) {
                JsonObject nested = item.getAsJsonObject(key);
                output.add(
                        new MultiLineBorder(
                                key,
                                fromJsonObject(nested.getAsJsonObject("single")),
                                fromJsonObject(nested.getAsJsonObject("multi"))));
            }
        }

        return output;
    }

    private Point fromJsonObject(JsonObject jsonObject) {
        JsonPrimitive x = jsonObject.getAsJsonPrimitive("x");
        JsonPrimitive y = jsonObject.getAsJsonPrimitive("y");
        return new Point(x.getAsInt(), y.getAsInt());
    }

}
