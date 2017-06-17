import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public final class class172 {
   @ObfuscatedName("t")
   final int field2367;
   @ObfuscatedName("m")
   final int field2368;
   @ObfuscatedName("ak")
   byte[] field2369;
   @ObfuscatedName("av")
   boolean[] field2370;
   @ObfuscatedName("w")
   final int field2371;
   @ObfuscatedName("z")
   final int field2372;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2004029145
   )
   int field2373;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1971733977
   )
   int field2374;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -419031863
   )
   int field2375;
   @ObfuscatedName("j")
   byte[] field2376;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1104911719
   )
   int field2377;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2107458827
   )
   int field2378;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1216294115
   )
   int field2379;
   @ObfuscatedName("d")
   int[] field2380;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1441675599
   )
   int field2381;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 92562741
   )
   int field2382;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1051820909
   )
   int field2383;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -617504491
   )
   int field2384;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1837427893
   )
   int field2385;
   @ObfuscatedName("ax")
   boolean[] field2387;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1485800217
   )
   int field2388;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1524363091
   )
   int field2389;
   @ObfuscatedName("b")
   int[] field2390;
   @ObfuscatedName("am")
   int[][] field2391;
   @ObfuscatedName("af")
   byte[] field2392;
   @ObfuscatedName("a")
   byte field2393;
   @ObfuscatedName("ab")
   byte[][] field2394;
   @ObfuscatedName("ae")
   byte[] field2395;
   @ObfuscatedName("ap")
   int[] field2396;
   @ObfuscatedName("p")
   final int field2397;
   @ObfuscatedName("al")
   byte[] field2398;
   @ObfuscatedName("c")
   byte[] field2399;
   @ObfuscatedName("e")
   final int field2400;
   @ObfuscatedName("ar")
   int[][] field2401;
   @ObfuscatedName("ao")
   int[][] field2402;
   @ObfuscatedName("ac")
   int[] field2403;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -379526615
   )
   int field2404;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1578521607
   )
   int field2405;

   @ObfuscatedName("p")
   public static final void method3014(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            DecorativeObject.method2786(var0 - 1L);
            DecorativeObject.method2786(1L);
         } else {
            DecorativeObject.method2786(var0);
         }
      }

   }

   class172() {
      this.field2397 = 4096;
      this.field2368 = 16;
      this.field2400 = 258;
      this.field2367 = 6;
      this.field2371 = 50;
      this.field2372 = 18002;
      this.field2374 = 0;
      this.field2385 = 0;
      this.field2380 = new int[256];
      this.field2390 = new int[257];
      this.field2370 = new boolean[256];
      this.field2387 = new boolean[16];
      this.field2392 = new byte[256];
      this.field2395 = new byte[4096];
      this.field2396 = new int[16];
      this.field2369 = new byte[18002];
      this.field2398 = new byte[18002];
      this.field2394 = new byte[6][258];
      this.field2391 = new int[6][258];
      this.field2401 = new int[6][258];
      this.field2402 = new int[6][258];
      this.field2403 = new int[6];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-87603018"
   )
   public static Widget method3015(int var0, int var1) {
      Widget var2 = class223.method3959(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass186;I)Lclass186;",
      garbageValue = "-287910320"
   )
   static final class186 method3016(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class231.method3979(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new class198(var0.readInt());
         }

         var1.method3394((Node)var6, (long)var5);
      }

      return var1;
   }
}
