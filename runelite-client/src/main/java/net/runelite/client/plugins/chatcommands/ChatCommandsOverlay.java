/*
 * Copyright (c) 2024, Ben <runelite@sololegends.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.chatcommands;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.FontID;
import net.runelite.api.Point;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.FontType;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class ChatCommandsOverlay extends Overlay {
    private final Pattern PETS_MATCHER = Pattern.compile("<img=([0-9]+)>", Pattern.MULTILINE);

    private final Client client;
    private final ChatCommandsPlugin plugin;
    private final ChatCommandsConfig config;

    @Inject
    private TooltipManager tooltipManager;

    @Inject
    private ChatCommandsOverlay(Client client, ChatCommandsPlugin plugin, ChatCommandsConfig config) {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(Overlay.PRIORITY_MED);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    private void petsOverlay(Graphics2D graphics) {
        // Still loading icon data
        if (plugin.petsIconIdx == -1) {
            return;
        }
        // Get the chat box lines
        Widget messageLines = client.getWidget(ComponentID.CHATBOX_MESSAGE_LINES);
        if(messageLines == null){
            return;
        }
        Widget[] lines = messageLines.getChildren();
        if(lines == null){
            return;
        }
        for (Widget line : lines) {
            // ensure visible, text is not null, and matching pets text
            if (messageLines.getBounds().contains(line.getBounds())
                    && line.getText() != null
                    && line.getText().matches(".*?Pets: \\([0-9]+\\) <img=[0-9]+>.*")) {
                // Get the bounds
                Rectangle bounds = line.getBounds();
                // Get mouse position
                Point mousePos = client.getMouseCanvasPosition();
                // If mouse in message bounds
                if (bounds.contains(mousePos.getX(), mousePos.getY())) {
                    // Extract the pets list by icon ids
                    Matcher matcher = PETS_MATCHER.matcher(line.getText());
                    List<Integer> petIconIds = new ArrayList<>();
                    while (matcher.find()) {
                        for (int i = 1; i <= matcher.groupCount(); i++) {
                            petIconIds.add(Integer.parseInt(matcher.group(i)));
                        }
                    }
                    // Generate the offset based on the pets width
                    int petsTextOffset = line.getFont().getTextWidth("Pets (" + petIconIds.size() + ")");

                    // Is it double height with many pets?
                    int petsPerLine = petIconIds.size();
                    if (bounds.height > config.petsIconHeight()) {
                        petsPerLine = (bounds.width - petsTextOffset) / config.petsIconWidth();
                    }

                    // Get the hovered pet by the mouse position within chat line bounds
                    int iconPos = Math.floorDiv((int) (mousePos.getX() - (petsTextOffset + bounds.getX())),
                            config.petsIconWidth());
                    if (mousePos.getY() >= bounds.getY() + config.petsIconHeight()) {
                        iconPos = Math.floorDiv((int) (mousePos.getX() - bounds.getX()),
                                config.petsIconWidth()) + petsPerLine;
                    }
                    // If in bounds of a known icon position
                    if (iconPos >= 0 && iconPos < petIconIds.size()) {
                        int petIcon = petIconIds.get(iconPos);
                        // Bounds verification!
                        if (petIcon - plugin.petsIconIdx >= 0 && petIcon - plugin.petsIconIdx < plugin.pets.length) {
                            String name = client.getItemDefinition(plugin.pets[petIcon - plugin.petsIconIdx]).getName();
                            // Draw a tool tip with the pet's name
                            tooltipManager.add(new Tooltip("Pet: " + name));
                        }
                    }
                }
            }
        }
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        // Only render the pets if the pets commands is active
        if(config.pets()){
            petsOverlay(graphics);
        }
        return null;
    }


}
