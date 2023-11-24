package net.runelite.client.plugins.raids3Util;

import java.awt.Color;

public class OverlayUtility {
  public static Color MakeTransparent(Color source, int alpha) {
    return new Color(source.getRed(), source.getGreen(), source.getBlue(), alpha);
  }

  public static Color setBrightness(Color color, float brightness) {
    brightness /= 100.0F;
    if (brightness >= 0.0F && brightness <= 1.0F) {
      int alpha = color.getAlpha();
      float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), (float[])null);
      Color c = Color.getHSBColor(hsb[0], hsb[1], brightness);
      return setAlpha(c, alpha);
    } else {
      throw new IllegalArgumentException("invalid brightness value");
    }
  }

  public static Color setAlpha(Color color, int alpha) {
    if (alpha >= 0 && alpha <= 255) {
      return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    } else {
      throw new IllegalArgumentException("invalid alpha value");
    }
  }

  public static Color CreateColor(Color color, int overlayBrightness, int overlayAlpha) {
    return setBrightness(new Color(color.getRed(), color.getGreen(), color.getBlue(), overlayAlpha), (float)overlayBrightness);
  }
}