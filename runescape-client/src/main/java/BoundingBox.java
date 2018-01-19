import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 2076231689
   )
   static int field242;
   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field239;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "980177459"
   )
   @Export("draw")
   abstract void draw();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "40"
   )
   public static byte[] method46() {
      byte[] var0 = new byte[24];

      try {
         class157.randomDat.seek(0L);
         class157.randomDat.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lbd;B)V",
      garbageValue = "48"
   )
   static void method44(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
         int var1 = class91.field1336 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(0, 1);
            return;
         }

         int var2 = class91.field1336 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(1, 1);
            return;
         }

         int var3 = class91.field1336 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(2, 1);
            return;
         }

         int var4 = class91.field1336 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class2.method3(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class91.field1336 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class91.field1336 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class91.worldSelectShown = false;
            class91.field1339.method5287(class91.field1336, 0);
            GrandExchangeEvents.field269.method5287(class91.field1336 + 382, 0);
            class91.logoSprite.method5253(class91.field1336 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1349 != -1) {
            World var5 = World.worldList[class91.field1349];
            AttackOption.method1747(var5);
            class91.worldSelectShown = false;
            class91.field1339.method5287(class91.field1336, 0);
            GrandExchangeEvents.field269.method5287(class91.field1336 + 382, 0);
            class91.logoSprite.method5253(class91.field1336 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2123818721"
   )
   static void method45(int var0) {
      if(var0 != -1) {
         if(FontName.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2846 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.field2846;
                  BaseVarType.method7(var4, 2000000);
               }
            }

         }
      }
   }
}
