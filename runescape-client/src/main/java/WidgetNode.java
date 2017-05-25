import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -615439039
   )
   static int field809;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 437079303
   )
   int field810;
   @ObfuscatedName("u")
   boolean field811;
   @ObfuscatedName("pn")
   static class109 field812;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 402580777
   )
   @Export("id")
   int id;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2072396857"
   )
   static String method1104(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1660164708"
   )
   static int method1105(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class83.intStackSize];
         var3 = class261.method4792(var4);
      } else {
         var3 = var2?class83.field1311:Buffer.field2384;
      }

      if(var0 == 1100) {
         class83.intStackSize -= 2;
         var3.scrollX = class83.intStack[class83.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class83.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class219.method4130(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2671 = class83.intStack[--class83.intStackSize] == 1;
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2669 = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2679 = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2723 = class83.intStack[--class83.intStackSize] == 1;
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class83.intStackSize];
         class219.method4130(var3);
         return 1;
      } else if(var0 == 1109) {
         class83.intStackSize -= 6;
         var3.field2752 = class83.intStack[class83.intStackSize];
         var3.field2692 = class83.intStack[class83.intStackSize + 1];
         var3.rotationX = class83.intStack[class83.intStackSize + 2];
         var3.rotationZ = class83.intStack[class83.intStackSize + 3];
         var3.rotationY = class83.intStack[class83.intStackSize + 4];
         var3.field2696 = class83.intStack[class83.intStackSize + 5];
         class219.method4130(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class83.intStack[--class83.intStackSize];
            if(var8 != var3.field2689) {
               var3.field2689 = var8;
               var3.field2773 = 0;
               var3.field2765 = 0;
               class219.method4130(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2699 = class83.intStack[--class83.intStackSize] == 1;
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class219.method4130(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1114) {
            class83.intStackSize -= 3;
            var3.field2705 = class83.intStack[class83.intStackSize];
            var3.field2772 = class83.intStack[class83.intStackSize + 1];
            var3.field2704 = class83.intStack[class83.intStackSize + 2];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2707 = class83.intStack[--class83.intStackSize] == 1;
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class83.intStackSize] == 1;
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class83.intStackSize] == 1;
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1120) {
            class83.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class83.intStackSize];
            var3.scrollHeight = class83.intStack[class83.intStackSize + 1];
            class219.method4130(var3);
            if(var4 != -1 && var3.type == 0) {
               class24.method176(class90.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            Script.method1887(var3.id, var3.index);
            Client.field1054 = var3;
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2678 = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2668 = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2734 = class83.intStack[--class83.intStackSize];
            class219.method4130(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class83.intStack[--class83.intStackSize];
            class283 var6 = (class283)Client.method1381(class140.method2901(), var8);
            if(var6 != null) {
               var3.field2672 = var6;
               class219.method4130(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class83.intStackSize] == 1;
            var3.field2676 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   WidgetNode() {
      this.field811 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lclass230;",
      garbageValue = "991050482"
   )
   public static class230[] method1106() {
      return new class230[]{class230.field3164, class230.field3170, class230.field3162, class230.field3159, class230.field3160, class230.field3163};
   }
}
