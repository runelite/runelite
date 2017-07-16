import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("DState")
public final class DState {
   @ObfuscatedName("a")
   final int field2369;
   @ObfuscatedName("j")
   final int field2352;
   @ObfuscatedName("n")
   final int field2353;
   @ObfuscatedName("r")
   final int field2354;
   @ObfuscatedName("v")
   final int field2355;
   @ObfuscatedName("e")
   final int field2356;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1509705155
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1512257199
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("i")
   int[] field2384;
   @ObfuscatedName("b")
   int[] field2374;
   @ObfuscatedName("ai")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ae")
   boolean[] field2377;
   @ObfuscatedName("au")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ak")
   byte[] field2382;
   @ObfuscatedName("l")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ap")
   int[] field2380;
   @ObfuscatedName("ar")
   byte[] field2381;
   @ObfuscatedName("am")
   byte[] field2372;
   @ObfuscatedName("p")
   @Export("out")
   byte[] out;
   @ObfuscatedName("aw")
   byte[][] field2383;
   @ObfuscatedName("aq")
   int[][] field2365;
   @ObfuscatedName("aa")
   int[][] field2351;
   @ObfuscatedName("ag")
   int[][] field2357;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -709712205
   )
   int field2362;
   @ObfuscatedName("aj")
   int[] field2385;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 243699047
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 204000937
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1438857879
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 890503279
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1778886461
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1854566573
   )
   int field2358;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -906791061
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1660207153
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("k")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1450975749
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1938605567
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 339907897
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1295590251
   )
   int field2388;

   DState() {
      this.field2369 = 4096;
      this.field2352 = 16;
      this.field2353 = 258;
      this.field2354 = 6;
      this.field2355 = 50;
      this.field2356 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2384 = new int[256];
      this.field2374 = new int[257];
      this.inUse = new boolean[256];
      this.field2377 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2382 = new byte[4096];
      this.field2380 = new int[16];
      this.field2381 = new byte[18002];
      this.field2372 = new byte[18002];
      this.field2383 = new byte[6][258];
      this.field2365 = new int[6][258];
      this.field2351 = new int[6][258];
      this.field2357 = new int[6][258];
      this.field2385 = new int[6];
   }

   @ObfuscatedName("a")
   static final int method3120(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (var2 + 1.0D);
         } else {
            var12 = var2 + var4 - var4 * var2;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + var16 * (var12 - var14) * 6.0D;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = 6.0D * (var12 - var14) * (0.6666666666666666D - var16) + var14;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var14 + var0 * (var12 - var14) * 6.0D;
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = (var12 - var14) * (0.6666666666666666D - var0) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * var20;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = var14 + (0.6666666666666666D - var20) * (var12 - var14) * 6.0D;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "990633087"
   )
   static char method3121(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
