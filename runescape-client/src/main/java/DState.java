import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("DState")
public final class DState {
   @ObfuscatedName("de")
   @Export("host")
   static String host;
   @ObfuscatedName("i")
   final int field2370;
   @ObfuscatedName("w")
   final int field2386;
   @ObfuscatedName("a")
   final int field2360;
   @ObfuscatedName("t")
   final int field2358;
   @ObfuscatedName("s")
   final int field2385;
   @ObfuscatedName("r")
   final int field2363;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -525579473
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 719412369
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("q")
   int[] field2379;
   @ObfuscatedName("h")
   int[] field2371;
   @ObfuscatedName("ah")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ab")
   boolean[] field2384;
   @ObfuscatedName("aw")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ai")
   byte[] field2393;
   @ObfuscatedName("v")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("an")
   int[] field2387;
   @ObfuscatedName("au")
   byte[] field2388;
   @ObfuscatedName("ar")
   byte[] field2389;
   @ObfuscatedName("k")
   @Export("out")
   byte[] out;
   @ObfuscatedName("ay")
   byte[][] field2390;
   @ObfuscatedName("ao")
   int[][] field2391;
   @ObfuscatedName("as")
   int[][] field2396;
   @ObfuscatedName("ak")
   int[][] field2366;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2136561499
   )
   int field2369;
   @ObfuscatedName("aq")
   int[] field2394;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1365448899
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 783109979
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2045168799
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1919343793
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1881597305
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1706566721
   )
   int field2376;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1071787417
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 118838505
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("l")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1473187829
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 946244127
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1984082073
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1733494453
   )
   int field2395;

   DState() {
      this.field2370 = 4096;
      this.field2386 = 16;
      this.field2360 = 258;
      this.field2358 = 6;
      this.field2385 = 50;
      this.field2363 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2379 = new int[256];
      this.field2371 = new int[257];
      this.inUse = new boolean[256];
      this.field2384 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2393 = new byte[4096];
      this.field2387 = new int[16];
      this.field2388 = new byte[18002];
      this.field2389 = new byte[18002];
      this.field2390 = new byte[6][258];
      this.field2391 = new int[6][258];
      this.field2396 = new int[6][258];
      this.field2366 = new int[6][258];
      this.field2394 = new int[6];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "258382951"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2417) {
         class175.field2418 += class175.field2417 - var0;
      }

      class175.field2417 = var0;
      return var0 + class175.field2418;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-2094233261"
   )
   @Export("getSprite")
   public static ModIcon getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      ModIcon var5;
      if(!class223.method4073(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class268.set();
      }

      return var5;
   }
}
