import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class238 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lbt;I)V",
      garbageValue = "1903117477"
   )
   static void method4478(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
         int var1 = class89.field1356 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(0, 1);
            return;
         }

         int var2 = class89.field1356 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(1, 1);
            return;
         }

         int var3 = class89.field1356 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(2, 1);
            return;
         }

         int var4 = class89.field1356 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            ItemContainer.method1048(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class89.field1356 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class89.field1356 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class89.worldSelectShown = false;
            UnitPriceComparator.field307.method5682(class89.field1356, 0);
            class37.field483.method5682(class89.field1356 + 382, 0);
            class137.logoSprite.method5653(class89.field1356 + 382 - class137.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class89.field1353 != -1) {
            World var5 = class31.worldList[class89.field1353];
            class56.method773(var5);
            class89.worldSelectShown = false;
            UnitPriceComparator.field307.method5682(class89.field1356, 0);
            class37.field483.method5682(class89.field1356 + 382, 0);
            class137.logoSprite.method5653(class89.field1356 + 382 - class137.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }
}
