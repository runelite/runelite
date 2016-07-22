import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fw")
public class class179 {
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] field2949;
   @ObfuscatedName("w")
   @Export("settings")
   public static int[] field2950;
   @ObfuscatedName("m")
   static int[] field2952 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2952[var1] = var0 - 1;
         var0 += var0;
      }

      field2950 = new int[2000];
      field2949 = new int[2000];
   }
}
