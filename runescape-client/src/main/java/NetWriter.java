import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("rssocket")
   class169 rssocket;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -299433575
   )
   int field1482;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public ISAACCipher field1484;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2022442929
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("u")
   boolean field1489;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 178866805
   )
   int field1480;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1278205149
   )
   int field1485;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   ServerPacket field1495;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   ServerPacket field1492;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   ServerPacket field1493;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1482 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1489 = true;
      this.field1480 = 0;
      this.field1485 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-767771702"
   )
   final void method2038() {
      this.packetBufferNodes.method3970();
      this.field1482 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1117605583"
   )
   final void method2039() throws IOException {
      if(this.rssocket != null && this.field1482 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2505 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3337(this.buffer.payload, 0, this.buffer.offset);
               this.field1485 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2505);
            this.field1482 -= var1.field2505;
            var1.unlink();
            var1.packetBuffer.method3500();
            var1.method3436();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "353993827"
   )
   public final void method2052(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2505 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1482 += var1.field2505;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfd;B)V",
      garbageValue = "123"
   )
   @Export("setSocket")
   void setSocket(class169 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3331();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   void method2043() {
      this.rssocket = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lfd;",
      garbageValue = "12"
   )
   @Export("getSocket")
   class169 getSocket() {
      return this.rssocket;
   }
}
