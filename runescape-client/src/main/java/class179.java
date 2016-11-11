import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fd")
public class class179 {
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("i")
   static int[] field2955 = new int[32];
   @ObfuscatedName("h")
   @Export("settings")
   public static int[] settings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2955[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
