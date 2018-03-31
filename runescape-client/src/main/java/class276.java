import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class276 {
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Lib;IIB)V",
      garbageValue = "8"
   )
   static final void method4884(Widget var0, int var1, int var2) {
      if(Client.field1087 == 0 || Client.field1087 == 3) {
         if(MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class236 var3 = var0.method4475(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4374(var4, var5)) {
               var4 -= var3.field2765 / 2;
               var5 -= var3.field2763 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var8 * var4 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + WorldComparator.localPlayer.x >> 7;
               int var12 = WorldComparator.localPlayer.y - var10 >> 7;
               PacketNode var13 = FaceNormal.method3078(ClientPacket.field2385, Client.field902.field1475);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.putShort(var12 + BaseVarType.baseY);
               var13.packetBuffer.method3648(var11 + PacketNode.baseX);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(WorldComparator.localPlayer.x);
               var13.packetBuffer.putShort(WorldComparator.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field902.method2036(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}
