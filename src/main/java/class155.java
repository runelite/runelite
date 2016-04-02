import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class155 {
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 385017403
   )
   static int field2281;
   @ObfuscatedName("w")
   public static final boolean[] field2282 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("f")
   public static int[] field2284 = new int[99];
   @ObfuscatedName("y")
   public static boolean field2289;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2284[var1] = var0 / 4;
      }

   }
}
