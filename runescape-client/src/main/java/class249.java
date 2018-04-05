import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class249 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1671722142"
   )
   static final void method4501(String var0) {
      PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2471, Client.field957.field1484);
      var1.packetBuffer.putByte(WorldMapRegion.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field957.method2052(var1);
   }
}
