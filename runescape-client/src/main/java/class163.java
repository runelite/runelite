import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class163 {
   @ObfuscatedName("i")
   static int[][] field2204;
   @ObfuscatedName("j")
   static int[][] field2207;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1982131395
   )
   static int field2208;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1117522083
   )
   static int field2209;
   @ObfuscatedName("l")
   static int[] field2211;
   @ObfuscatedName("b")
   static int[] field2212;

   static {
      field2204 = new int[128][128];
      field2207 = new int[128][128];
      field2211 = new int[4096];
      field2212 = new int[4096];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1002241105"
   )
   public static int method3173(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
