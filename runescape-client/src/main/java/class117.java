import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class117 {
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1879859415
   )
   static int field2018;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "2"
   )
   static boolean method2480(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "-20"
   )
   static void method2481(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class173.method3412(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class62.field1267;
         var3 = class77.field1428;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class21.method541(var0, var2, var3, false);
      WallObject.method2135(var0, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1752335159"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class125.method2806();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field335 = 0;
            Client.field366 = 0;
            Client.field487 = 0;
         }

         if(var0 != 20 && var0 != 40 && class59.field1250 != null) {
            class59.field1250.method3029();
            class59.field1250 = null;
         }

         if(Client.gameState == 25) {
            Client.field361 = 0;
            Client.field357 = 0;
            Client.field358 = 1;
            Client.field359 = 0;
            Client.field301 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class0.method3(class164.canvas, class139.field2139, ItemComposition.field1199, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class0.method3(class164.canvas, class139.field2139, ItemComposition.field1199, false, 4);
            } else {
               class20.method534();
            }
         } else {
            class0.method3(class164.canvas, class139.field2139, ItemComposition.field1199, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
