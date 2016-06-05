import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
public class class176 {
   @ObfuscatedName("g")
   @Export("widgetSettings")
   public static int[] field2923;
   @ObfuscatedName("i")
   @Export("settings")
   public static int[] field2924;
   @ObfuscatedName("t")
   public static int[] field2926 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2926[var1] = var0 - 1;
         var0 += var0;
      }

      field2924 = new int[2000];
      field2923 = new int[2000];
   }
}
