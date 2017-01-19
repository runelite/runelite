import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fd")
public class class172 {
   @ObfuscatedName("f")
   public static int[] field2359 = new int[99];
   @ObfuscatedName("c")
   public static final boolean[] field2360 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2359[var1] = var0 / 4;
      }

   }
}
