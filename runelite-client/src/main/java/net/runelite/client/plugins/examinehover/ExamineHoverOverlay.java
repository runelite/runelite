package net.runelite.client.plugins.examinehover;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.examine.ExamineClient;

import javax.inject.Inject;
import java.awt.*;
import java.util.Arrays;

class ExamineHoverOverlay extends Overlay
{
    private final Cache<Integer, String> cache = CacheBuilder.newBuilder()
            .maximumSize(128L)
            .build();

    @Inject
    private Client client;

    @Inject
    private ExamineClient examineClient;

    @Inject
    private TooltipManager tooltipManager;

    @Inject
    private ExamineHoverOverlay(
            Client client,
            TooltipManager tooltipManager,
            ExamineClient examineClient
    )
    {
        this.client = client;
        this.tooltipManager = tooltipManager;
        this.examineClient = examineClient;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        final MenuEntry[] menuEntries = client.getMenuEntries();

        boolean examineExists = Arrays.stream(menuEntries).anyMatch(l->l.getType() == MenuAction.EXAMINE_OBJECT.getId());

        if (client.isMenuOpen() || !examineExists)
        {
            return null;
        }

        MenuEntry examineEntry = Arrays.stream(menuEntries)
                .filter(menuEntry -> menuEntry.getOption().equalsIgnoreCase("Examine"))
                .reduce((first, second) -> second).orElse(null);

        if(examineEntry != null){
            String cacheText = cache.getIfPresent(examineEntry.getIdentifier());
            if(cacheText == null){
                cacheText = examineClient.getObject(examineEntry.getIdentifier());
                cache.put(examineEntry.getIdentifier(), cacheText);
            }
            tooltipManager.add(new Tooltip(ColorUtil.prependColorTag(cacheText, new Color(238, 238, 238))));
        }

        return null;
    }
}
