import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hx")
public class class211 {
   @ObfuscatedName("w")
   static int[] field2596;
   @ObfuscatedName("s")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("q")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      field2596 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2596[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
