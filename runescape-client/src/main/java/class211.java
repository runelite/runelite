import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hu")
public class class211 {
   @ObfuscatedName("c")
   public static int[] field2576;
   @ObfuscatedName("o")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("i")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      field2576 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2576[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
