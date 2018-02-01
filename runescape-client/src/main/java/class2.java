import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class2 implements class0 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILhn;ZI)V",
      garbageValue = "-1415896494"
   )
   static void method4(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = GrandExchangeEvent.method97().method5686(var0);
      int var4 = class36.localPlayer.field808;
      int var5 = (class36.localPlayer.x >> 7) + WorldMapType1.baseX;
      int var6 = (class36.localPlayer.y >> 7) + class85.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      GrandExchangeEvent.method97().method5660(var3, var7, var1, var2);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "975410950"
   )
   static final void method5(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         MilliTimer.worldToScreen((Client.hintArrowX - WorldMapType1.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - class85.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            GrandExchangeEvent.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }
}
