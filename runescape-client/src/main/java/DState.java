import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("DState")
public final class DState {
   @ObfuscatedName("s")
   final int field2483;
   @ObfuscatedName("g")
   final int field2486;
   @ObfuscatedName("m")
   final int field2474;
   @ObfuscatedName("h")
   final int field2475;
   @ObfuscatedName("i")
   final int field2476;
   @ObfuscatedName("w")
   final int field2477;
   @ObfuscatedName("t")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -255262553
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -194767117
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("k")
   @Export("out")
   byte[] out;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 17457195
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1876900977
   )
   int field2504;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1321842429
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("f")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -381806591
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1628751965
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -491868389
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1173022951
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1182954241
   )
   int field2481;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 406001005
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -669155227
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("n")
   int[] field2493;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -63548057
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("e")
   int[] field2496;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1860112195
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ad")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("al")
   boolean[] field2498;
   @ObfuscatedName("aq")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ar")
   byte[] field2500;
   @ObfuscatedName("an")
   int[] field2501;
   @ObfuscatedName("af")
   byte[] field2502;
   @ObfuscatedName("as")
   byte[] field2503;
   @ObfuscatedName("ax")
   byte[][] field2487;
   @ObfuscatedName("ak")
   int[][] field2495;
   @ObfuscatedName("aw")
   int[][] field2490;
   @ObfuscatedName("ai")
   int[][] field2507;
   @ObfuscatedName("ab")
   int[] field2508;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1358236057
   )
   int field2509;

   DState() {
      this.field2483 = 4096;
      this.field2486 = 16;
      this.field2474 = 258;
      this.field2475 = 6;
      this.field2476 = 50;
      this.field2477 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2493 = new int[256];
      this.field2496 = new int[257];
      this.inUse = new boolean[256];
      this.field2498 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2500 = new byte[4096];
      this.field2501 = new int[16];
      this.field2502 = new byte[18002];
      this.field2503 = new byte[18002];
      this.field2487 = new byte[6][258];
      this.field2495 = new int[6][258];
      this.field2490 = new int[6][258];
      this.field2507 = new int[6][258];
      this.field2508 = new int[6];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;B)V",
      garbageValue = "68"
   )
   public static void method3489(IndexDataBase var0) {
      class254.field3400 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILir;IIIZB)V",
      garbageValue = "-59"
   )
   public static void method3488(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class214.field2617 = 1;
      class214.field2614 = var1;
      class293.field3798 = var2;
      class23.field342 = var3;
      IndexFile.field2192 = var4;
      class33.field446 = var5;
      class214.field2616 = var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1996056122"
   )
   static void method3487() {
      Iterator var0 = class94.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1082();
      }

   }
}
