import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class109 {
   @ObfuscatedName("f")
   public static int[][] field1924 = new int[128][128];
   @ObfuscatedName("m")
   public static short[] field1925;
   @ObfuscatedName("c")
   public static int[][] field1927 = new int[128][128];
   @ObfuscatedName("y")
   public static int[] field1928 = new int[4096];
   @ObfuscatedName("u")
   public static int[] field1929 = new int[4096];
   @ObfuscatedName("br")
   static class171 field1932;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 490208187
   )
   public static int field1934;

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "334696818"
   )
   static final int method2439(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.tileHeights[var5][var3 + 1][var4] * var6 + class5.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = (128 - var6) * class5.tileHeights[var5][var3][var4 + 1] + var6 * class5.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-600069423"
   )
   public static boolean method2442() {
      return class186.field3007 != 0?true:class186.field3008.method3646();
   }
}
