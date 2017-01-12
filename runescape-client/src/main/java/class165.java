import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fh")
public class class165 {
   @ObfuscatedName("qz")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("i")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("mu")
   static byte field2147;
   @ObfuscatedName("x")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("u")
   public static int[] field2149 = new int[32];
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1995036269
   )
   @Export("cameraPitch")
   static int cameraPitch;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2149[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
