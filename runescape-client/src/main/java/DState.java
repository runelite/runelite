import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
@Implements("DState")
public final class DState {
   @ObfuscatedName("m")
   final int field2491;
   @ObfuscatedName("p")
   final int field2456;
   @ObfuscatedName("i")
   final int field2457;
   @ObfuscatedName("j")
   final int field2458;
   @ObfuscatedName("v")
   final int field2459;
   @ObfuscatedName("x")
   final int field2460;
   @ObfuscatedName("e")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1607525235
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1728945443
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("n")
   @Export("out")
   byte[] out;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1222310227
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -634165385
   )
   int field2466;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 751274997
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("w")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 937937843
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 67417009
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1884399797
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1914345477
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1303273545
   )
   int field2473;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -580264183
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1060035321
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("o")
   int[] field2476;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1332615271
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("s")
   int[] field2478;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -480907357
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("al")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ao")
   boolean[] field2461;
   @ObfuscatedName("aq")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ab")
   byte[] field2483;
   @ObfuscatedName("as")
   int[] field2484;
   @ObfuscatedName("ag")
   byte[] field2490;
   @ObfuscatedName("ap")
   byte[] field2486;
   @ObfuscatedName("av")
   byte[][] field2488;
   @ObfuscatedName("ak")
   int[][] field2470;
   @ObfuscatedName("at")
   int[][] field2469;
   @ObfuscatedName("an")
   int[][] field2455;
   @ObfuscatedName("ah")
   int[] field2464;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1904495159
   )
   int field2492;

   DState() {
      this.field2491 = 4096;
      this.field2456 = 16;
      this.field2457 = 258;
      this.field2458 = 6;
      this.field2459 = 50;
      this.field2460 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2476 = new int[256];
      this.field2478 = new int[257];
      this.inUse = new boolean[256];
      this.field2461 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2483 = new byte[4096];
      this.field2484 = new int[16];
      this.field2490 = new byte[18002];
      this.field2486 = new byte[18002];
      this.field2488 = new byte[6][258];
      this.field2470 = new int[6][258];
      this.field2469 = new int[6][258];
      this.field2455 = new int[6][258];
      this.field2464 = new int[6];
   }
}
