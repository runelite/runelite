import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("DState")
public final class DState {
   @ObfuscatedName("t")
   final int field2508;
   @ObfuscatedName("q")
   final int field2522;
   @ObfuscatedName("i")
   final int field2533;
   @ObfuscatedName("a")
   final int field2507;
   @ObfuscatedName("l")
   final int field2509;
   @ObfuscatedName("b")
   final int field2510;
   @ObfuscatedName("e")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 525616163
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 971531347
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("g")
   @Export("out")
   byte[] out;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1335106213
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1455918493
   )
   int field2516;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -298831381
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("v")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2079174113
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1479894515
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 854766513
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -541752279
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 718324555
   )
   int field2523;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1355174209
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1949573
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("f")
   int[] field2539;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1037737565
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("y")
   int[] field2528;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -885546241
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ay")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ao")
   boolean[] field2531;
   @ObfuscatedName("av")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("aj")
   byte[] field2521;
   @ObfuscatedName("ae")
   int[] field2534;
   @ObfuscatedName("am")
   byte[] field2535;
   @ObfuscatedName("az")
   byte[] field2536;
   @ObfuscatedName("ap")
   byte[][] field2537;
   @ObfuscatedName("ah")
   int[][] field2538;
   @ObfuscatedName("au")
   int[][] field2505;
   @ObfuscatedName("ax")
   int[][] field2519;
   @ObfuscatedName("ar")
   int[] field2541;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 495435411
   )
   int field2542;

   DState() {
      this.field2508 = 4096;
      this.field2522 = 16;
      this.field2533 = 258;
      this.field2507 = 6;
      this.field2509 = 50;
      this.field2510 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2539 = new int[256];
      this.field2528 = new int[257];
      this.inUse = new boolean[256];
      this.field2531 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2521 = new byte[4096];
      this.field2534 = new int[16];
      this.field2535 = new byte[18002];
      this.field2536 = new byte[18002];
      this.field2537 = new byte[6][258];
      this.field2538 = new int[6][258];
      this.field2505 = new int[6][258];
      this.field2519 = new int[6][258];
      this.field2541 = new int[6];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method3517() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "122"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3380 != 0 && var3 > IndexDataBase.field3380) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3380 != 0 && var6 > IndexDataBase.field3380) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
