import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fq")
public class class165 {
   @ObfuscatedName("j")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("c")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("q")
   static class228 field2155;
   @ObfuscatedName("x")
   public static int[] field2156 = new int[32];

   class165() throws Throwable {
      throw new Error();
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2156[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
