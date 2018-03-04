import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("rssocket")
   class169 rssocket;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -151967213
   )
   int field1467;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public ISAACCipher field1470;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1177131903
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("p")
   boolean field1474;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1569809817
   )
   int field1476;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -807941381
   )
   int field1477;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1478;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1479;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1480;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1467 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1474 = true;
      this.field1476 = 0;
      this.field1477 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1542560894"
   )
   final void method2079() {
      this.packetBufferNodes.method4083();
      this.field1467 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   final void method2080() throws IOException {
      if(this.rssocket != null && this.field1467 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2495 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3387(this.buffer.payload, 0, this.buffer.offset);
               this.field1477 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2495);
            this.field1467 -= var1.field2495;
            var1.unlink();
            var1.packetBuffer.method3741();
            var1.method3485();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "-1318313998"
   )
   public final void method2082(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2495 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1467 += var1.field2495;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfi;I)V",
      garbageValue = "-1501656265"
   )
   @Export("setSocket")
   void setSocket(class169 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-14975246"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3379();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   void method2083() {
      this.rssocket = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lfi;",
      garbageValue = "348970197"
   )
   @Export("getSocket")
   class169 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-787038517"
   )
   static int method2100(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIIILly;Lik;I)V",
      garbageValue = "-1947154127"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2777 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class169.mapedge.method5939(var15 + (var0 + var5.field2777 / 2 - var17 / 2), var5.field2775 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         PendingSpawn.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
