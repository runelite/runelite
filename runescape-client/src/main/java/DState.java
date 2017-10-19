import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
@Implements("DState")
public final class DState {
   @ObfuscatedName("bf")
   static String field2346;
   @ObfuscatedName("w")
   final int field2366;
   @ObfuscatedName("s")
   final int field2362;
   @ObfuscatedName("q")
   final int field2348;
   @ObfuscatedName("o")
   final int field2367;
   @ObfuscatedName("g")
   final int field2350;
   @ObfuscatedName("v")
   final int field2359;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1437739887
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -945229029
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("c")
   int[] field2347;
   @ObfuscatedName("m")
   int[] field2383;
   @ObfuscatedName("ap")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("af")
   boolean[] field2372;
   @ObfuscatedName("aa")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ay")
   byte[] field2374;
   @ObfuscatedName("p")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("aw")
   int[] field2375;
   @ObfuscatedName("az")
   byte[] field2376;
   @ObfuscatedName("at")
   byte[] field2349;
   @ObfuscatedName("x")
   @Export("out")
   byte[] out;
   @ObfuscatedName("ao")
   byte[][] field2378;
   @ObfuscatedName("aq")
   int[][] field2379;
   @ObfuscatedName("ax")
   int[][] field2357;
   @ObfuscatedName("av")
   int[][] field2381;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2128885409
   )
   int field2369;
   @ObfuscatedName("al")
   int[] field2382;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -677955593
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -177674679
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -151271297
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1539829691
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1662362007
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1273807889
   )
   int field2364;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -892530251
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -332012265
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("t")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2128180009
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1988434537
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 883899617
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -245599409
   )
   int field2353;

   DState() {
      this.field2366 = 4096;
      this.field2362 = 16;
      this.field2348 = 258;
      this.field2367 = 6;
      this.field2350 = 50;
      this.field2359 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2347 = new int[256];
      this.field2383 = new int[257];
      this.inUse = new boolean[256];
      this.field2372 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2374 = new byte[4096];
      this.field2375 = new int[16];
      this.field2376 = new byte[18002];
      this.field2349 = new byte[18002];
      this.field2378 = new byte[6][258];
      this.field2379 = new int[6][258];
      this.field2357 = new int[6][258];
      this.field2381 = new int[6][258];
      this.field2382 = new int[6];
   }
}
