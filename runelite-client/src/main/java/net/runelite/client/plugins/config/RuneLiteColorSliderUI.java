/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.config;

import org.pushingpixels.substance.internal.animation.StateTransitionTracker;
import org.pushingpixels.substance.internal.animation.TransitionAwareUI;
import org.pushingpixels.substance.internal.contrib.randelshofer.quaqua.colorchooser.ColorSliderModel;
import org.pushingpixels.substance.internal.contrib.randelshofer.quaqua.colorchooser.ColorSliderUI;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by X on 8/13/2017.
 */
public class RuneLiteColorSliderUI extends ColorSliderUI implements TransitionAwareUI
{
    private static final Color foreground = new Color(9737364);
    private static final Color trackBackground = new Color(16777215);

    public RuneLiteColorSliderUI(JSlider b)
    {
        super(b);
    }

    public void paintTrack(Graphics g) {
        Rectangle trackBounds = this.trackRect;
        int cx;
        int cy;
        int cw;
        int ch;
        int pad;
        if(this.slider.getOrientation() == 0) {
            pad = this.trackBuffer;
            cx = trackBounds.x - pad + 1;
            cy = trackBounds.y;
            cw = trackBounds.width + pad * 2 - 2;
            ch = trackBounds.height;
        } else {
            pad = this.trackBuffer;
            cx = trackBounds.x;
            cy = this.contentRect.y + 2;
            cw = trackBounds.width - 1;
            ch = trackBounds.height + pad * 2 - 5;
        }

        g.setColor(trackBackground);
        g.fillRect(cx, cy, cw, ch);
        g.setColor(foreground);
        g.drawRect(cx, cy, cw - 1, ch - 1);
        this.paintColorTrack(g, cx + 2, cy + 2, cw - 4, ch - 4, this.trackBuffer);
    }

    private void paintColorTrack(Graphics g, int x, int y, int width, int height, int buffer) {
        int x2 = x;
        int y2 = y;
        if(this.slider.getOrientation() == 0) {
            x2 = x + width;
        } else {
            y2 = y + height;
        }

        if(this.componentIndex == null) {
            this.componentIndex = (Integer)this.slider.getClientProperty("ColorComponentIndex");
        }

        if(this.colorSliderModel == null) {
            this.colorSliderModel = (ColorSliderModel)this.slider.getClientProperty("ColorSliderModel");
        }

        Graphics2D gg = (Graphics2D)g.create();
        if (slider.getOrientation() == SwingConstants.HORIZONTAL)
        {
            gg.setPaint(new LinearGradientPaint((float)x, (float)y, (float)x2, (float)y2, new float[]{0.0F, 1.0F}, new Color[]{new Color(this.colorSliderModel.getInterpolatedRGB(this.componentIndex.intValue(), 0.0F), true), new Color(this.colorSliderModel.getInterpolatedRGB(this.componentIndex.intValue(), 1.0F))}));
        }
        else
        {
            gg.setPaint(new LinearGradientPaint((float)x, (float)y, (float)x2, (float)y2, new float[]{0.0F, 1.0F}, new Color[]{new Color(this.colorSliderModel.getInterpolatedRGB(this.componentIndex.intValue(), 1.0F), true), new Color(this.colorSliderModel.getInterpolatedRGB(this.componentIndex.intValue(), 0.0F))}));
        }
        gg.fillRect(x, y, width, height);
        gg.dispose();
    }
}
