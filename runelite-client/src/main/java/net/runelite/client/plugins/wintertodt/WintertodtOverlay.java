package net.runelite.client.plugins.wintertodt;

import com.google.common.graph.Graph;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TextComponent;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class WintertodtOverlay extends Overlay {
    private final Client client;
    private WintertodtConfig config;

    //Storage
    String safeFires = "";
    String downFires = "";
    String needReapir = "";
    String pyromancerHelp = "";

    PanelComponent pnc = new PanelComponent();

    @Inject
    public WintertodtOverlay(Client client, WintertodtConfig cfg) {
        this.client = client;
        this.config = cfg;
    }

    //1399 = UP 1398 = DOWN 1397 = BROKE 1400 = PYRO
    @Override
    public Dimension render(Graphics2D graphics)
    {
     safeFires = "";
     downFires = "";
     needReapir = "";
     pyromancerHelp = "";
     //Three Main UI pieces
        Widget wtOverlay = client.getWidget(WidgetInfo.WINTERTODT_BASE);
        Widget wtOverlayBAR = client.getWidget(WidgetInfo.WINTERTODT_BASE_BAR);
        Widget wtOverlayUI = client.getWidget(WidgetInfo.WINTERTODT_BASE_UI);
        Widget wtReturn = client.getWidget(WidgetInfo.WINTERTODT_RETURN);
        if(config.disablePlugin() != true){
            if (wtOverlay != null){
                wtOverlayBAR.setHidden(true);
                wtOverlayUI.setHidden(true);

                //Widgets
                Widget wtEnergy = client.getWidget(WidgetInfo.WINTERTODT_ENERGY);
                Widget wtPoints = client.getWidget(WidgetInfo.WINTERTODT_POINTS);
                Widget wtSWF = client.getWidget(WidgetInfo.WINTERTODT_FIRE_SW);
                Widget wtNWF = client.getWidget(WidgetInfo.WINTERTODT_FIRE_NW);
                Widget wtNEF = client.getWidget(WidgetInfo.WINTERTODT_FIRE_NE);
                Widget wtSEF = client.getWidget(WidgetInfo.WINTERTODT_FIRE_SE);
                Widget wtSWP = client.getWidget(WidgetInfo.WINTERTODT_PYRO_SW);
                Widget wtNWP = client.getWidget(WidgetInfo.WINTERTODT_PYRO_NW);
                Widget wtNEP = client.getWidget(WidgetInfo.WINTERTODT_PYRO_NE);
                Widget wtSEP = client.getWidget(WidgetInfo.WINTERTODT_PYRO_SE);
                wtReturn.setRelativeX(-195);

                //Points and Energy with lots of checks for interface.
                if(wtReturn.getText().contains(": "))
                {
                    String returnSplitter[] = wtReturn.getText().split(": ");
                    pnc.getLines().add(new PanelComponent.Line(
                            "Returns:",
                            Color.WHITE,
                            returnSplitter[1],
                            Color.GREEN)
                    );
                }

                if(wtEnergy.getText().contains(": "))
                {
                    String energySplitter[] = wtEnergy.getText().split(": ");
                    pnc.getLines().add(new PanelComponent.Line(
                            "Energy: ",
                            Color.WHITE,
                            energySplitter[1],
                            getEnergyColor(Integer.parseInt(energySplitter[1].replaceAll("%", "")))
                    ));
                }

                if(wtPoints.getText().contains(("<br>")))
                {
                    String pointSplitter[] = wtPoints.getText().split("<br>");
                    pnc.getLines().add(new PanelComponent.Line(
                            pointSplitter[0],
                            Color.WHITE,
                            pointSplitter[1],
                            getColor(Integer.parseInt(pointSplitter[1])))
                    );
                }

                //Fires
                if(wtSWF.getSpriteId() == 1399)
                {safeFires += ", SW";}
                else
                {downFires += ", SW";}

                if(wtNWF.getSpriteId() == 1399)
                {safeFires += ", NW";}
                else
                {downFires += ", NW";}

                if(wtNEF.getSpriteId() == 1399)
                {safeFires += ", NE";}
                else
                {downFires += ", NE";}

                if(wtSEF.getSpriteId() == 1399)
                {safeFires += ", SE";}
                else
                {downFires += ", SE";}

                //Pyros
                if(wtSWP.getSpriteId() == 1400)
                {pyromancerHelp += ", SW";}
                if(wtNWP.getSpriteId() == 1400)
                {pyromancerHelp += ", NW";}
                if(wtNEP.getSpriteId() == 1400)
                {pyromancerHelp += ", NE";}
                if(wtSEP.getSpriteId() == 1400)
                {pyromancerHelp += ", SE";}

                //Adds the text and continues to render.
                pnc.getLines().add(new PanelComponent.Line("Fires Lit:  ",
                        Color.WHITE,
                        safeFires.replaceFirst(", ", ""),
                        Color.GREEN)
                );

                pnc.getLines().add(new PanelComponent.Line("Fires Down: ",
                        Color.WHITE,
                        downFires.replaceFirst(", ", ""),
                        Color.RED)
                );

                pnc.getLines().add(new PanelComponent.Line("Pyros:  ",
                        Color.WHITE,
                        pyromancerHelp.replaceFirst(", ", ""),
                        Color.RED)
                );

                pnc.setWidth(160);
                pnc.render(graphics);
                pnc.getLines().clear();
            }
        }
        else
        {
            wtOverlayBAR.setHidden(false);
            wtOverlayUI.setHidden(false);
            wtReturn.setRelativeX(0);
        }
        return null;
    }

    //Visual Feedback for points
    public Color getColor(int points)
    {
        if(points < 500){
            return config.lowColor();
        }else{
            return config.highColor();
        }
    }

    //Visual Feedback for Energy
    public Color getEnergyColor(int points)
    {
        if(points <= 20){
            return config.lowColor();
        }else if(points > 20 && points <= 60){
            return config.medColor();
        } else if(points > 60 && points <= 100){
            return config.highColor();
        }
        return Color.BLACK;
    }
}
