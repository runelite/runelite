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
   @Export("__q")
   int __q;
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
   @Export("__e")
   boolean __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 120570975
   )
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1672229609
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("__k")
   ServerPacket __k;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("surfaceOffsetY")
   ServerPacket __n;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("__i")
   ServerPacket __i;

   PacketWriter() {
      this.packetBufferNodes = new IterableNodeDeque();
      this.__q = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket0 = null;
      this.serverPacket0Length = 0;
      this.__e = true;
      this.__x = 0;
      this.__d = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1561094077"
   )
   @Export("__m_165")
   final void __m_165() {
      this.packetBufferNodes.clear();
      this.__q = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1839929685"
   )
   @Export("__f_166")
   final void __f_166() throws IOException {
      if(this.socket0 != null && this.__q > 0) {
         this.buffer.index = 0;

         while(true) {
            PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
            if(var1 == null || var1.__w > this.buffer.array.length - this.buffer.index) {
               this.socket0.write(this.buffer.array, 0, this.buffer.index);
               this.__d = 0;
               break;
            }

            this.buffer.__s_297(var1.packetBuffer.array, 0, var1.__w);
            this.__q -= var1.__w;
            var1.remove();
            var1.packetBuffer.__f_295();
            var1.__f_292();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "599379248"
   )
   @Export("__q_167")
   public final void __q_167(PacketBufferNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.__w = var1.packetBuffer.index;
      var1.packetBuffer.index = 0;
      this.__q += var1.__w;
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
      if(this.socket0 != null) {
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
