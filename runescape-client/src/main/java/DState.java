import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fk")
@Implements("DState")
public final class DState {
   @ObfuscatedName("e")
   final int field2358;
   @ObfuscatedName("n")
   final int field2334;
   @ObfuscatedName("g")
   final int field2345;
   @ObfuscatedName("y")
   final int field2369;
   @ObfuscatedName("w")
   final int field2333;
   @ObfuscatedName("k")
   final int field2338;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1005965551
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1383904291
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("b")
   int[] field2354;
   @ObfuscatedName("i")
   int[] field2356;
   @ObfuscatedName("ag")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ay")
   boolean[] field2361;
   @ObfuscatedName("au")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ah")
   byte[] field2343;
   @ObfuscatedName("v")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ao")
   int[] field2362;
   @ObfuscatedName("al")
   byte[] field2337;
   @ObfuscatedName("ae")
   byte[] field2364;
   @ObfuscatedName("u")
   @Export("out")
   byte[] out;
   @ObfuscatedName("ax")
   byte[][] field2365;
   @ObfuscatedName("az")
   int[][] field2366;
   @ObfuscatedName("aw")
   int[][] field2367;
   @ObfuscatedName("av")
   int[][] field2372;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 571681461
   )
   int field2344;
   @ObfuscatedName("ac")
   int[] field2335;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2095757447
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 727864113
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1464037429
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 133284531
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 169585221
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1295530675
   )
   int field2353;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2129791037
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 205078331
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("h")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -72719869
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1976304251
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1962685113
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1894416013
   )
   int field2347;

   DState() {
      this.field2358 = 4096;
      this.field2334 = 16;
      this.field2345 = 258;
      this.field2369 = 6;
      this.field2333 = 50;
      this.field2338 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2354 = new int[256];
      this.field2356 = new int[257];
      this.inUse = new boolean[256];
      this.field2361 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2343 = new byte[4096];
      this.field2362 = new int[16];
      this.field2337 = new byte[18002];
      this.field2364 = new byte[18002];
      this.field2365 = new byte[6][258];
      this.field2366 = new int[6][258];
      this.field2367 = new int[6][258];
      this.field2372 = new int[6][258];
      this.field2335 = new int[6];
   }
}
