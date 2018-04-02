import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("DState")
public final class DState {
   @ObfuscatedName("c")
   final int field2560;
   @ObfuscatedName("i")
   final int field2528;
   @ObfuscatedName("o")
   final int field2529;
   @ObfuscatedName("j")
   final int field2530;
   @ObfuscatedName("k")
   final int field2531;
   @ObfuscatedName("x")
   final int field2551;
   @ObfuscatedName("z")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1543513409
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1949852487
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("r")
   @Export("out")
   byte[] out;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -154623411
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1002899189
   )
   int field2550;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1544859891
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("f")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2142325623
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1463448079
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 425024153
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1870090557
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 171055811
   )
   int field2534;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -586650107
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1768844759
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("u")
   int[] field2548;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -168965799
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("g")
   int[] field2545;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1270772263
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ac")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ap")
   boolean[] field2553;
   @ObfuscatedName("al")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ai")
   byte[] field2555;
   @ObfuscatedName("ab")
   int[] field2556;
   @ObfuscatedName("ak")
   byte[] field2557;
   @ObfuscatedName("as")
   byte[] field2558;
   @ObfuscatedName("aa")
   byte[][] field2559;
   @ObfuscatedName("ah")
   int[][] field2549;
   @ObfuscatedName("ao")
   int[][] field2561;
   @ObfuscatedName("am")
   int[][] field2562;
   @ObfuscatedName("aq")
   int[] field2533;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1305417289
   )
   int field2564;

   DState() {
      this.field2560 = 4096;
      this.field2528 = 16;
      this.field2529 = 258;
      this.field2530 = 6;
      this.field2531 = 50;
      this.field2551 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2548 = new int[256];
      this.field2545 = new int[257];
      this.inUse = new boolean[256];
      this.field2553 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2555 = new byte[4096];
      this.field2556 = new int[16];
      this.field2557 = new byte[18002];
      this.field2558 = new byte[18002];
      this.field2559 = new byte[6][258];
      this.field2549 = new int[6][258];
      this.field2561 = new int[6][258];
      this.field2562 = new int[6][258];
      this.field2533 = new int[6];
   }

   @ObfuscatedName("i")
   static final void method3499(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "92"
   )
   static final void method3500(int var0, int var1) {
      if(Name.loadWidget(var0)) {
         class251.method4522(class189.widgets[var0], var1);
      }
   }
}
