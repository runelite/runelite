import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class211 {
   @Export("settings")
   @ObfuscatedName("h")
   public static int[] settings;
   @ObfuscatedName("u")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("i")
   public static int[] field2597;

   static {
      field2597 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2597[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
