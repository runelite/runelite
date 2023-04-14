package net.runelite.client.plugins.prayerflicker;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.Instant;

class PrayerFlicker extends Overlay
{

    private static boolean HasClickedOnceThisTick = false;
    private static boolean PrayersActive = false;
    private static boolean ShouldReturnNull = true;
    private static boolean NeedsMoveBack = false;
    private static double TimeThreshold = 150;

    private Instant startOfLastTick = Instant.now();
    private Widget PrayerOrb;
    private Rectangle2D PrayerOrbRectangle;
    private static int MovebackXCoordinate, MovebackYCoordinate;

    private final Client client;private final PrayerFlickerConfig config;
    private final PrayerFlickerPlugin plugin;

    private static final String CONFIG_GROUP = "prayerflicker";
    private static final String CONFIG_ITEM = "prayerFlick";

    @Inject
    private ConfigManager configManager;

    @Inject
    private PrayerFlicker( Client client, PrayerFlickerConfig config, PrayerFlickerPlugin plugin )
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.client = client;
        this.config = config;
        this.plugin = plugin;
    }

    void onTick( boolean pPrayersActive )
    {
        SetShouldReturnNull();
        if ( ShouldReturnNull ) return;

        RecalculateTimeThreshold();
        PrayersActive = pPrayersActive;
        startOfLastTick = Instant.now(); //Reset the tick timer
        ClickPrayerOrb();
        HasClickedOnceThisTick = true;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if ( client.getBoostedSkillLevel(Skill.PRAYER) == 0 )
        {
            SwitchFlickingState( false );
            return null;
        }

        PrayerOrb = client.getWidget(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB);
        PrayerOrbRectangle = PrayerOrb.getBounds().getBounds2D();

        SetShouldReturnNull();
        if ( ShouldReturnNull ) return null;

        if ( ShouldClickPrayerOrb() )
        {
            ClickPrayerOrb();
        }
        else
        {
            ResetMousePosition();
        }

        return null;
    }

    private void SetShouldReturnNull()
    {
        if ( !plugin.PluginOn ){
            ShouldReturnNull = true;
        }
        else if (PrayerOrb == null || PrayerOrb.isHidden())
        {
            ShouldReturnNull = true;
        }
        else if (PrayerOrbRectangle.getX() <= 0)
        {
            ShouldReturnNull = true;
        }
        else if ( client.getLocalPlayer() == null )
        {
            ShouldReturnNull = true;
        }
        else if ( client.getBoostedSkillLevel(Skill.PRAYER) == 0 )
        {
            ShouldReturnNull = true;
        }
        else
        {
            ShouldReturnNull = false;
        }
    }

    boolean ShouldClickPrayerOrb()
    {
        double TickProgress = GetTickProgress();

        if ( HasClickedOnceThisTick && TickProgress > TimeThreshold && PrayersActive )
        {
            HasClickedOnceThisTick = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    void SwitchFlickingState( boolean State )
    {
        configManager.setConfiguration( CONFIG_GROUP, CONFIG_ITEM, State );
        plugin.PluginOn = !plugin.PluginOn;
    }

    private double GetTickProgress()
    {
        return Duration.between(startOfLastTick, Instant.now()).toMillis();
    }

    void DeactivatePrayers()
    {
        if ( PrayersActive )
        {
            ClickPrayerOrb();
        }
    }

    private int GetOrbLocalXCoordinate()
    {
        int PrayerOrbWidth = (int)PrayerOrbRectangle.getWidth();
        int LocalOrbXCoordinate = PrayerOrbRectangle.getBounds().x;

        return (int)( LocalOrbXCoordinate + PrayerOrbWidth * 0.75 );
    }

    private int GetOrbLocalYCoordinate()
    {
        int PrayerOrbHeight = (int)(PrayerOrbRectangle.getHeight());
        int LocalOrbYCoordinate = PrayerOrbRectangle.getBounds().y;

        return (int)( LocalOrbYCoordinate + PrayerOrbHeight * 0.5 );
    }


    private void ClickPrayerOrb()
    {
        MouseEvent press, release, click, move;
        final Canvas target = client.getCanvas();
        long time;

        int OrbXCoordinate = GetOrbLocalXCoordinate() + (int)GetRandomNumber(5);
        int OrbYCoordinate = GetOrbLocalYCoordinate() + (int)GetRandomNumber(5);

        if ( !config.safemode() )
        {
            MovebackXCoordinate = client.getMouseCanvasPosition().getX();
            MovebackYCoordinate = client.getMouseCanvasPosition().getY();
            NeedsMoveBack = true;

            time    = System.currentTimeMillis();
            move    = new MouseEvent(target, MouseEvent.MOUSE_MOVED,  time, 0, OrbXCoordinate, OrbYCoordinate, 0, false, MouseEvent.NOBUTTON);
            target.dispatchEvent(move);
        }

        time    = System.currentTimeMillis();
        press   = new MouseEvent(target, MouseEvent.MOUSE_PRESSED,  time, 0, OrbXCoordinate, OrbYCoordinate, 1, false, MouseEvent.BUTTON1);
        release = new MouseEvent(target, MouseEvent.MOUSE_RELEASED, time, 0, OrbXCoordinate, OrbYCoordinate, 1, false, MouseEvent.BUTTON1);
        click   = new MouseEvent(target, MouseEvent.MOUSE_CLICKED,  time, 0, OrbXCoordinate, OrbYCoordinate, 1, false, MouseEvent.BUTTON1);
        target.dispatchEvent(press);
        target.dispatchEvent(release);
        target.dispatchEvent(click);
    }

    private void ResetMousePosition()
    {
        if ( config.safemode() || !NeedsMoveBack ) return;

        MouseEvent move;
        final Canvas target = client.getCanvas();
        long time;

        time    = System.currentTimeMillis();
        move    = new MouseEvent(target, MouseEvent.MOUSE_MOVED,  time, 0, MovebackXCoordinate, MovebackYCoordinate, 0, false, MouseEvent.NOBUTTON);
        target.dispatchEvent(move);

        NeedsMoveBack = false;
    }

    void RecalculateTimeThreshold()
    {
        TimeThreshold = 150 + GetRandomNumber( 30 );
    }

    double GetRandomNumber( double MinMax )
    {
        // returns number between -MinMax and MinMax
        return MinMax * ( java.lang.Math.random() - java.lang.Math.random() );
    }
}
