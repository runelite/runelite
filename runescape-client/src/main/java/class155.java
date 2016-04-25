import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class155 {
   @ObfuscatedName("h")
   public static final boolean[] field2278 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("m")
   public static int[] field2279 = new int[99];

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2279[var1] = var0 / 4;
      }

   }
}
