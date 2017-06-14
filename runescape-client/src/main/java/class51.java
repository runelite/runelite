import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class51 implements class103 {
   @ObfuscatedName("t")
   static int[] field641;
   @ObfuscatedName("y")
   static int[][][] field643;
   @ObfuscatedName("z")
   static ScheduledExecutorService field644;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1717443060"
   )
   static int method745(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      } else {
         var3 = var2?class278.field3737:class37.field515;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class165.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4020(var4, class83.scriptStringStack[--ISAACCipher.scriptStringStackSize]);
            return 1;
         } else {
            --ISAACCipher.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class165.intStackSize -= 2;
         var4 = class83.intStack[class165.intStackSize];
         int var5 = class83.intStack[class165.intStackSize + 1];
         var3.dragParent = class29.method254(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2730 = class83.intStack[--class165.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2728 = class83.intStack[--class165.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2729 = class83.intStack[--class165.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "-327640628"
   )
   public class109 vmethod1901() {
      return new class55();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1871681361"
   )
   static int method748(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass219;III)LScript;",
      garbageValue = "1986157340"
   )
   static Script method749(class219 var0, int var1, int var2) {
      int var3 = class111.method2072(var1, var0);
      Script var4 = class6.method26(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         var3 = class169.method3122(var2, var0);
         var4 = class6.method26(var3, var0);
         return var4 != null?var4:null;
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-367607715"
   )
   static final void method750(Widget var0, int var1, int var2) {
      if(Client.field1089 == null && !Client.isMenuOpen) {
         if(var0 != null && WorldMapType3.method230(var0) != null) {
            Client.field1089 = var0;
            Client.field973 = WorldMapType3.method230(var0);
            Client.field1091 = var1;
            Client.field1092 = var2;
            class31.field452 = 0;
            Client.field1100 = false;
            int var3 = Script.method1824();
            if(var3 != -1) {
               class91.field1409 = new class89();
               class91.field1409.field1402 = Client.menuActionParams0[var3];
               class91.field1409.field1397 = Client.menuActionParams1[var3];
               class91.field1409.field1398 = Client.menuTypes[var3];
               class91.field1409.field1401 = Client.menuIdentifiers[var3];
               class91.field1409.field1400 = Client.menuOptions[var3];
            }

         }
      }
   }
}
