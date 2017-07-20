import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("DState")
public final class DState {
   @ObfuscatedName("b")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("c")
   final int field2347;
   @ObfuscatedName("o")
   final int field2322;
   @ObfuscatedName("i")
   final int field2328;
   @ObfuscatedName("u")
   final int field2323;
   @ObfuscatedName("g")
   final int field2346;
   @ObfuscatedName("m")
   final int field2319;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 637691221
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1067606789
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("j")
   int[] field2335;
   @ObfuscatedName("z")
   int[] field2337;
   @ObfuscatedName("ap")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("aj")
   boolean[] field2341;
   @ObfuscatedName("am")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ag")
   byte[] field2343;
   @ObfuscatedName("s")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("av")
   int[] field2344;
   @ObfuscatedName("al")
   byte[] field2345;
   @ObfuscatedName("ab")
   byte[] field2325;
   @ObfuscatedName("k")
   @Export("out")
   byte[] out;
   @ObfuscatedName("af")
   byte[][] field2332;
   @ObfuscatedName("ak")
   int[][] field2348;
   @ObfuscatedName("ar")
   int[][] field2349;
   @ObfuscatedName("an")
   int[][] field2350;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1374537197
   )
   int field2316;
   @ObfuscatedName("at")
   int[] field2315;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 496519713
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 587161887
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1622124361
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1707586967
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1294508553
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1018573911
   )
   int field2351;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -575810811
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1673654491
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("h")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1888135771
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -425186177
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -926641465
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 255255685
   )
   int field2352;

   DState() {
      this.field2347 = 4096;
      this.field2322 = 16;
      this.field2328 = 258;
      this.field2323 = 6;
      this.field2346 = 50;
      this.field2319 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2335 = new int[256];
      this.field2337 = new int[257];
      this.inUse = new boolean[256];
      this.field2341 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2343 = new byte[4096];
      this.field2344 = new int[16];
      this.field2345 = new byte[18002];
      this.field2325 = new byte[18002];
      this.field2332 = new byte[6][258];
      this.field2348 = new int[6][258];
      this.field2349 = new int[6][258];
      this.field2350 = new int[6][258];
      this.field2315 = new int[6];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lid;",
      garbageValue = "3"
   )
   public static class254 method3078(int var0) {
      class254 var1 = (class254)class254.field3401.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3389.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4369(new Buffer(var2));
         }

         class254.field3401.put(var1, (long)var0);
         return var1;
      }
   }
}
