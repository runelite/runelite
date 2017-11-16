import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class100 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("rssocket")
   RSSocket rssocket;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   CombatInfoList field1469;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -468479105
   )
   int field1458;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   Buffer field1462;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   ISAACCipher field1460;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   PacketBuffer field1461;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 636575469
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("k")
   boolean field1464;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1864298145
   )
   int field1457;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1578722639
   )
   int field1456;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   ServerPacket field1467;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   ServerPacket field1468;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   ServerPacket field1459;

   class100() {
      this.field1469 = new CombatInfoList();
      this.field1458 = 0;
      this.field1462 = new Buffer(5000);
      this.field1461 = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1464 = true;
      this.field1457 = 0;
      this.field1456 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-976982327"
   )
   final void method1868() {
      this.field1469.method3606();
      this.field1458 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-7253"
   )
   final void method1866() throws IOException {
      if(this.rssocket != null && this.field1458 > 0) {
         this.field1462.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.field1469.method3611();
            if(var1 == null || var1.field2423 > this.field1462.payload.length - this.field1462.offset) {
               this.rssocket.queueForWrite(this.field1462.payload, 0, this.field1462.offset);
               this.field1456 = 0;
               break;
            }

            this.field1462.putBytes(var1.packetBuffer.payload, 0, var1.field2423);
            this.field1458 -= var1.field2423;
            var1.unlink();
            var1.packetBuffer.method3169();
            var1.method3106();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfc;I)V",
      garbageValue = "-1517267255"
   )
   final void method1855(PacketNode var1) {
      this.field1469.method3618(var1);
      var1.field2423 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1458 += var1.field2423;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfx;B)V",
      garbageValue = "10"
   )
   void method1856(RSSocket var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1182611170"
   )
   void method1857() {
      if(this.rssocket != null) {
         this.rssocket.close();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   void method1858() {
      this.rssocket = null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lfx;",
      garbageValue = "884854072"
   )
   RSSocket method1873() {
      return this.rssocket;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "89"
   )
   public static int method1877(byte[] var0, int var1) {
      return GameObject.method2897(var0, 0, var1);
   }
}
