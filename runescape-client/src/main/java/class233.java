import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class233 {
   @ObfuscatedName("g")
   static byte[][][] field3204;
   @ObfuscatedName("cd")
   public static char field3200;

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1920406937"
   )
   static void method4090(int var0, int var1) {
      PacketNode var2 = class18.method133(ClientPacket.field2320, Client.field905.field1460);
      var2.packetBuffer.method3219(var1);
      var2.packetBuffer.method3353(var0);
      Client.field905.method1855(var2);
   }
}
