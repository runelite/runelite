import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("DState")
public final class DState {
   @ObfuscatedName("w")
   final int field2346;
   @ObfuscatedName("m")
   final int field2321;
   @ObfuscatedName("q")
   final int field2331;
   @ObfuscatedName("b")
   final int field2323;
   @ObfuscatedName("f")
   final int field2324;
   @ObfuscatedName("n")
   final int field2325;
   @ObfuscatedName("h")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1800892977
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 910858041
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("a")
   @Export("out")
   byte[] out;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1761265269
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1243729503
   )
   int field2350;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -835693075
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("p")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1531585341
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -912286717
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -452416119
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1685944411
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1971162567
   )
   int field2338;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 905913109
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1024464885
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("z")
   int[] field2341;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -532253957
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("r")
   int[] field2335;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 202945097
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ai")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("at")
   boolean[] field2344;
   @ObfuscatedName("ad")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ac")
   byte[] field2348;
   @ObfuscatedName("ay")
   int[] field2349;
   @ObfuscatedName("an")
   byte[] field2327;
   @ObfuscatedName("as")
   byte[] field2351;
   @ObfuscatedName("aw")
   byte[][] field2343;
   @ObfuscatedName("ag")
   int[][] field2352;
   @ObfuscatedName("ah")
   int[][] field2354;
   @ObfuscatedName("az")
   int[][] field2355;
   @ObfuscatedName("ao")
   int[] field2356;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -7269037
   )
   int field2330;

   DState() {
      this.field2346 = 4096;
      this.field2321 = 16;
      this.field2331 = 258;
      this.field2323 = 6;
      this.field2324 = 50;
      this.field2325 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2341 = new int[256];
      this.field2335 = new int[257];
      this.inUse = new boolean[256];
      this.field2344 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2348 = new byte[4096];
      this.field2349 = new int[16];
      this.field2327 = new byte[18002];
      this.field2351 = new byte[18002];
      this.field2343 = new byte[6][258];
      this.field2352 = new int[6][258];
      this.field2354 = new int[6][258];
      this.field2355 = new int[6][258];
      this.field2356 = new int[6];
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lhl;I)V",
      garbageValue = "229987315"
   )
   static void method3548(Widget var0) {
      if(var0.loopCycle == Client.field794) {
         Client.field795[var0.boundsIndex] = true;
      }

   }
}
