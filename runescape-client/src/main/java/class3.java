import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class3 implements class0 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -743882019
   )
   static int field20;
   @ObfuscatedName("x")
   static int[] field18;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "928372437"
   )
   static final void method7(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         Widget.worldToScreen((Client.hintArrowX - ClientPacket.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - MapIconReference.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowOffsetZ * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            DecorativeObject.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "29140"
   )
   static void method6() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
