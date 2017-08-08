import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class212 {
   @ObfuscatedName("e")
   static int[] field2583;
   @ObfuscatedName("n")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("g")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      field2583 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2583[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
