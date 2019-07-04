import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("PacketWriter")
public class PacketWriter {
   @ObfuscatedName("pg")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("clanChat")
   static ClanChat clanChat;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("socket0")
   AbstractSocket socket0;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("packetBufferNodes")
   IterableNodeDeque packetBufferNodes;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1028046199
   )
   int field672;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("isaacCipher")
   public IsaacCipher isaacCipher;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("serverPacket0")
   ServerPacket serverPacket0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1986766063
   )
   @Export("serverPacket0Length")
   int serverPacket0Length;
   @ObfuscatedName("e")
   boolean field673;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 120570975
   )
   int field674;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1672229609
   )
   int field675;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   ServerPacket field676;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   ServerPacket field677;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   ServerPacket field678;

   PacketWriter() {
      this.packetBufferNodes = new IterableNodeDeque();
      this.field672 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket0 = null;
      this.serverPacket0Length = 0;
      this.field673 = true;
      this.field674 = 0;
      this.field675 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1561094077"
   )
   final void method239() {
      this.packetBufferNodes.clear();
      this.field672 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1839929685"
   )
   final void method240() throws IOException {
      if (this.socket0 != null && this.field672 > 0) {
         this.buffer.index = 0;

         while (true) {
            PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
            if (var1 == null || var1.field671 > this.buffer.array.length - this.buffer.index) {
               this.socket0.write(this.buffer.array, 0, this.buffer.index);
               this.field675 = 0;
               break;
            }

            this.buffer.method38(var1.packetBuffer.array, 0, var1.field671);
            this.field672 -= var1.field671;
            var1.remove();
            var1.packetBuffer.method36();
            var1.method238();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "599379248"
   )
   public final void method241(PacketBufferNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field671 = var1.packetBuffer.index;
      var1.packetBuffer.index = 0;
      this.field672 += var1.field671;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfu;B)V",
      garbageValue = "111"
   )
   @Export("setSocket")
   void setSocket(AbstractSocket var1) {
      this.socket0 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2060019267"
   )
   @Export("close")
   void close() {
      if (this.socket0 != null) {
         this.socket0.close();
         this.socket0 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "120"
   )
   @Export("removeSocket")
   void removeSocket() {
      this.socket0 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lfu;",
      garbageValue = "1161554709"
   )
   @Export("getSocket")
   AbstractSocket getSocket() {
      return this.socket0;
   }
}
