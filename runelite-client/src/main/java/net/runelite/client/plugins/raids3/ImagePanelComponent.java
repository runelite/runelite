package net.runelite.client.plugins.raids3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import net.runelite.client.ui.overlay.RenderableEntity;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.TextComponent;

public class ImagePanelComponent implements RenderableEntity {
  private static final int TOP_BORDER = 3;
  private static final int SIDE_BORDER = 6;
  private static final int BOTTOM_BORDER = 6;
  private static final int SEPARATOR = 4;
  Raids3Config raids3Config;
  Raids3Plugin plugin;
  private Color titleColor;
  private Color backgroundColor;
  private BufferedImage image;
  private Point position;
  public String title;

  public ImagePanelComponent(Raids3Config config, Raids3Plugin plugin) {
    this.titleColor = Color.WHITE;
    this.backgroundColor = new Color(107, 243, 107, 145);
    this.position = new Point();
    this.title = "1";
    this.raids3Config = config;
    this.plugin = plugin;
  }

  public Dimension render(Graphics2D graphics) {
    Dimension dimension = new Dimension();
    FontMetrics metrics = graphics.getFontMetrics();
    int height = 50;
    int width = 50;
    dimension.setSize(width, height);
    if (dimension.height == 0) {
      return null;
    } else {
      int y = this.position.y + 3 + metrics.getHeight();
      BackgroundComponent backgroundComponent2 = new BackgroundComponent();
      backgroundComponent2.setBackgroundColor(Color.DARK_GRAY);
      backgroundComponent2.setRectangle(new Rectangle(this.position.x - 5, this.position.y - 5, dimension.width + 10, dimension.height + 10));
      backgroundComponent2.render(graphics);
      BackgroundComponent backgroundComponent = new BackgroundComponent();
      backgroundComponent.setBackgroundColor(this.backgroundColor);
      backgroundComponent.setRectangle(new Rectangle(this.position.x, this.position.y, dimension.width, dimension.height));
      backgroundComponent.render(graphics);
      boolean isDisplayingTicks = this.raids3Config.AttackTickOverlayType() == TickOverlayDisplayType.Overlay || this.raids3Config.AttackTickOverlayType() == TickOverlayDisplayType.Both;
      if (isDisplayingTicks && this.plugin.prayerQue.prayerPriority != null && this.plugin.prayerQue.currentTick <= this.plugin.prayerQue.endTick) {
        int attackSpeed = this.plugin.prayerQue.endTick;
        int currentTick = this.plugin.prayerQue.currentTick;
        TextComponent titleComponent = new TextComponent();
        titleComponent.setText("" + (attackSpeed - currentTick));
        titleComponent.setFont(new Font("TimesRoman", 0, 13));
        titleComponent.setColor(this.titleColor);
        titleComponent.setPosition(new Point(this.position.x + 5, y - 5));
        titleComponent.render(graphics);
      }

      if (this.image != null) {
        Image newimg = this.image.getScaledInstance(80, 60, 4);
        graphics.drawImage(newimg, this.position.x - 15, y - 30, (ImageObserver)null);
      }

      return dimension;
    }
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public void setBackgroundColor(Color backgroundColor) {
    this.backgroundColor = backgroundColor;
  }
}