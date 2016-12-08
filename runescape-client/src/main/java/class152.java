import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public final class class152 {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1385618535
   )
   int field2063;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1576331515
   )
   int field2064;
   @ObfuscatedName("b")
   final int field2065 = 258;
   @ObfuscatedName("au")
   byte[] field2066 = new byte[256];
   @ObfuscatedName("h")
   final int field2067 = 50;
   @ObfuscatedName("v")
   final int field2068 = 18002;
   @ObfuscatedName("l")
   byte[] field2069;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -625907425
   )
   int field2070 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 954536003
   )
   int field2071;
   @ObfuscatedName("k")
   byte[] field2072;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -904949085
   )
   int field2073 = 0;
   @ObfuscatedName("an")
   int[] field2075 = new int[6];
   @ObfuscatedName("f")
   byte field2076;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -642015217
   )
   int field2077;
   @ObfuscatedName("ay")
   int[][] field2078 = new int[6][258];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1727280919
   )
   int field2080;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -796304781
   )
   int field2081;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 735787017
   )
   int field2082;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1882786503
   )
   int field2083;
   @ObfuscatedName("q")
   int[] field2084 = new int[256];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1773472581
   )
   int field2085;
   @ObfuscatedName("r")
   int[] field2086 = new int[257];
   @ObfuscatedName("ae")
   int[] field2087 = new int[16];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2063049537
   )
   int field2088;
   @ObfuscatedName("ag")
   boolean[] field2089 = new boolean[16];
   @ObfuscatedName("m")
   final int field2090 = 16;
   @ObfuscatedName("aa")
   byte[] field2091 = new byte[4096];
   @ObfuscatedName("g")
   final int field2092 = 6;
   @ObfuscatedName("av")
   byte[] field2093 = new byte[18002];
   @ObfuscatedName("ao")
   byte[] field2094 = new byte[18002];
   @ObfuscatedName("ah")
   byte[][] field2095 = new byte[6][258];
   @ObfuscatedName("ak")
   int[][] field2096 = new int[6][258];
   @ObfuscatedName("ab")
   int[][] field2097 = new int[6][258];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2097839567
   )
   int field2098;
   @ObfuscatedName("o")
   final int field2099 = 4096;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1491089745
   )
   int field2100;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -953054609
   )
   int field2101;
   @ObfuscatedName("am")
   boolean[] field2102 = new boolean[256];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)LSpritePixels;",
      garbageValue = "-84"
   )
   public static SpritePixels method2709(class182 var0, int var1, int var2) {
      if(!Friend.method170(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.field3208 = class204.field3077;
         var4.field3209 = class225.field3216;
         var4.field3203 = class211.field3125[0];
         var4.field3211 = class225.field3217[0];
         var4.width = FaceNormal.field1557[0];
         var4.height = FileOnDisk.field1199[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = XGrandExchangeOffer.field36[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class225.field3215[var6[var7] & 255];
         }

         class176.method3182();
         return var4;
      }
   }
}
