import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("DState")
public final class DState {
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("j")
   final int field2347;
   @ObfuscatedName("h")
   final int field2385;
   @ObfuscatedName("f")
   final int field2349;
   @ObfuscatedName("p")
   final int field2350;
   @ObfuscatedName("x")
   final int field2367;
   @ObfuscatedName("g")
   final int field2352;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -498436811
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1948209337
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("u")
   int[] field2368;
   @ObfuscatedName("q")
   int[] field2351;
   @ObfuscatedName("ax")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ao")
   boolean[] field2373;
   @ObfuscatedName("an")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ar")
   byte[] field2375;
   @ObfuscatedName("c")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ag")
   int[] field2362;
   @ObfuscatedName("av")
   byte[] field2377;
   @ObfuscatedName("ab")
   byte[] field2387;
   @ObfuscatedName("b")
   @Export("out")
   byte[] out;
   @ObfuscatedName("aj")
   byte[][] field2379;
   @ObfuscatedName("ae")
   int[][] field2380;
   @ObfuscatedName("at")
   int[][] field2348;
   @ObfuscatedName("as")
   int[][] field2370;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -46556397
   )
   int field2355;
   @ObfuscatedName("af")
   int[] field2383;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1865016971
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -15057621
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1036144043
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 663101623
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1681634193
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2083762647
   )
   int field2381;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1069072949
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1285234715
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("s")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1671175147
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1329937895
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1607548105
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1653862739
   )
   int field2384;

   DState() {
      this.field2347 = 4096;
      this.field2385 = 16;
      this.field2349 = 258;
      this.field2350 = 6;
      this.field2367 = 50;
      this.field2352 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2368 = new int[256];
      this.field2351 = new int[257];
      this.inUse = new boolean[256];
      this.field2373 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2375 = new byte[4096];
      this.field2362 = new int[16];
      this.field2377 = new byte[18002];
      this.field2387 = new byte[18002];
      this.field2379 = new byte[6][258];
      this.field2380 = new int[6][258];
      this.field2348 = new int[6][258];
      this.field2370 = new int[6][258];
      this.field2383 = new int[6];
   }
}
