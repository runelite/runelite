import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class167 {
   @ObfuscatedName("e")
   public static int[][] field2218;
   @ObfuscatedName("k")
   public static int[][] field2216;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -126843981
   )
   public static int field2217;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -908241661
   )
   public static int field2215;
   @ObfuscatedName("f")
   public static int[] field2220;
   @ObfuscatedName("g")
   public static int[] field2221;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 1003510665
   )
   static int field2222;

   static {
      field2218 = new int[128][128];
      field2216 = new int[128][128];
      field2220 = new int[4096];
      field2221 = new int[4096];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1890373794"
   )
   static char method3158(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "109"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
