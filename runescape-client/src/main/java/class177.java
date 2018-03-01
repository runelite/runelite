import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class177 {
   @ObfuscatedName("n")
   public static int[][] field2272;
   @ObfuscatedName("r")
   public static int[][] field2270;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 527226453
   )
   public static int field2271;
   @ObfuscatedName("s")
   public static int[] field2274;
   @ObfuscatedName("p")
   public static int[] field2275;
   @ObfuscatedName("ac")
   static int[] field2277;

   static {
      field2272 = new int[128][128];
      field2270 = new int[128][128];
      field2274 = new int[4096];
      field2275 = new int[4096];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1972216268"
   )
   public static int method3467(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
