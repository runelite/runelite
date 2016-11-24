import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public final class class11 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1821529177
   )
   static int field102 = 99;
   @ObfuscatedName("d")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("ds")
   static byte[][] field104;
   @ObfuscatedName("h")
   static byte[][][] field105;
   @ObfuscatedName("w")
   static byte[][][] field106;
   @ObfuscatedName("c")
   static byte[][][] field107;
   @ObfuscatedName("i")
   static final int[] field108 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("a")
   static final int[] field109 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("n")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 239102955
   )
   static int field111 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("k")
   static final int[] field112 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("v")
   static final int[] field113 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("nf")
   static class57 field114;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -785814737
   )
   static int field115 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("j")
   static final int[] field116 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("b")
   static final int[] field117 = new int[]{1, 0, -1, 0};

   @ObfuscatedName("n")
   public static String method159(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3074[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "301115641"
   )
   public static void method160() {
      Widget.field2063.reset();
      Widget.field2064.reset();
      Widget.field2101.reset();
      Widget.field2191.reset();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1792374325"
   )
   static final int method161(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * tileHeights[var5][var3][var4] >> 7;
         int var9 = (128 - var6) * tileHeights[var5][var3][var4 + 1] + tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }
}
