import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class172 {
   @ObfuscatedName("i")
   public static int[] field2333 = new int[99];
   @ObfuscatedName("x")
   public static final boolean[] field2335 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2333[var1] = var0 / 4;
      }

   }
}
