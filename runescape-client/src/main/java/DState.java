import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("DState")
public final class DState {
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = -7476914747447660661L
   )
   static long field2485;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("p")
   final int field2482;
   @ObfuscatedName("i")
   final int field2470;
   @ObfuscatedName("w")
   final int field2471;
   @ObfuscatedName("s")
   final int field2449;
   @ObfuscatedName("j")
   final int field2450;
   @ObfuscatedName("a")
   final int field2451;
   @ObfuscatedName("t")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1333622461
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -830217719
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("h")
   @Export("out")
   byte[] out;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1808911711
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1884783373
   )
   int field2448;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1510903687
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("v")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -883529135
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1345912405
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1886072555
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1594734737
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1577309723
   )
   int field2464;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -741316125
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1074945483
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("u")
   int[] field2467;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1302098113
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("z")
   int[] field2481;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1169446279
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("aa")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ap")
   boolean[] field2472;
   @ObfuscatedName("ao")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ar")
   byte[] field2474;
   @ObfuscatedName("ay")
   int[] field2475;
   @ObfuscatedName("ax")
   byte[] field2466;
   @ObfuscatedName("ae")
   byte[] field2477;
   @ObfuscatedName("ah")
   byte[][] field2469;
   @ObfuscatedName("ai")
   int[][] field2479;
   @ObfuscatedName("au")
   int[][] field2447;
   @ObfuscatedName("am")
   int[][] field2462;
   @ObfuscatedName("af")
   int[] field2460;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1218551629
   )
   int field2483;

   DState() {
      this.field2482 = 4096;
      this.field2470 = 16;
      this.field2471 = 258;
      this.field2449 = 6;
      this.field2450 = 50;
      this.field2451 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2467 = new int[256];
      this.field2481 = new int[257];
      this.inUse = new boolean[256];
      this.field2472 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2474 = new byte[4096];
      this.field2475 = new int[16];
      this.field2466 = new byte[18002];
      this.field2477 = new byte[18002];
      this.field2469 = new byte[6][258];
      this.field2479 = new int[6][258];
      this.field2447 = new int[6][258];
      this.field2462 = new int[6][258];
      this.field2460 = new int[6];
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lho;I)Ljava/lang/String;",
      garbageValue = "-1469167158"
   )
   static String method3386(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class5.method25(class215.method4072(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
