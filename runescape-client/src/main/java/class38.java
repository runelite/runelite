import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class38 {
   @ObfuscatedName("cm")
   @Export("currentTypedKey")
   public static char currentTypedKey;

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   static void method549() {
      Client.field957.method2038();
      Client.field957.packetBuffer.offset = 0;
      Client.field957.serverPacket = null;
      Client.field957.field1495 = null;
      Client.field957.field1492 = null;
      Client.field957.field1493 = null;
      Client.field957.packetLength = 0;
      Client.field957.field1480 = 0;
      Client.field888 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1099 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      SoundTaskDataProvider.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1156 = false;
         }
      }

      class37.method544();
      class64.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1072[var0] = true;
      }

      class61.method1070();
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-58"
   )
   static final void method546(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         SoundTask.worldToScreen((Client.hintArrowX - class138.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - class23.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowOffsetZ * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            BoundingBox3DDrawMode.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(IIIILld;Lik;B)V",
      garbageValue = "-35"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5874(var10 + var5.field2773 / 2 - var4.maxWidth / 2, var5.field2772 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2773, var5.field2772, var5.field2774, var5.field2771);
            } else {
               var4.drawAt(var0 + var10 + var5.field2773 / 2 - var4.maxWidth / 2, var5.field2772 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
