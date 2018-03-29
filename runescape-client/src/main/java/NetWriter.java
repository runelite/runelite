import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1718761807
   )
   static int field1474;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("rssocket")
   class169 rssocket;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 176116279
   )
   int field1483;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public ISAACCipher field1475;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1557268839
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("w")
   boolean field1479;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1894274563
   )
   int field1480;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1970759289
   )
   int field1481;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   ServerPacket field1485;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   ServerPacket field1473;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   ServerPacket field1471;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1483 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1479 = true;
      this.field1480 = 0;
      this.field1481 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-76825632"
   )
   final void method2033() {
      this.packetBufferNodes.method3983();
      this.field1483 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1874710740"
   )
   final void method2035() throws IOException {
      if(this.rssocket != null && this.field1483 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2494 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3320(this.buffer.payload, 0, this.buffer.offset);
               this.field1481 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2494);
            this.field1483 -= var1.field2494;
            var1.unlink();
            var1.packetBuffer.method3502();
            var1.method3431();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "51"
   )
   public final void method2036(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2494 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1483 += var1.field2494;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1336215634"
   )
   @Export("setSocket")
   void setSocket(class169 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3325();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14125"
   )
   void method2038() {
      this.rssocket = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lfr;",
      garbageValue = "-1704768889"
   )
   @Export("getSocket")
   class169 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Lib;B)Lib;",
      garbageValue = "82"
   )
   static Widget method2045(Widget var0) {
      int var1 = VarCString.method4791(class45.getWidgetClickMask(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class3.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
