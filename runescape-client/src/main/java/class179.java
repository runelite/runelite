import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fu")
public class class179 {
   @ObfuscatedName("g")
   @Export("settings")
   public static int[] field2957;
   @ObfuscatedName("r")
   @Export("widgetSettings")
   public static int[] field2958;
   @ObfuscatedName("l")
   static int[] field2959 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2959[var1] = var0 - 1;
         var0 += var0;
      }

      field2957 = new int[2000];
      field2958 = new int[2000];
   }
}
