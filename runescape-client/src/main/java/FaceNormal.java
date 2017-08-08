import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 951623031
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 778968743
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -279876829
   )
   @Export("z")
   int z;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "115"
   )
   static void method2910() {
      if(class93.field1451) {
         class93.field1420 = null;
         class93.field1421 = null;
         class46.field589 = null;
         class93.field1419 = null;
         class83.field1322 = null;
         Ignore.logoSprite = null;
         class93.titlemuteSprite = null;
         class203.field2476 = null;
         class83.field1324 = null;
         class54.field655 = null;
         class93.field1422 = null;
         CombatInfo1.field1271 = null;
         class97.field1504 = null;
         class19.field319 = null;
         class13.field276 = null;
         class93.field1441 = null;
         class46.field590 = null;
         class88.field1365 = null;
         class18.field316 = null;
         class97.field1503 = null;
         ScriptEvent.field847 = null;
         class88.field1368 = null;
         class204.field2487 = 1;
         class204.field2488 = null;
         class12.field273 = -1;
         class204.field2489 = -1;
         class204.field2490 = 0;
         class33.field472 = false;
         class204.field2491 = 2;
         class269.sendConInfo(true);
         class93.field1451 = false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "1984274291"
   )
   static int method2909(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class84.intStack[--class84.intStackSize];
         var3 = class266.method4862(var4);
      } else {
         var3 = var2?class269.field3661:DecorativeObject.field2164;
      }

      if(var0 == 1100) {
         class84.intStackSize -= 2;
         var3.scrollX = class84.intStack[class84.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class84.intStack[class84.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class255.method4531(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2655 = class84.intStack[--class84.intStackSize] == 1;
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2687 = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2661 = class84.intStack[--class84.intStackSize] == 1;
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class84.intStack[--class84.intStackSize];
         class255.method4531(var3);
         return 1;
      } else if(var0 == 1109) {
         class84.intStackSize -= 6;
         var3.field2663 = class84.intStack[class84.intStackSize];
         var3.field2621 = class84.intStack[class84.intStackSize + 1];
         var3.rotationX = class84.intStack[class84.intStackSize + 2];
         var3.rotationZ = class84.intStack[class84.intStackSize + 3];
         var3.rotationY = class84.intStack[class84.intStackSize + 4];
         var3.modelZoom = class84.intStack[class84.intStackSize + 5];
         class255.method4531(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class84.intStack[--class84.intStackSize];
            if(var8 != var3.field2633) {
               var3.field2633 = var8;
               var3.field2745 = 0;
               var3.field2746 = 0;
               class255.method4531(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2680 = class84.intStack[--class84.intStackSize] == 1;
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class84.scriptStringStack[--class84.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class255.method4531(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1114) {
            class84.intStackSize -= 3;
            var3.field2743 = class84.intStack[class84.intStackSize];
            var3.field2757 = class84.intStack[class84.intStackSize + 1];
            var3.field2751 = class84.intStack[class84.intStackSize + 2];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class84.intStack[--class84.intStackSize] == 1;
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class84.intStack[--class84.intStackSize] == 1;
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class84.intStack[--class84.intStackSize] == 1;
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1120) {
            class84.intStackSize -= 2;
            var3.scrollWidth = class84.intStack[class84.intStackSize];
            var3.scrollHeight = class84.intStack[class84.intStackSize + 1];
            class255.method4531(var3);
            if(var4 != -1 && var3.type == 0) {
               Player.method1171(Item.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class3.method2(var3.id, var3.index);
            Client.field1066 = var3;
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2659 = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2649 = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2644 = class84.intStack[--class84.intStackSize];
            class255.method4531(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class84.intStack[--class84.intStackSize];
            class284 var6 = (class284)GroundObject.forOrdinal(class204.method3687(), var8);
            if(var6 != null) {
               var3.field2653 = var6;
               class255.method4531(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class84.intStack[--class84.intStackSize] == 1;
            var3.field2657 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
