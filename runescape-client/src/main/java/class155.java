import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
public class class155 {
   @ObfuscatedName("bp")
   static class80[] field2284;
   @ObfuscatedName("u")
   public static final boolean[] field2285 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("x")
   public static int[] field2287 = new int[99];
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1556296171
   )
   static int field2289;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2287[var1] = var0 / 4;
      }

   }
}
