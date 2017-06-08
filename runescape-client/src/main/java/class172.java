import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public final class class172 {
   @ObfuscatedName("at")
   byte[][] field2358;
   @ObfuscatedName("as")
   int[][] field2359;
   @ObfuscatedName("k")
   int[] field2360;
   @ObfuscatedName("ad")
   byte[] field2362;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -68419999
   )
   int field2363;
   @ObfuscatedName("c")
   byte[] field2364;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1223389335
   )
   int field2365;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -540978573
   )
   int field2366;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2112252489
   )
   int field2367;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 331739751
   )
   int field2368;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 931654991
   )
   int field2369;
   @ObfuscatedName("g")
   byte[] field2370;
   @ObfuscatedName("a")
   byte field2371;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -572151717
   )
   int field2372;
   @ObfuscatedName("p")
   final int field2373;
   @ObfuscatedName("j")
   final int field2374;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 934929903
   )
   int field2375;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1245508443
   )
   int field2376;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1028888427
   )
   int field2377;
   @ObfuscatedName("f")
   final int field2378;
   @ObfuscatedName("l")
   int[] field2379;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1136375067
   )
   int field2380;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -183525453
   )
   int field2381;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1270234067
   )
   int field2382;
   @ObfuscatedName("ae")
   boolean[] field2383;
   @ObfuscatedName("ao")
   boolean[] field2384;
   @ObfuscatedName("i")
   final int field2385;
   @ObfuscatedName("aa")
   byte[] field2386;
   @ObfuscatedName("aw")
   int[] field2387;
   @ObfuscatedName("an")
   byte[] field2388;
   @ObfuscatedName("al")
   byte[] field2389;
   @ObfuscatedName("m")
   final int field2390;
   @ObfuscatedName("au")
   int[][] field2391;
   @ObfuscatedName("ak")
   int[][] field2392;
   @ObfuscatedName("n")
   final int field2393;
   @ObfuscatedName("ah")
   int[] field2394;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -598320437
   )
   int field2395;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -95752485
   )
   int field2396;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public static void method3140() {
      class59 var0 = class59.mouse;
      synchronized(class59.mouse) {
         class59.field716 = class59.field712;
         class59.field729 = class59.mouseX;
         class59.field715 = class59.mouseY;
         class59.field713 = class59.field718;
         class59.field723 = class59.field717;
         class59.field724 = class59.field720;
         class59.field725 = class59.field721;
         class59.field718 = 0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "549973734"
   )
   public static int method3141(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-496346144"
   )
   public static void method3142() {
      if(class238.field3272 != null) {
         class238.field3272.method2989();
      }

   }

   class172() {
      this.field2393 = 4096;
      this.field2373 = 16;
      this.field2385 = 258;
      this.field2374 = 6;
      this.field2378 = 50;
      this.field2390 = 18002;
      this.field2365 = 0;
      this.field2368 = 0;
      this.field2379 = new int[256];
      this.field2360 = new int[257];
      this.field2383 = new boolean[256];
      this.field2384 = new boolean[16];
      this.field2362 = new byte[256];
      this.field2386 = new byte[4096];
      this.field2387 = new int[16];
      this.field2388 = new byte[18002];
      this.field2389 = new byte[18002];
      this.field2358 = new byte[6][258];
      this.field2391 = new int[6][258];
      this.field2392 = new int[6][258];
      this.field2359 = new int[6][258];
      this.field2394 = new int[6];
   }
}
