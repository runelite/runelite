import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class146 {
   @ObfuscatedName("y")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("o")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("k")
   public static int[] field2013 = new int[32];

   class146() throws Throwable {
      throw new Error();
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2013[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
