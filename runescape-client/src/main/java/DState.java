import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
@Implements("DState")
public final class DState {
   @ObfuscatedName("k")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("n")
   final int field2517;
   @ObfuscatedName("v")
   final int field2489;
   @ObfuscatedName("y")
   final int field2492;
   @ObfuscatedName("r")
   final int field2496;
   @ObfuscatedName("h")
   final int field2491;
   @ObfuscatedName("d")
   final int field2493;
   @ObfuscatedName("s")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 351948785
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2076941583
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("f")
   @Export("out")
   byte[] out;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -557167025
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1181902983
   )
   int field2499;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1425877647
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("w")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -918306367
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1124217457
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -958125921
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1993914323
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1892860957
   )
   int field2506;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2010383035
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1336172825
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("j")
   int[] field2509;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -895687597
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("c")
   int[] field2511;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 854844377
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ac")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("aw")
   boolean[] field2515;
   @ObfuscatedName("at")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ag")
   byte[] field2494;
   @ObfuscatedName("ad")
   int[] field2518;
   @ObfuscatedName("af")
   byte[] field2519;
   @ObfuscatedName("az")
   byte[] field2520;
   @ObfuscatedName("ae")
   byte[][] field2502;
   @ObfuscatedName("av")
   int[][] field2522;
   @ObfuscatedName("am")
   int[][] field2523;
   @ObfuscatedName("ax")
   int[][] field2503;
   @ObfuscatedName("ah")
   int[] field2525;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 813207201
   )
   int field2526;

   DState() {
      this.field2517 = 4096;
      this.field2489 = 16;
      this.field2492 = 258;
      this.field2496 = 6;
      this.field2491 = 50;
      this.field2493 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2509 = new int[256];
      this.field2511 = new int[257];
      this.inUse = new boolean[256];
      this.field2515 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2494 = new byte[4096];
      this.field2518 = new int[16];
      this.field2519 = new byte[18002];
      this.field2520 = new byte[18002];
      this.field2502 = new byte[6][258];
      this.field2522 = new int[6][258];
      this.field2523 = new int[6][258];
      this.field2503 = new int[6][258];
      this.field2525 = new int[6];
   }
}
