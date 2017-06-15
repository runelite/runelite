import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
public class class222 {
   @ObfuscatedName("ey")
   static RSSocket field2846;
   @ObfuscatedName("z")
   protected static boolean field2849;
   @ObfuscatedName("m")
   public static final boolean[] field2850;
   @ObfuscatedName("e")
   public static int[] field2851;

   static {
      field2850 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2851 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2851[var1] = var0 / 4;
      }

   }
}
