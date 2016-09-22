import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fk")
public class class158 {
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -757390583
   )
   static int field2360;
   @ObfuscatedName("v")
   public static int[] field2361 = new int[99];
   @ObfuscatedName("d")
   public static final boolean[] field2364 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2361[var1] = var0 / 4;
      }

   }
}
