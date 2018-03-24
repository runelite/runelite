import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   public static class265 field1467;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("rssocket")
   class169 rssocket;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -940639699
   )
   int field1466;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   public ISAACCipher field1456;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -128388001
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("p")
   boolean field1453;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 339242091
   )
   int field1464;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1776343601
   )
   int field1462;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1463;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1457;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1465;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1466 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1453 = true;
      this.field1464 = 0;
      this.field1462 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-919473424"
   )
   final void method2067() {
      this.packetBufferNodes.method4008();
      this.field1466 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1518589991"
   )
   final void method2077() throws IOException {
      if(this.rssocket != null && this.field1466 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2470 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3340(this.buffer.payload, 0, this.buffer.offset);
               this.field1462 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2470);
            this.field1466 -= var1.field2470;
            var1.unlink();
            var1.packetBuffer.method3520();
            var1.method3437();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "1565767417"
   )
   public final void method2073(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2470 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1466 += var1.field2470;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfy;B)V",
      garbageValue = "95"
   )
   @Export("setSocket")
   void setSocket(class169 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "628252784"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3339();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   void method2082() {
      this.rssocket = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lfy;",
      garbageValue = "-1809034759"
   )
   @Export("getSocket")
   class169 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ldo;I)V",
      garbageValue = "-1882317415"
   )
   static final void method2084(TaskDataNode var0) {
      var0.field1628 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4354(); var1 != null; var1 = var0.vmethod4356()) {
         method2084(var1);
      }

   }
}
