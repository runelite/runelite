import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
public class class233 {
   @ObfuscatedName("w")
   public static final boolean[] field2943;
   @ObfuscatedName("e")
   public static int[] field2942;

   static {
      field2943 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2942 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2942[var1] = var0 / 4;
      }

   }
}
