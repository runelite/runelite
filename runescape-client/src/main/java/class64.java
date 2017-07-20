import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class64 {
   @ObfuscatedName("n")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lcw;"
   )
   @Export("worldList")
   static World[] worldList;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public static void method1033() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "9"
   )
   static int method1035(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
      } else {
         var3 = var2?class48.field614:FaceNormal.field2099;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--BufferProvider.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3921(var4, class83.scriptStringStack[--class83.scriptStringStackSize]);
            return 1;
         } else {
            --class83.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         BufferProvider.intStackSize -= 2;
         var4 = class83.intStack[BufferProvider.intStackSize];
         int var5 = class83.intStack[BufferProvider.intStackSize + 1];
         var3.dragParent = CollisionData.method2946(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2712 = class83.intStack[--BufferProvider.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2693 = class83.intStack[--BufferProvider.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2701 = class83.intStack[--BufferProvider.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--class83.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class83.scriptStringStack[--class83.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1158056244"
   )
   static void method1034(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(189);
      Client.secretPacketBuffer1.putLEInt(var1);
      Client.secretPacketBuffer1.putLEShortA(var0);
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lho;III)V",
      garbageValue = "2080574126"
   )
   static final void method1036(Widget var0, int var1, int var2) {
      if(Client.field1077 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var4 = class14.method83(var0);
            if(var4 == null) {
               var4 = var0.dragParent;
            }

            if(var4 != null) {
               Client.field1077 = var0;
               var4 = class14.method83(var0);
               if(var4 == null) {
                  var4 = var0.dragParent;
               }

               Client.field1147 = var4;
               Client.field1079 = var1;
               Client.field1160 = var2;
               class261.field3610 = 0;
               Client.field1088 = false;
               int var5 = class37.method492();
               if(var5 != -1) {
                  class54.field669 = new class89();
                  class54.field669.field1379 = Client.menuActionParams0[var5];
                  class54.field669.field1377 = Client.menuActionParams1[var5];
                  class54.field669.field1378 = Client.menuTypes[var5];
                  class54.field669.field1380 = Client.menuIdentifiers[var5];
                  class54.field669.field1381 = Client.menuOptions[var5];
               }

               return;
            }
         }

      }
   }
}
