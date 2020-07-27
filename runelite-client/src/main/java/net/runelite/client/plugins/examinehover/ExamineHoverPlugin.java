package net.runelite.client.plugins.examinehover;

import com.google.inject.Provides;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.examine.ExamineClient;
import okhttp3.OkHttpClient;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Examine Text",
        description = "Show examine text on mouse hover",
        tags = {"objects"}
)
public class ExamineHoverPlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ExamineHoverOverlay overlay;

    @Inject
    private ExamineClient examineClient;

    @Provides
    ExamineClient provideExamineClient(OkHttpClient okHttpClient)
    {
        return new ExamineClient(okHttpClient);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
    }

}
