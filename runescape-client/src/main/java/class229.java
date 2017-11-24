import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hz")
public class class229 {
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 30835451
   )
   static int field2911;
   @ObfuscatedName("x")
   public static final boolean[] field2916;
   @ObfuscatedName("k")
   public static int[] field2912;
   @ObfuscatedName("g")
   @Export("tt")
   static int[] tt;

   static {
      field2916 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2912 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2912[var1] = var0 / 4;
      }

   }
}
