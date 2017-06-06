import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class2 implements class0 {
   @ObfuscatedName("z")
   static Widget field15;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 290482183
   )
   static int field16;

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-127497030"
   )
   static void method0() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3518(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3524()) {
         int var1 = var0.id;
         if(RSSocket.method2986(var1)) {
            boolean var2 = true;
            Widget[] var3 = CombatInfo1.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = WorldMapType3.method199(var4);
               if(var5 != null) {
                  class25.method169(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-61"
   )
   static final void method1(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class47.field605[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
