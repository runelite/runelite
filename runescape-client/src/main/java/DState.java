import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("DState")
public final class DState {
   @ObfuscatedName("d")
   final int field2460;
   @ObfuscatedName("x")
   final int field2454;
   @ObfuscatedName("k")
   final int field2455;
   @ObfuscatedName("z")
   final int field2470;
   @ObfuscatedName("v")
   final int field2487;
   @ObfuscatedName("m")
   final int field2458;
   @ObfuscatedName("b")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -174389993
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 927384581
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("r")
   @Export("out")
   byte[] out;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1825308891
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -787930499
   )
   int field2490;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 118001133
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("c")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -204841739
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1352825385
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 73596873
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 908177209
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1880036979
   )
   int field2471;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 826511023
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1770276803
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("i")
   int[] field2474;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1774067719
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("w")
   int[] field2476;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 870973201
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ah")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ak")
   boolean[] field2479;
   @ObfuscatedName("aa")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ax")
   byte[] field2481;
   @ObfuscatedName("aq")
   int[] field2482;
   @ObfuscatedName("au")
   byte[] field2483;
   @ObfuscatedName("al")
   byte[] field2456;
   @ObfuscatedName("ae")
   byte[][] field2485;
   @ObfuscatedName("aj")
   int[][] field2484;
   @ObfuscatedName("as")
   int[][] field2457;
   @ObfuscatedName("am")
   int[][] field2488;
   @ObfuscatedName("ag")
   int[] field2489;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -92255169
   )
   int field2486;

   DState() {
      this.field2460 = 4096;
      this.field2454 = 16;
      this.field2455 = 258;
      this.field2470 = 6;
      this.field2487 = 50;
      this.field2458 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2474 = new int[256];
      this.field2476 = new int[257];
      this.inUse = new boolean[256];
      this.field2479 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2481 = new byte[4096];
      this.field2482 = new int[16];
      this.field2483 = new byte[18002];
      this.field2456 = new byte[18002];
      this.field2485 = new byte[6][258];
      this.field2484 = new int[6][258];
      this.field2457 = new int[6][258];
      this.field2488 = new int[6][258];
      this.field2489 = new int[6];
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-607893362"
   )
   static final void method3276(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1035; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1099[var4] = true;
         }
      }

   }
}
