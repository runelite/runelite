import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public final class class60 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lbx;I)V",
      garbageValue = "1333594732"
   )
   static void method1069(GameEngine var0) {
      if(MouseInput.field754 == 1 || !Client.field951 && MouseInput.field754 == 4) {
         int var1 = class91.field1435 + 280;
         if(MouseInput.field753 >= var1 && MouseInput.field753 <= var1 + 14 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(0, 0);
            return;
         }

         if(MouseInput.field753 >= var1 + 15 && MouseInput.field753 <= var1 + 80 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(0, 1);
            return;
         }

         int var2 = class91.field1435 + 390;
         if(MouseInput.field753 >= var2 && MouseInput.field753 <= var2 + 14 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(1, 0);
            return;
         }

         if(MouseInput.field753 >= var2 + 15 && MouseInput.field753 <= var2 + 80 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(1, 1);
            return;
         }

         int var3 = class91.field1435 + 500;
         if(MouseInput.field753 >= var3 && MouseInput.field753 <= var3 + 14 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(2, 0);
            return;
         }

         if(MouseInput.field753 >= var3 + 15 && MouseInput.field753 <= var3 + 80 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(2, 1);
            return;
         }

         int var4 = class91.field1435 + 610;
         if(MouseInput.field753 >= var4 && MouseInput.field753 <= var4 + 14 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(3, 0);
            return;
         }

         if(MouseInput.field753 >= var4 + 15 && MouseInput.field753 <= var4 + 80 && MouseInput.field739 >= 4 && MouseInput.field739 <= 18) {
            ScriptVarType.method15(3, 1);
            return;
         }

         if(MouseInput.field753 >= class91.field1435 + 708 && MouseInput.field739 >= 4 && MouseInput.field753 <= class91.field1435 + 708 + 50 && MouseInput.field739 <= 20) {
            class91.worldSelectShown = false;
            class19.field336.method5017(class91.field1435, 0);
            class88.field1405.method5017(class91.field1435 + 382, 0);
            class43.logoSprite.method4983(class91.field1435 + 382 - class43.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1465 != -1) {
            World var5 = World.worldList[class91.field1465];
            DynamicObject.method1864(var5);
            class91.worldSelectShown = false;
            class19.field336.method5017(class91.field1435, 0);
            class88.field1405.method5017(class91.field1435 + 382, 0);
            class43.logoSprite.method4983(class91.field1435 + 382 - class43.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }
}
