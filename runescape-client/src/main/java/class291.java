import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class291 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1294455385"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + Client.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-108"
   )
   static void method5314(int var0) {
      Client.field1061 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class29.method249() == 1) {
         class23.clientInstance.method891(765, 503);
      } else {
         class23.clientInstance.method891(7680, 2160);
      }

      if(Client.gameState >= 25) {
         PacketNode var1 = class31.method285(ClientPacket.field2415, Client.field899.field1470);
         var1.packetBuffer.putByte(class29.method249());
         var1.packetBuffer.putShort(GameEngine.canvasWidth);
         var1.packetBuffer.putShort(class195.canvasHeight);
         Client.field899.method2082(var1);
      }

   }
}
