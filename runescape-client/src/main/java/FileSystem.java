import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1959598111
   )
   @Export("type")
   int type;
   @ObfuscatedName("w")
   public byte[] field3299;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfo;Lgj;I)Lfg;",
      garbageValue = "-987657395"
   )
   @Export("bufferForSize")
   public static PacketNode bufferForSize(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2 = SocketSession2.cachedOrNewPacketNode();
      var2.clientPacket = var0;
      var2.field2432 = var0.packetLength;
      if(var2.field2432 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2432 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2432 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2432 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2434 = 0;
      return var2;
   }
}
