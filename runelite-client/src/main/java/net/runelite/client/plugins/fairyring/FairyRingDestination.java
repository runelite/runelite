/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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

package net.runelite.client.plugins.fairyring;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Slf4j
class FairyRingDestination
{
    private final Client client;

    @Inject
    FairyRingDestination(Client client)
    {
        this.client = client;
    }


    private final String[] fairyQueenHideoutCodes = new String[]{"AIR", "DLR", "DJQ", "AJS"};
    private String destinationCode = "";

    private FairyOrb leftFairyOrb = new FairyOrb(new char[]{'A','D','C','B'});
    private FairyOrb middleFairyOrb = new FairyOrb(new char[]{'I','L','K','J'});
    private FairyOrb rightFairyOrb = new FairyOrb(new char[]{'P','S','R','Q'});

    void close()
    {
        Widget widgetFairyRingButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);

        if (widgetFairyRingButton == null || widgetFairyRingButton.isHidden())
        {
            return;
        }

        destinationCode = "";
        orbReset();
        widgetFairyRingButton.setText("Teleport to this location");
    }

    void reset()
    {
        Widget widgetFairyRingButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);

        if ((widgetFairyRingButton == null || widgetFairyRingButton.isHidden()) && !destinationCode.equals(""))
        {
            destinationCode = "";
            orbReset();
            return;
        }
        if (widgetFairyRingButton != null && destinationCode.equals(""))
        {
            orbReset();
            setNewDestination();
        }
    }

    private void setNewDestination()
    {
        Widget widgetFairyRingButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
        Widget widgetFairyQueenHideoutCode = client.getWidget(WidgetInfo.FAIRY_QUEEN_HIDEOUT_CODE);

        destinationCode = orbGetSelect();
        for (FairyRingCodes FRC : FairyRingCodes.values()) {
            if(destinationCode.equals(FRC.getFairyCode()))
            {
                if (widgetFairyQueenHideoutCode != null &&
                        widgetFairyQueenHideoutCode.getText().split("col")[1].contains(destinationCode) &&
                        destinationCode.equals(fairyQueenHideoutCodes[3]))
                {
                    widgetFairyRingButton.setText("Fairy Queen's Hideout (" + destinationCode + ")");
                    return;
                }

                widgetFairyRingButton.setText(FRC.getDescription() + " (" + destinationCode + ")");
                return;
            }
        }

        widgetFairyRingButton.setText("Teleport to unknown location (" + destinationCode + ")");
    }

    void menuOptionClicked(MenuOptionClicked event)
    {
        Widget widgetFairyRingButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
        if (widgetFairyRingButton == null || widgetFairyRingButton.isHidden())
        {
            return;
        }

        //Fairy Queen Hideout
        Widget widgetFairyQueenHideoutCode = client.getWidget(WidgetInfo.FAIRY_QUEEN_HIDEOUT_CODE);
        if (widgetFairyQueenHideoutCode != null && event.getWidgetId() == WidgetInfo.FAIRY_QUEEN_HIDEOUT_CODE.getId())
        {
            String fairyQueenHideoutCode = widgetFairyQueenHideoutCode.getText().split("col")[1];

            for (String hideoutCode : fairyQueenHideoutCodes) {
                if(fairyQueenHideoutCode.contains(hideoutCode))
                {
                    orbSet(hideoutCode);
                    setNewDestination();
                    return;
                }
            }
        }

        //Quick destination
        String fairyCode = event.getMenuTarget().replace(" ", "");
        for (FairyRingCodes FRC : FairyRingCodes.values()) {
            if(fairyCode.contains(FRC.getFairyCode()))
            {
                orbSet(FRC.getFairyCode());
                setNewDestination();
                return;
            }
        }

        //click on the orb manually
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_LEFT_ORB_CLOCKWISE.getId())
        {
            leftFairyOrb.rotateClockwise();
            setNewDestination();
            return;
        }
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_LEFT_ORB_COUNTER_CLOCKWISE.getId())
        {
            leftFairyOrb.rotateCounterClockwise();
            setNewDestination();
            return;
        }
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_MIDDLE_ORB_CLOCKWISE.getId())
        {
            middleFairyOrb.rotateClockwise();
            setNewDestination();
            return;
        }
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_MIDDLE_ORB_COUNTER_CLOCKWISE.getId())
        {
            middleFairyOrb.rotateCounterClockwise();
            setNewDestination();
            return;
        }
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_RIGHT_ORB_CLOCKWISE.getId())
        {
            rightFairyOrb.rotateClockwise();
            setNewDestination();
            return;
        }
        if (event.getWidgetId() == WidgetInfo.FAIRY_RING_RIGHT_ORB_COUNTER_CLOCKWISE.getId())
        {
            rightFairyOrb.rotateCounterClockwise();
            setNewDestination();
        }
    }

    private String orbGetSelect()
    {
        return leftFairyOrb.getSelect() + middleFairyOrb.getSelect() + rightFairyOrb.getSelect();
    }

    private void orbSet(String destination)
    {
        leftFairyOrb.setSelect(destination.charAt(0));
        middleFairyOrb.setSelect(destination.charAt(1));
        rightFairyOrb.setSelect(destination.charAt(2));
    }

    private void orbReset()
    {
        leftFairyOrb.reset();
        middleFairyOrb.reset();
        rightFairyOrb.reset();
    }
}
