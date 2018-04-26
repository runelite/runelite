import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("is")
public class class248 {
   @ObfuscatedName("e")
   public static final boolean[] field3002;
   @ObfuscatedName("b")
   public static int[] field3007;

   static {
      field3002 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field3007 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field3007[var1] = var0 / 4;
      }

   }
}
