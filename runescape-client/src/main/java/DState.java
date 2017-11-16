import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("DState")
public final class DState {
   @ObfuscatedName("b")
   final int field2468;
   @ObfuscatedName("s")
   final int field2451;
   @ObfuscatedName("r")
   final int field2450;
   @ObfuscatedName("g")
   final int field2448;
   @ObfuscatedName("x")
   final int field2452;
   @ObfuscatedName("f")
   final int field2476;
   @ObfuscatedName("u")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 251916787
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1425919247
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("n")
   @Export("out")
   byte[] out;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -691557325
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2009339653
   )
   int field2473;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2088176887
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("q")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1530757167
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1058966911
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -535454133
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 468250861
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1083794207
   )
   int field2466;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -980691235
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 479772091
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("l")
   int[] field2469;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1844163885
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("e")
   int[] field2471;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1676934297
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("av")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("au")
   boolean[] field2474;
   @ObfuscatedName("ae")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ak")
   byte[] field2449;
   @ObfuscatedName("aq")
   int[] field2477;
   @ObfuscatedName("an")
   byte[] field2478;
   @ObfuscatedName("am")
   byte[] field2479;
   @ObfuscatedName("ar")
   byte[][] field2485;
   @ObfuscatedName("ao")
   int[][] field2481;
   @ObfuscatedName("at")
   int[][] field2482;
   @ObfuscatedName("ac")
   int[][] field2484;
   @ObfuscatedName("as")
   int[] field2480;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1877668911
   )
   int field2453;

   DState() {
      this.field2468 = 4096;
      this.field2451 = 16;
      this.field2450 = 258;
      this.field2448 = 6;
      this.field2452 = 50;
      this.field2476 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2469 = new int[256];
      this.field2471 = new int[257];
      this.inUse = new boolean[256];
      this.field2474 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2449 = new byte[4096];
      this.field2477 = new int[16];
      this.field2478 = new byte[18002];
      this.field2479 = new byte[18002];
      this.field2485 = new byte[6][258];
      this.field2481 = new int[6][258];
      this.field2482 = new int[6][258];
      this.field2484 = new int[6][258];
      this.field2480 = new int[6];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   public static void method3166() {
      ItemComposition.itemSpriteCache.reset();
   }
}
