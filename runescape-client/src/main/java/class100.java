import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class100 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("rssocket")
   RSSocket rssocket;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   CombatInfoList field1466;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 705485821
   )
   int field1467;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   Buffer field1469;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public ISAACCipher field1470;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   PacketBuffer field1465;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -191688097
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("p")
   boolean field1473;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1608425591
   )
   int field1474;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 92531169
   )
   int field1468;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   ServerPacket field1476;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   ServerPacket field1475;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   ServerPacket field1478;

   class100() {
      this.field1466 = new CombatInfoList();
      this.field1467 = 0;
      this.field1469 = new Buffer(5000);
      this.field1465 = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1473 = true;
      this.field1474 = 0;
      this.field1468 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1432752089"
   )
   final void method1926() {
      this.field1466.method3718();
      this.field1467 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1010549325"
   )
   final void method1927() throws IOException {
      if(this.rssocket != null && this.field1467 > 0) {
         this.field1469.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.field1466.method3723();
            if(var1 == null || var1.field2423 > this.field1469.payload.length - this.field1469.offset) {
               this.rssocket.queueForWrite(this.field1469.payload, 0, this.field1469.offset);
               this.field1468 = 0;
               break;
            }

            this.field1469.putBytes(var1.packetBuffer.payload, 0, var1.field2423);
            this.field1467 -= var1.field2423;
            var1.unlink();
            var1.packetBuffer.method3469();
            var1.method3212();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfq;I)V",
      garbageValue = "1080034384"
   )
   public final void method1925(PacketNode var1) {
      this.field1466.method3725(var1);
      var1.field2423 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1467 += var1.field2423;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfa;I)V",
      garbageValue = "-1848991673"
   )
   void method1929(RSSocket var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   void method1930() {
      if(this.rssocket != null) {
         this.rssocket.close();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "374925042"
   )
   void method1939() {
      this.rssocket = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lfa;",
      garbageValue = "1086230544"
   )
   RSSocket method1933() {
      return this.rssocket;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1984399288"
   )
   public static int method1943(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
