package net.runelite.client.plugins.playerwithincombat;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerWithinCombatInfoBox extends Overlay {
    private final Client client;
    private final PlayerWithinCombatPlugin plugin;
    private final SpriteManager spriteManager;
    private final PanelComponent infobox = new PanelComponent();

    @Inject
    private PlayerWithinCombatInfoBox(final Client client, final PlayerWithinCombatPlugin plugin,final SpriteManager spriteManager){
        this.client = client;
        this.plugin = plugin;
        this.spriteManager = spriteManager;
        setPriority(OverlayPriority.HIGH);
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }
    @Override
    public Dimension render(Graphics2D graphics){
        infobox.getChildren().clear();
        //infobox.getChildren().add(new ImageComponent(getimage()));
        int Level = plugin.getPlayerLocation();
        if(Level == -1){
            infobox.getChildren().clear();
        }
        if(Level > 0) {
            infobox.getChildren().add(TitleComponent.builder()
                    .text("Wilderness Indicator")
                    .color(Color.WHITE)
                    .build());
            infobox.getChildren().add(LineComponent.builder()
                    .left("WildernessLevel : ")
                    .leftColor(Color.WHITE)
                    .rightColor(Color.WHITE)
                    .right(Integer.toString(Level))
                    .build());
            infobox.getChildren().add(LineComponent.builder()
                    .left("Low attack : ")
                    .leftColor(Color.WHITE)
                    .rightColor(Color.WHITE)
                    .right(Integer.toString(client.getLocalPlayer().getCombatLevel() - Level))
            .build());
            int highestlvl = client.getLocalPlayer().getCombatLevel() + Level;
            if(highestlvl > 126){
                highestlvl = 126;
            }
            infobox.getChildren().add(LineComponent.builder()
                    .left("High attack : ")
                    .leftColor(Color.WHITE)
                    .rightColor(Color.WHITE)
                    .right(Integer.toString(highestlvl))
                    .build());
            infobox.setBackgroundColor(Color.BLACK);
        }
        if(Level > 0 && !plugin.getPlayers().isEmpty()){
            for (Player player : plugin.getPlayers()){
                Player localplayer = client.getLocalPlayer();
                int Wildernesslevel = plugin.getPlayerLocation();
                int lowest = localplayer.getCombatLevel() - Wildernesslevel;
                int highest = localplayer.getCombatLevel() + Wildernesslevel;
                if(highest > 126 && Wildernesslevel > 0){
                    highest = 126;
                }
                if(player.getCombatLevel() >= lowest && player.getCombatLevel() <= highest && Wildernesslevel > 0){
                    infobox.setBackgroundColor(Color.RED);
                    break;
                }
                if(player.getCombatLevel() < lowest || player.getCombatLevel() > highest && Wildernesslevel > 0){
                    infobox.setBackgroundColor(Color.GREEN);
                }
            }
        }
        return infobox.render(graphics);
    }
    private BufferedImage getimage(){
        return spriteManager.getSprite(128,0);
    }
}
