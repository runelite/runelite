import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class172 {
   @ObfuscatedName("ae")
   int[][] field2337;
   @ObfuscatedName("h")
   final int field2338;
   @ObfuscatedName("u")
   final int field2339;
   @ObfuscatedName("ah")
   boolean[] field2340;
   @ObfuscatedName("g")
   final int field2341;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2070515211
   )
   int field2342;
   @ObfuscatedName("t")
   byte[] field2343;
   @ObfuscatedName("q")
   final int field2344;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2110024515
   )
   int field2345;
   @ObfuscatedName("a")
   byte[] field2346;
   @ObfuscatedName("aj")
   byte[] field2347;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1720077505
   )
   int field2348;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -983473073
   )
   int field2349;
   @ObfuscatedName("x")
   byte field2350;
   @ObfuscatedName("ay")
   boolean[] field2351;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1961275081
   )
   int field2352;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1554189295
   )
   static int field2353;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1711277145
   )
   int field2354;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1284726621
   )
   int field2355;
   @ObfuscatedName("i")
   final int field2356;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1326780289
   )
   int field2357;
   @ObfuscatedName("y")
   int[] field2358;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1104988141
   )
   int field2359;
   @ObfuscatedName("f")
   int[] field2360;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -716876875
   )
   int field2361;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1686717067
   )
   int field2362;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1305820907
   )
   int field2363;
   @ObfuscatedName("az")
   byte[] field2364;
   @ObfuscatedName("ac")
   byte[] field2365;
   @ObfuscatedName("aq")
   int[] field2366;
   @ObfuscatedName("av")
   int[][] field2367;
   @ObfuscatedName("om")
   static SpritePixels field2368;
   @ObfuscatedName("ax")
   byte[][] field2369;
   @ObfuscatedName("af")
   byte[] field2370;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -967569359
   )
   int field2371;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -820292563
   )
   int field2372;
   @ObfuscatedName("ar")
   int[] field2373;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -272337971
   )
   int field2374;
   @ObfuscatedName("ad")
   int[][] field2375;
   @ObfuscatedName("v")
   final int field2376;

   class172() {
      this.field2356 = 4096;
      this.field2338 = 16;
      this.field2339 = 258;
      this.field2344 = 6;
      this.field2341 = 50;
      this.field2376 = 18002;
      this.field2362 = 0;
      this.field2342 = 0;
      this.field2358 = new int[256];
      this.field2360 = new int[257];
      this.field2351 = new boolean[256];
      this.field2340 = new boolean[16];
      this.field2364 = new byte[256];
      this.field2365 = new byte[4096];
      this.field2366 = new int[16];
      this.field2370 = new byte[18002];
      this.field2347 = new byte[18002];
      this.field2369 = new byte[6][258];
      this.field2375 = new int[6][258];
      this.field2367 = new int[6][258];
      this.field2337 = new int[6][258];
      this.field2373 = new int[6];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-839058742"
   )
   static void method3183() {
      Object var0 = class236.field3225;
      synchronized(class236.field3225) {
         if(class236.field3227 == 0) {
            Player.field879 = new Thread(new class236());
            Player.field879.setDaemon(true);
            Player.field879.start();
            Player.field879.setPriority(5);
         }

         class236.field3227 = 600;
      }
   }
}
