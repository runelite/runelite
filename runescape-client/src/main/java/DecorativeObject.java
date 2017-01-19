import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("b")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1774449663
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1072334739
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 24898527
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1669725043
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -376041533
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 306065331
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("u")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1304777155
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 806407347
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("pf")
   static class230 field1604;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1352534591
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-8430249"
   )
   static final void method1862(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field412 != 0 || Client.field446) {
         String var2;
         if(Client.field412 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field322 + " " + "->";
         } else if(Client.field446 && Client.menuOptionCount < 2) {
            var2 = Client.field449 + " " + Client.field450 + " " + "->";
         } else {
            var2 = class3.method38(Client.menuOptionCount - 1);
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + Actor.method574(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class16.field187.method3753(var2, 4 + var0, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
