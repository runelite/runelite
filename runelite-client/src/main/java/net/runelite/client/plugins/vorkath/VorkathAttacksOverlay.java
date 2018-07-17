package net.runelite.client.plugins.vorkath;

import java.awt.*;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Slf4j
public class VorkathAttacksOverlay extends Overlay {

    private final VorkathPlugin plugin;
    private final PanelComponent mainPanelComponent = new PanelComponent();
    private final PanelComponent attackImagePanelComponent = new PanelComponent();

    @Inject
    private SpriteManager spriteManager;

    @Inject
    public VorkathAttacksOverlay(VorkathPlugin plugin) {

        this.plugin = plugin;

        setPosition(OverlayPosition.BOTTOM_LEFT);
        mainPanelComponent.setOrientation(PanelComponent.Orientation.VERTICAL);
        attackImagePanelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        mainPanelComponent.getChildren().clear();
        attackImagePanelComponent.getChildren().clear();

        if (!plugin.isInVorkathArea()) {
            return null;
        }

        if (plugin.getVorkathState() == VorkathState.POISON_FIRE_SPECIAL_ATTACK) {
            drawPoisonAttackPanel();
        } else {
            drawDefaultPanel();
        }
        return mainPanelComponent.render(graphics);
    }

    private void drawDefaultPanel() {
        String AttacksAmountUntillSpecialAttack = String.valueOf(plugin.getAttacksAmountUntilSpecialAttack());

        mainPanelComponent.getChildren().add(LineComponent.builder()
                .left("Attacks til special:")
                .right(AttacksAmountUntillSpecialAttack)
                .build());

        mainPanelComponent.getChildren().add(LineComponent.builder()
                .left("Next special Attack:")
                .build());

        VorkathState nextSpecialAttack = plugin.getNextSpecialAttack();

        BufferedImage freezeImage = spriteManager.getSprite(SpriteID.SPELL_ICE_BARRAGE, 0);
        BufferedImage poisonImage = spriteManager.getSprite(SpriteID.HITSPLAT_GREEN_POISON, 0);

        if (nextSpecialAttack == VorkathState.IDLE) {
            attackImagePanelComponent.getChildren().add(new ImageComponent(spriteManager.getSprite(SpriteID.UNKNOWN_MAP_ICON_INFORMATION_I, 0)));
        } else if (nextSpecialAttack == VorkathState.POISON_FIRE_SPECIAL_ATTACK) {
            attackImagePanelComponent.getChildren().add(new ImageComponent(poisonImage));
        } else if (nextSpecialAttack == VorkathState.FREEZE_SPECIAL_ATTACK) {
            attackImagePanelComponent.getChildren().add(new ImageComponent(freezeImage));
        }
        mainPanelComponent.getChildren().add(attackImagePanelComponent);
    }

    private void drawPoisonAttackPanel() {
        mainPanelComponent.getChildren().add(LineComponent.builder()
                .left("Poison bolts left:")
                .right(String.valueOf(plugin.getAmountOfPoisonBoltsLeft()))
                .rightColor(Color.RED)
                .build());
    }
}


