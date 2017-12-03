import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field1267;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Lir;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "86"
   )
   void method1620(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.previous()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3717(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lch;",
      garbageValue = "-45"
   )
   CombatInfo1 method1621(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3451 + var2.int2 + var2.cycle > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "963978746"
   )
   boolean method1622() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;Lib;Lib;I)V",
      garbageValue = "1965082159"
   )
   public static void method1629(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      class37.widgetIndex = var0;
      RunException.field2117 = var1;
      KeyFocusListener.field589 = var2;
      Coordinates.field2726 = var3;
      Widget.widgets = new Widget[class37.widgetIndex.size()][];
      class115.validInterfaces = new boolean[class37.widgetIndex.size()];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;B)V",
      garbageValue = "-105"
   )
   public static void method1633(IndexDataBase var0) {
      class262.field3467 = var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "1477104253"
   )
   static final void method1623(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class36.field478.length; ++var2) {
         class36.field478[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class36.field478[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class186.field2532[var5] = (class36.field478[var5 + 128] + class36.field478[var5 - 128] + class36.field478[var5 + 1] + class36.field478[var5 - 1]) / 4;
            }
         }

         int[] var8 = class36.field478;
         class36.field478 = class186.field2532;
         class186.field2532 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class36.field478[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   static void method1630() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(GraphicsObject.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = VertexNormal.getWidget(var4);
               if(var5 != null) {
                  class33.method344(var5);
               }
            }
         }
      }

   }
}
