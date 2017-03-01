import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class152 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2086231641
   )
   int field2044;
   @ObfuscatedName("n")
   final int field2045 = 16;
   @ObfuscatedName("g")
   final int field2046 = 258;
   @ObfuscatedName("v")
   final int field2047 = 6;
   @ObfuscatedName("y")
   final int field2048 = 50;
   @ObfuscatedName("p")
   final int field2049 = 18002;
   @ObfuscatedName("j")
   byte[] field2050;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 19854801
   )
   int field2051 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -947989553
   )
   int field2052;
   @ObfuscatedName("aa")
   byte[][] field2053 = new byte[6][258];
   @ObfuscatedName("au")
   byte[] field2054 = new byte[256];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -741522599
   )
   int field2055;
   @ObfuscatedName("x")
   final int field2056 = 4096;
   @ObfuscatedName("af")
   int[][] field2057 = new int[6][258];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1236145373
   )
   int field2058;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -809435227
   )
   int field2059;
   @ObfuscatedName("o")
   byte field2060;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1248280923
   )
   int field2061;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 611776437
   )
   int field2062;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -492654035
   )
   int field2063;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 75465489
   )
   int field2064;
   @ObfuscatedName("aq")
   byte[] field2065 = new byte[18002];
   @ObfuscatedName("e")
   int[] field2066 = new int[256];
   @ObfuscatedName("d")
   int[] field2067 = new int[257];
   @ObfuscatedName("ac")
   boolean[] field2068 = new boolean[16];
   @ObfuscatedName("ab")
   boolean[] field2069 = new boolean[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 252678941
   )
   int field2071;
   @ObfuscatedName("al")
   byte[] field2072 = new byte[4096];
   @ObfuscatedName("ae")
   int[] field2073 = new int[16];
   @ObfuscatedName("ad")
   byte[] field2074 = new byte[18002];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -453879333
   )
   int field2075 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -126316295
   )
   int field2076;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -962022501
   )
   int field2077;
   @ObfuscatedName("as")
   int[][] field2078 = new int[6][258];
   @ObfuscatedName("ao")
   int[][] field2079 = new int[6][258];
   @ObfuscatedName("ax")
   int[] field2080 = new int[6];
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 682222257
   )
   int field2081;
   @ObfuscatedName("i")
   byte[] field2082;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "856969023"
   )
   static int method2868(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
      } else {
         var3 = var2?class32.field731:class108.field1738;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field726[--class32.field735] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3290(var4, class32.scriptStringStack[--class30.scriptStringStackSize]);
            return 1;
         } else {
            --class30.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class32.field735 -= 2;
         var4 = class32.field726[class32.field735];
         int var5 = class32.field726[1 + class32.field735];
         var3.parent = class33.method774(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2284 = class32.field726[--class32.field735] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2326 = class32.field726[--class32.field735];
         return 1;
      } else if(var0 == 1304) {
         var3.field2226 = class32.field726[--class32.field735];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.scriptStringStack[--class30.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2251 = class32.scriptStringStack[--class30.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "-1912638282"
   )
   static int method2869(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class26.method620(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class26.method620(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
