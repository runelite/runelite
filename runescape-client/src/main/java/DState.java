import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fe")
@Implements("DState")
public final class DState {
   @ObfuscatedName("bi")
   static String field2392;
   @ObfuscatedName("d")
   final int field2380;
   @ObfuscatedName("k")
   final int field2364;
   @ObfuscatedName("e")
   final int field2365;
   @ObfuscatedName("p")
   final int field2366;
   @ObfuscatedName("q")
   final int field2367;
   @ObfuscatedName("s")
   final int field2368;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 975863447
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1794365947
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("z")
   int[] field2384;
   @ObfuscatedName("w")
   int[] field2389;
   @ObfuscatedName("ae")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ai")
   boolean[] field2376;
   @ObfuscatedName("ah")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ab")
   byte[] field2391;
   @ObfuscatedName("r")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ad")
   int[] field2393;
   @ObfuscatedName("ag")
   byte[] field2386;
   @ObfuscatedName("as")
   byte[] field2394;
   @ObfuscatedName("t")
   @Export("out")
   byte[] out;
   @ObfuscatedName("af")
   byte[][] field2395;
   @ObfuscatedName("aq")
   int[][] field2396;
   @ObfuscatedName("am")
   int[][] field2379;
   @ObfuscatedName("az")
   int[][] field2398;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1511289919
   )
   int field2374;
   @ObfuscatedName("av")
   int[] field2371;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1069694485
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 794606043
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1811412485
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 280590623
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1294842793
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -628799919
   )
   int field2381;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1477142183
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1909943707
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("u")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 630988421
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -861978257
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1279984207
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -210041663
   )
   int field2400;

   DState() {
      this.field2380 = 4096;
      this.field2364 = 16;
      this.field2365 = 258;
      this.field2366 = 6;
      this.field2367 = 50;
      this.field2368 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2384 = new int[256];
      this.field2389 = new int[257];
      this.inUse = new boolean[256];
      this.field2376 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2391 = new byte[4096];
      this.field2393 = new int[16];
      this.field2386 = new byte[18002];
      this.field2394 = new byte[18002];
      this.field2395 = new byte[6][258];
      this.field2396 = new int[6][258];
      this.field2379 = new int[6][258];
      this.field2398 = new int[6][258];
      this.field2371 = new int[6];
   }
}
