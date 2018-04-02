import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ij")
public class class248 {
   @ObfuscatedName("i")
   public static final boolean[] field3000;
   @ObfuscatedName("o")
   public static int[] field2998;

   static {
      field3000 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2998 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2998[var1] = var0 / 4;
      }

   }
}
