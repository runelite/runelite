package net.runelite.client.plugins.zulrah.patterns;/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.plugins.zulrah.ZulrahInstance;

import java.awt.*;

public abstract class ZulrahPattern  implements ZulrahPatternPaintListener{

    protected ZulrahInstance[] pattern;
    protected Client client;

    public ZulrahInstance get(int index) {
        if (index >= pattern.length) {
            return null;
        }

        return pattern[index];
    }

    public boolean accept(int index, ZulrahInstance instance) {
        ZulrahInstance patternInstance = get(index);
        if(patternInstance == null) {
            return false;
        }
        return patternInstance.equals(instance);
    }

    public abstract boolean canReset(int index);


    @Override
    public void render(Graphics2D graphics, net.runelite.api.Point startTile, int index) {
       ZulrahInstance current = get(index);
        graphics.setColor(Color.WHITE);
        graphics.drawString("startTile: " + startTile, 270, 200);
        graphics.drawString("current: " + current, 200, 215);
        if(current != null) {

            //Point zulrahTilePoint = current.getZulrahLoc(startTile); //Perspective.localToWorld(client, zulrahTile);
            //zulrahTilePoint = Perspective.worldToCanvas(client, zulrahTilePoint.getX(), zulrahTilePoint.getY(), client.getPlane());
            //graphics.setColor(Color.BLACK);
            //graphics.drawString("c: " + current.getType() + current.isJad(), zulrahTilePoint.getX(), zulrahTilePoint.getY());
            renderTileOverlay(graphics, current.getStandLoc(startTile), Color.GREEN);
        }

        ZulrahInstance next = get(index + 1);
        graphics.setColor(Color.WHITE);
        graphics.drawString("next: " + next, 200, 230);
        if(next != null) {
            /*Point nextZulrahTile = next.getZulrahLoc(startTile);

            Point nextZulrahTilePoint = Perspective.localToWorld(client, nextZulrahTile);
            nextZulrahTilePoint = Perspective.worldToCanvas(client, nextZulrahTilePoint.getX(), nextZulrahTilePoint.getY(), client.getPlane());
            graphics.setColor(Color.BLACK);
            graphics.drawString("c: " + next.getType() + next.isJad(), nextZulrahTilePoint.getX(), nextZulrahTilePoint.getY());*/
            renderTileOverlay(graphics, next.getStandLoc(startTile), new Color(255,0,0,150));

        }
        graphics.setColor(Color.WHITE);
    }

    private void renderTileOverlay(Graphics2D graphics, Point tile, Color color) {

    Polygon poly =  Perspective.getCanvasTilePoly(client, Perspective.worldToLocal(client, tile));
    if (poly != null) {
        graphics.setColor(color);
        graphics.setStroke(new BasicStroke(2));
        graphics.drawPolygon(poly);
        graphics.setColor(new Color(0, 0, 0, 50));
        graphics.fillPolygon(poly);
    }
}
}
