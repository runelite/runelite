import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class31 {
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1810193937
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -1501848627
   )
   static int field449;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1898524025
   )
   final int field450;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 890007061
   )
   final int field446;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 865753871
   )
   final int field452;

   class31(int var1, int var2, int var3) {
      this.field450 = var1;
      this.field446 = var2;
      this.field452 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfn;Lgc;I)Lgl;",
      garbageValue = "1932826274"
   )
   public static PacketNode method285(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2497 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2497];
      }

      var2.clientPacket = var0;
      var2.field2493 = var0.packetLength;
      if(var2.field2493 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2493 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2493 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2493 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2495 = 0;
      return var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1921771837"
   )
   public static int method286(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
