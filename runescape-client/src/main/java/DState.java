import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("DState")
public final class DState {
   @ObfuscatedName("g")
   final int field2553;
   @ObfuscatedName("e")
   final int field2540;
   @ObfuscatedName("b")
   final int field2524;
   @ObfuscatedName("z")
   final int field2522;
   @ObfuscatedName("n")
   final int field2526;
   @ObfuscatedName("l")
   final int field2527;
   @ObfuscatedName("s")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2142802975
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -827273827
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("h")
   @Export("out")
   byte[] out;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 504095031
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2007541313
   )
   int field2533;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1852636179
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("r")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1924774749
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1229911455
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 578282479
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -859563165
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2019244243
   )
   int field2525;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1286421035
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1339195997
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("w")
   int[] field2545;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 440469207
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("a")
   int[] field2555;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1411245285
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ax")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ai")
   boolean[] field2542;
   @ObfuscatedName("aj")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("ac")
   byte[] field2548;
   @ObfuscatedName("ag")
   int[] field2551;
   @ObfuscatedName("ay")
   byte[] field2552;
   @ObfuscatedName("as")
   byte[] field2549;
   @ObfuscatedName("av")
   byte[][] field2554;
   @ObfuscatedName("ao")
   int[][] field2537;
   @ObfuscatedName("ak")
   int[][] field2556;
   @ObfuscatedName("ad")
   int[][] field2557;
   @ObfuscatedName("az")
   int[] field2558;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1981144421
   )
   int field2559;

   DState() {
      this.field2553 = 4096;
      this.field2540 = 16;
      this.field2524 = 258;
      this.field2522 = 6;
      this.field2526 = 50;
      this.field2527 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2545 = new int[256];
      this.field2555 = new int[257];
      this.inUse = new boolean[256];
      this.field2542 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2548 = new byte[4096];
      this.field2551 = new int[16];
      this.field2552 = new byte[18002];
      this.field2549 = new byte[18002];
      this.field2554 = new byte[6][258];
      this.field2537 = new int[6][258];
      this.field2556 = new int[6][258];
      this.field2557 = new int[6][258];
      this.field2558 = new int[6];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-599614785"
   )
   static void method3579(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "10322"
   )
   static void method3580() {
      PacketNode var0 = AbstractSoundSystem.method2350(ClientPacket.field2422, Client.field911.field1460);
      PacketBuffer var1 = var0.packetBuffer;
      int var2 = Client.isResized?2:1;
      var1.putByte(var2);
      var0.packetBuffer.putShort(FaceNormal.canvasWidth);
      var0.packetBuffer.putShort(class19.canvasHeight);
      Client.field911.method2135(var0);
   }
}
