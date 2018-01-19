import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class235 {
   @ObfuscatedName("fr")
   @Export("landMapFileIds")
   static int[] landMapFileIds;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfj;Lgz;B)Lfy;",
      garbageValue = "-28"
   )
   public static PacketNode method4272(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2453 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2453];
      }

      var2.clientPacket = var0;
      var2.field2448 = var0.packetLength;
      if(var2.field2448 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2448 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2448 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2448 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2451 = 0;
      return var2;
   }
}
