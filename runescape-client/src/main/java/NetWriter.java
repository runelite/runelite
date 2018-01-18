import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("rssocket")
   class159 rssocket;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -658807953
   )
   int field1460;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   ISAACCipher field1462;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1251875601
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("e")
   boolean field1458;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2109672695
   )
   int field1465;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -121212661
   )
   int field1468;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   ServerPacket field1459;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   ServerPacket field1470;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   ServerPacket field1467;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1460 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1458 = true;
      this.field1465 = 0;
      this.field1468 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1380246194"
   )
   final void method1911() {
      this.packetBufferNodes.method3786();
      this.field1460 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   final void method1900() throws IOException {
      if(this.rssocket != null && this.field1460 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2451 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3166(this.buffer.payload, 0, this.buffer.offset);
               this.field1468 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2451);
            this.field1460 -= var1.field2451;
            var1.unlink();
            var1.packetBuffer.method3318();
            var1.method3252();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfy;I)V",
      garbageValue = "1547396989"
   )
   final void method1898(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2451 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1460 += var1.field2451;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfl;I)V",
      garbageValue = "-1583868965"
   )
   @Export("setSocket")
   void setSocket(class159 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3136();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "260634910"
   )
   void method1903() {
      this.rssocket = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lfl;",
      garbageValue = "0"
   )
   @Export("getSocket")
   class159 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ldk;I)V",
      garbageValue = "2131536160"
   )
   static final void method1921(TaskDataNode var0) {
      var0.field1628 = false;
      if(var0.field1631 != null) {
         var0.field1631.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4096(); var1 != null; var1 = var0.vmethod4097()) {
         method1921(var1);
      }

   }
}
