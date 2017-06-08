import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class66 {
   @ObfuscatedName("n")
   static final class66 field800;
   @ObfuscatedName("rp")
   static Preferences field801;
   @ObfuscatedName("j")
   static final class66 field802;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 859545967
   )
   static int field803;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 849739719
   )
   static int field804;
   @ObfuscatedName("p")
   static final class66 field805;
   @ObfuscatedName("i")
   static final class66 field806;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "-45"
   )
   static void method1061(GameEngine var0) {
      if(class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4) {
         int var1 = class92.field1417 + 280;
         if(class59.field723 >= var1 && class59.field723 <= var1 + 14 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(0, 0);
            return;
         }

         if(class59.field723 >= var1 + 15 && class59.field723 <= var1 + 80 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(0, 1);
            return;
         }

         int var2 = class92.field1417 + 390;
         if(class59.field723 >= var2 && class59.field723 <= var2 + 14 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(1, 0);
            return;
         }

         if(class59.field723 >= var2 + 15 && class59.field723 <= var2 + 80 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(1, 1);
            return;
         }

         int var3 = class92.field1417 + 500;
         if(class59.field723 >= var3 && class59.field723 <= var3 + 14 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(2, 0);
            return;
         }

         if(class59.field723 >= var3 + 15 && class59.field723 <= var3 + 80 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(2, 1);
            return;
         }

         int var4 = class92.field1417 + 610;
         if(class59.field723 >= var4 && class59.field723 <= var4 + 14 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(3, 0);
            return;
         }

         if(class59.field723 >= var4 + 15 && class59.field723 <= var4 + 80 && class59.field724 >= 4 && class59.field724 <= 18) {
            class112.method2090(3, 1);
            return;
         }

         if(class59.field723 >= class92.field1417 + 708 && class59.field724 >= 4 && class59.field723 <= class92.field1417 + 708 + 50 && class59.field724 <= 20) {
            class92.worldSelectShown = false;
            class92.field1420.method5164(class92.field1417, 0);
            class92.field1421.method5164(class92.field1417 + 382, 0);
            class71.field845.method5066(class92.field1417 + 382 - class71.field845.originalWidth / 2, 18);
            return;
         }

         if(class92.field1443 != -1) {
            World var5 = World.worldList[class92.field1443];
            Ignore.method1080(var5);
            class92.worldSelectShown = false;
            class92.field1420.method5164(class92.field1417, 0);
            class92.field1421.method5164(class92.field1417 + 382, 0);
            class71.field845.method5066(class92.field1417 + 382 - class71.field845.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)I",
      garbageValue = "55"
   )
   static int method1062(PacketBuffer var0) {
      int var1 = var0.method3400(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3400(5);
      } else if(var1 == 2) {
         var2 = var0.method3400(8);
      } else {
         var2 = var0.method3400(11);
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1975491055"
   )
   static int method1063(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class165.intStackSize];
         var4 = class177.method3390(var3);
      } else {
         var4 = var2?class278.field3737:class37.field515;
      }

      if(var0 == 1000) {
         class165.intStackSize -= 4;
         var4.originalX = class83.intStack[class165.intStackSize];
         var4.originalY = class83.intStack[class165.intStackSize + 1];
         var4.field2681 = class83.intStack[class165.intStackSize + 2];
         var4.field2777 = class83.intStack[class165.intStackSize + 3];
         CombatInfo1.method1515(var4);
         class46.field590.method1418(var4);
         if(var3 != -1 && var4.type == 0) {
            class21.method174(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class165.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class165.intStackSize];
         var4.field2782 = class83.intStack[class165.intStackSize + 1];
         var4.field2659 = class83.intStack[class165.intStackSize + 2];
         var4.field2660 = class83.intStack[class165.intStackSize + 3];
         CombatInfo1.method1515(var4);
         class46.field590.method1418(var4);
         if(var3 != -1 && var4.type == 0) {
            class21.method174(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class165.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            CombatInfo1.method1515(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2678 = class83.intStack[--class165.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2786 = class83.intStack[--class165.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   static {
      field800 = new class66();
      field805 = new class66();
      field806 = new class66();
      field802 = new class66();
   }
}
