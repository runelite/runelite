import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public final class class172 {
   @ObfuscatedName("t")
   final int field2358;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1919343793
   )
   int field2359;
   @ObfuscatedName("a")
   final int field2360;
   @ObfuscatedName("de")
   @Export("host")
   static String host;
   @ObfuscatedName("v")
   byte[] field2362;
   @ObfuscatedName("r")
   final int field2363;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2045168799
   )
   int field2364;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -525579473
   )
   int field2365;
   @ObfuscatedName("ak")
   int[][] field2366;
   @ObfuscatedName("k")
   byte[] field2367;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 719412369
   )
   int field2368;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2136561499
   )
   int field2369;
   @ObfuscatedName("i")
   final int field2370;
   @ObfuscatedName("h")
   int[] field2371;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 118838505
   )
   int field2372;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 783109979
   )
   int field2373;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1365448899
   )
   int field2374;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1881597305
   )
   int field2375;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1706566721
   )
   int field2376;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1473187829
   )
   int field2377;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1984082073
   )
   int field2378;
   @ObfuscatedName("q")
   int[] field2379;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 946244127
   )
   int field2380;
   @ObfuscatedName("aw")
   byte[] field2381;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1071787417
   )
   int field2382;
   @ObfuscatedName("ah")
   boolean[] field2383;
   @ObfuscatedName("ab")
   boolean[] field2384;
   @ObfuscatedName("s")
   final int field2385;
   @ObfuscatedName("w")
   final int field2386;
   @ObfuscatedName("an")
   int[] field2387;
   @ObfuscatedName("au")
   byte[] field2388;
   @ObfuscatedName("ar")
   byte[] field2389;
   @ObfuscatedName("ay")
   byte[][] field2390;
   @ObfuscatedName("ao")
   int[][] field2391;
   @ObfuscatedName("l")
   byte field2392;
   @ObfuscatedName("ai")
   byte[] field2393;
   @ObfuscatedName("aq")
   int[] field2394;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1733494453
   )
   int field2395;
   @ObfuscatedName("as")
   int[][] field2396;

   class172() {
      this.field2370 = 4096;
      this.field2386 = 16;
      this.field2360 = 258;
      this.field2358 = 6;
      this.field2385 = 50;
      this.field2363 = 18002;
      this.field2365 = 0;
      this.field2368 = 0;
      this.field2379 = new int[256];
      this.field2371 = new int[257];
      this.field2383 = new boolean[256];
      this.field2384 = new boolean[16];
      this.field2381 = new byte[256];
      this.field2393 = new byte[4096];
      this.field2387 = new int[16];
      this.field2388 = new byte[18002];
      this.field2389 = new byte[18002];
      this.field2390 = new byte[6][258];
      this.field2391 = new int[6][258];
      this.field2396 = new int[6][258];
      this.field2366 = new int[6][258];
      this.field2394 = new int[6];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "258382951"
   )
   public static synchronized long method3128() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2417) {
         class175.field2418 += class175.field2417 - var0;
      }

      class175.field2417 = var0;
      return var0 + class175.field2418;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-2094233261"
   )
   public static ModIcon method3129(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4146(var1);
      int var4 = var0.method4131(var3, var2);
      ModIcon var5;
      if(!class223.method4073(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class268.method4861();
      }

      return var5;
   }
}
