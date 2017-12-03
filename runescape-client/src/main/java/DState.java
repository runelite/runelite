import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("DState")
public final class DState {
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("a")
   final int field2469;
   @ObfuscatedName("w")
   final int field2501;
   @ObfuscatedName("e")
   final int field2470;
   @ObfuscatedName("k")
   final int field2505;
   @ObfuscatedName("u")
   final int field2472;
   @ObfuscatedName("z")
   final int field2471;
   @ObfuscatedName("t")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -23923469
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1159766183
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("j")
   @Export("out")
   byte[] out;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2097812977
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 846801231
   )
   int field2479;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1477017367
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("n")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1624378745
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -978960935
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -996553717
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1124898451
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1211375659
   )
   int field2486;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -928259005
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1742289959
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("b")
   int[] field2489;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1018799019
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("d")
   int[] field2507;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 861373207
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ab")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ad")
   boolean[] field2494;
   @ObfuscatedName("ag")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ak")
   byte[] field2496;
   @ObfuscatedName("as")
   int[] field2491;
   @ObfuscatedName("aq")
   byte[] field2483;
   @ObfuscatedName("ax")
   byte[] field2473;
   @ObfuscatedName("at")
   byte[][] field2503;
   @ObfuscatedName("ap")
   int[][] field2499;
   @ObfuscatedName("an")
   int[][] field2490;
   @ObfuscatedName("ac")
   int[][] field2497;
   @ObfuscatedName("aw")
   int[] field2504;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2002217715
   )
   int field2481;

   DState() {
      this.field2469 = 4096;
      this.field2501 = 16;
      this.field2470 = 258;
      this.field2505 = 6;
      this.field2472 = 50;
      this.field2471 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2489 = new int[256];
      this.field2507 = new int[257];
      this.inUse = new boolean[256];
      this.field2494 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2496 = new byte[4096];
      this.field2491 = new int[16];
      this.field2483 = new byte[18002];
      this.field2473 = new byte[18002];
      this.field2503 = new byte[6][258];
      this.field2499 = new int[6][258];
      this.field2490 = new int[6][258];
      this.field2497 = new int[6][258];
      this.field2504 = new int[6];
   }
}
