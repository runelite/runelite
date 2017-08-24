import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("DState")
public final class DState {
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field2389;
   @ObfuscatedName("i")
   final int field2354;
   @ObfuscatedName("j")
   final int field2356;
   @ObfuscatedName("a")
   final int field2352;
   @ObfuscatedName("r")
   final int field2363;
   @ObfuscatedName("o")
   final int field2364;
   @ObfuscatedName("n")
   final int field2355;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1373952741
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2108985407
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("x")
   int[] field2371;
   @ObfuscatedName("f")
   int[] field2377;
   @ObfuscatedName("ar")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ax")
   boolean[] field2376;
   @ObfuscatedName("al")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ag")
   byte[] field2378;
   @ObfuscatedName("q")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ad")
   int[] field2381;
   @ObfuscatedName("ab")
   byte[] field2380;
   @ObfuscatedName("am")
   byte[] field2359;
   @ObfuscatedName("s")
   @Export("out")
   byte[] out;
   @ObfuscatedName("aq")
   byte[][] field2374;
   @ObfuscatedName("at")
   int[][] field2353;
   @ObfuscatedName("az")
   int[][] field2384;
   @ObfuscatedName("ac")
   int[][] field2385;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 592164047
   )
   int field2361;
   @ObfuscatedName("aa")
   int[] field2386;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1376543309
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -238509459
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1618576831
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2099125585
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1548268215
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1437528423
   )
   int field2368;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1726999431
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -358443131
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("y")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1879100503
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 344419223
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 829883367
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1649833941
   )
   int field2387;

   DState() {
      this.field2354 = 4096;
      this.field2356 = 16;
      this.field2352 = 258;
      this.field2363 = 6;
      this.field2364 = 50;
      this.field2355 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2371 = new int[256];
      this.field2377 = new int[257];
      this.inUse = new boolean[256];
      this.field2376 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2378 = new byte[4096];
      this.field2381 = new int[16];
      this.field2380 = new byte[18002];
      this.field2359 = new byte[18002];
      this.field2374 = new byte[6][258];
      this.field2353 = new int[6][258];
      this.field2384 = new int[6][258];
      this.field2385 = new int[6][258];
      this.field2386 = new int[6];
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Lbg;II)V",
      garbageValue = "-866553597"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class56.method865(var0.x, var0.y, var1);
   }
}
