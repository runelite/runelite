import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fx")
public class class175 {
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] field2890;
   @ObfuscatedName("r")
   @Export("settings")
   public static int[] field2891;
   @ObfuscatedName("bq")
   static class167 field2892;
   @ObfuscatedName("a")
   static int[] field2893 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2893[var1] = var0 - 1;
         var0 += var0;
      }

      field2891 = new int[2000];
      field2890 = new int[2000];
   }
}
