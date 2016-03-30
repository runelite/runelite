import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class155 {
   @ObfuscatedName("t")
   public static int[] field2319 = new int[99];
   @ObfuscatedName("x")
   public static final boolean[] field2320 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 273901269
   )
   static int field2322;
   @ObfuscatedName("ph")
   static short[] field2323;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2319[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("x")
   public static boolean method3192(int var0) {
      return 0 != (var0 >> 20 & 1);
   }
}
