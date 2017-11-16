import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class229 {
   @ObfuscatedName("s")
   public static final boolean[] field2898;
   @ObfuscatedName("r")
   public static int[] field2900;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;

   static {
      field2898 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2900 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2900[var1] = var0 / 4;
      }

   }
}
