import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public final class class61 {
   @ObfuscatedName("rk")
   @ObfuscatedGetter(
      intValue = 1419176443
   )
   static int field737;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1879272439"
   )
   static void method1071() {
      for(class80 var0 = (class80)class80.field1263.getFront(); var0 != null; var0 = (class80)class80.field1263.getNext()) {
         if(var0.field1266 != null) {
            MouseInput.field727.method2060(var0.field1266);
            var0.field1266 = null;
         }

         if(var0.field1271 != null) {
            MouseInput.field727.method2060(var0.field1271);
            var0.field1271 = null;
         }
      }

      class80.field1263.clear();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-541446928"
   )
   static int method1072(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   static void method1070() {
      PacketNode var0 = WorldMapRectangle.method280(ClientPacket.field2404, Client.field957.field1484);
      PacketBuffer var1 = var0.packetBuffer;
      int var2 = Client.isResized?2:1;
      var1.putByte(var2);
      var0.packetBuffer.putShort(MapLabel.canvasWidth);
      var0.packetBuffer.putShort(FloorUnderlayDefinition.canvasHeight);
      Client.field957.method2052(var0);
   }
}
