import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class172 {
   @ObfuscatedName("y")
   public static final boolean[] field2333 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("o")
   public static int[] field2334 = new int[99];

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)[Lclass214;",
      garbageValue = "102"
   )
   public static class214[] method3249() {
      return new class214[]{class214.field3144, class214.field3141, class214.field3150, class214.field3149, class214.field3137, class214.field3138, class214.field3148, class214.field3147, class214.field3139, class214.field3145, class214.field3146, class214.field3136, class214.field3140, class214.field3142, class214.field3143};
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2334[var1] = var0 / 4;
      }

   }

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-86"
   )
   public static int method3250(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2086668818"
   )
   static final int method3251(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (var2 * var2 * 15731 + 789221) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
