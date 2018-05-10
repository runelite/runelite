import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class74 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1383604606"
   )
   static final void method1845(String var0) {
      PacketNode var1 = DecorativeObject.method3115(ClientPacket.field2163, Client.field739.field1250);
      var1.packetBuffer.putByte(Size.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field739.method2019(var1);
   }
}
