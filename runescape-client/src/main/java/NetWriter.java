import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("rssocket")
   class159 rssocket;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 999396265
   )
   int field1447;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   ISAACCipher field1449;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 76115971
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("g")
   boolean field1446;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 161796479
   )
   int field1453;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1800346697
   )
   int field1455;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   ServerPacket field1456;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   ServerPacket field1457;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   ServerPacket field1458;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1447 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1446 = true;
      this.field1453 = 0;
      this.field1455 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-50"
   )
   final void method1866() {
      this.packetBufferNodes.method3703();
      this.field1447 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2055952884"
   )
   final void method1861() throws IOException {
      if(this.rssocket != null && this.field1447 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2434 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3082(this.buffer.payload, 0, this.buffer.offset);
               this.field1455 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2434);
            this.field1447 -= var1.field2434;
            var1.unlink();
            var1.packetBuffer.method3339();
            var1.method3173();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1473607656"
   )
   final void method1862(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2434 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1447 += var1.field2434;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfx;I)V",
      garbageValue = "-1706923990"
   )
   @Export("setSocket")
   void setSocket(class159 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2108953885"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3081();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1646680552"
   )
   void method1873() {
      this.rssocket = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lfx;",
      garbageValue = "1992473480"
   )
   @Export("getSocket")
   class159 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lef;IIIII)V",
      garbageValue = "-6183940"
   )
   public static final void method1879(Model var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, var4));
   }
}
