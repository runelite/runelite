import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("DState")
public final class DState {
   @ObfuscatedName("d")
   final int field2558;
   @ObfuscatedName("z")
   final int field2527;
   @ObfuscatedName("n")
   final int field2528;
   @ObfuscatedName("r")
   final int field2529;
   @ObfuscatedName("e")
   final int field2533;
   @ObfuscatedName("y")
   final int field2530;
   @ObfuscatedName("k")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -668723761
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2023692545
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("x")
   @Export("out")
   byte[] out;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -796018989
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1688448367
   )
   int field2537;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 658481701
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("i")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1709559315
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1932464217
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1493777863
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -732337501
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2139218891
   )
   int field2544;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -422681091
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 961925045
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("l")
   int[] field2526;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1550828055
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("w")
   int[] field2549;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -223418007
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ak")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ap")
   boolean[] field2538;
   @ObfuscatedName("ac")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("aw")
   byte[] field2557;
   @ObfuscatedName("as")
   int[] field2555;
   @ObfuscatedName("au")
   byte[] field2556;
   @ObfuscatedName("al")
   byte[] field2560;
   @ObfuscatedName("af")
   byte[][] field2563;
   @ObfuscatedName("ai")
   int[][] field2559;
   @ObfuscatedName("az")
   int[][] field2536;
   @ObfuscatedName("aq")
   int[][] field2561;
   @ObfuscatedName("ae")
   int[] field2562;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -461468867
   )
   int field2547;

   DState() {
      this.field2558 = 4096;
      this.field2527 = 16;
      this.field2528 = 258;
      this.field2529 = 6;
      this.field2533 = 50;
      this.field2530 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2526 = new int[256];
      this.field2549 = new int[257];
      this.inUse = new boolean[256];
      this.field2538 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2557 = new byte[4096];
      this.field2555 = new int[16];
      this.field2556 = new byte[18002];
      this.field2560 = new byte[18002];
      this.field2563 = new byte[6][258];
      this.field2559 = new int[6][258];
      this.field2536 = new int[6][258];
      this.field2561 = new int[6][258];
      this.field2562 = new int[6];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1142778457"
   )
   static boolean method3562(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   static final void method3561() {
      int[] var0 = class93.playerIndices;

      int var1;
      for(var1 = 0; var1 < class93.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
