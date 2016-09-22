import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fb")
public class class179 {
   @ObfuscatedName("d")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("a")
   public static int[] field2967 = new int[32];
   @ObfuscatedName("v")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2967[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
