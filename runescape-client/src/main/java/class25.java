import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class25 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2086105041
   )
   int field346;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   Coordinates field348;

   @ObfuscatedSignature(
      signature = "(ILhy;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field346 = var1;
      this.field348 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-1942493847"
   )
   static int method172(int var0, Script var1, boolean var2) {
      Widget var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++class83.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++class83.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++class83.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++class83.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lhn;III)V",
      garbageValue = "-679277608"
   )
   static final void method171(Widget var0, int var1, int var2) {
      if(Client.field912 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var4 = class3.method6(var0);
            if(var4 == null) {
               var4 = var0.dragParent;
            }

            if(var4 != null) {
               Client.field912 = var0;
               var4 = class3.method6(var0);
               if(var4 == null) {
                  var4 = var0.dragParent;
               }

               Client.field1057 = var4;
               Client.field1073 = var1;
               Client.field1063 = var2;
               Enum.field3384 = 0;
               Client.field1067 = false;
               int var6 = Client.menuOptionCount - 1;
               if(var6 != -1) {
                  class20.field317 = new class89();
                  class20.field317.field1373 = Client.menuActionParams0[var6];
                  class20.field317.field1366 = Client.menuActionParams1[var6];
                  class20.field317.field1367 = Client.menuTypes[var6];
                  class20.field317.field1371 = Client.menuIdentifiers[var6];
                  class20.field317.field1369 = Client.menuOptions[var6];
               }

               return;
            }
         }

      }
   }
}
